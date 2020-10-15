package in.novopay.MessagingCore.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.novopay.MessagingCore.constants.MessageApiConstants;
import in.novopay.MessagingCore.constants.MessageResponse;
import in.novopay.MessagingCore.data.dao.MessageDataDao;
import in.novopay.MessagingCore.data.dao.MessagePartDataDao;
import in.novopay.MessagingCore.data.db.Message;
import in.novopay.MessagingCore.data.db.MessagePart;
import in.novopay.MessagingCore.data.dto.MessageData;
import in.novopay.MessagingCore.exception.InvalidMessageId;
import in.novopay.MessagingCore.utils.NovoStringUtils;

@Service
public class MessagePlatformServiceImpl implements MessagePlatformService, MessageApiConstants {

	private final static Logger logger = LoggerFactory.getLogger(MessagePlatformServiceImpl.class);

	@Autowired
	MessageDataDao messageDao;

	@Autowired
	MessagePartDataDao messagePartDao;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public MessageResponse sendMessage(MessageData messageData) {
		logger.debug("MessagePlatformServiceImpl.sendMessage::Data:" + messageData);
		Message m = new Message();
		m.setMessage(messageData.getMessage());
		m.setSender(messageData.getSender());
		m.setRecipient(messageData.getRecipient());
		messageDao.saveAndFlush(m);

		new Thread() {
			public void run() {
				sendMessageInParts(m);
			}
		}.start();
		return MessageResponse.MSG_SUBMITTED_CODE;
	}

	public void sendMessageInParts(Message m) {
		String msg = m.getMessage();
		int length = msg.length();
		List<MessagePart> listOfMessagesToBeDelivered = new ArrayList<MessagePart>();

		logger.debug("MessagePlatformServiceImpl.sendMessageInParts::Message:" + msg);
		if (length < 150) {
			MessagePart mp = new MessagePart();
			mp.setMessage(m);
			mp.setStartOffset(0);
			mp.setEndOffset(length);
			mp.setMessagePart(msg);
			mp.setLast(true);
			messagePartDao.saveAndFlush(mp);
			listOfMessagesToBeDelivered.add(mp);
		} else {
			List<String> parts = NovoStringUtils.splitEqually(msg, MSG_PART_SIZE);
			int start = 0;
			for (String part : parts) {
				logger.debug("MessagePlatformServiceImpl.sendMessageInParts::Message part:" + part);
				MessagePart mp = new MessagePart();
				mp.setMessage(m);
				mp.setStartOffset(start);
				mp.setMessagePart(part);
				int partlen = part.length();
				mp.setEndOffset(start + partlen);
				if (partlen < MSG_PART_SIZE) {
					mp.setLast(true);
				} else {
					mp.setLast(false);
					start += partlen;
				}
				messagePartDao.saveAndFlush(mp);
				listOfMessagesToBeDelivered.add(mp);
			}
		}
		m.setStatus(MessageResponse.MSG_UNDER_DELIVERY_CODE.getResponseCode());
		messageDao.saveAndFlush(m);
	}

	private void submitMessageToService(List<MessagePart> messagesToBeDelivered) {
		String sender = messagesToBeDelivered.get(0).getMessage().getSender();
		String recipient = messagesToBeDelivered.get(0).getMessage().getRecipient();
		for (MessagePart messagePart : messagesToBeDelivered) {
			MessageData data = MessageData.instance(messagePart.getMessagePart(), sender, recipient);

			// Build URI
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/sndmsg").buildAndExpand().toUri();
			boolean result = restTemplate.postForObject(location, data, Boolean.class);
			if(result == true) {
				messagePart.setIsDelivered(true);
			} else {
				messagePart.setIsDelivered(false);
				break;
			}

		}
	}

	@Override
	public MessageResponse getMessageStatus(long messageId) throws InvalidMessageId {
		try {
			Message m = messageDao.getOne(messageId);
			int status = m.getStatus();
			return MessageResponse.getResponseCode(status);
		} catch (EntityNotFoundException exp) {
			throw new InvalidMessageId(messageId);
		}
	}

}
