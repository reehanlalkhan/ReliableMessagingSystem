package in.novopay.MessagingCore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.novopay.MessagingCore.data.dao.MessageDataDao;
import in.novopay.MessagingCore.data.db.Message;
import in.novopay.MessagingCore.data.dto.MessageData;

@Service
public class MessagePlatformServiceImpl implements MessagePlatformService {

	private final static Logger logger = LoggerFactory.getLogger(MessagePlatformServiceImpl.class);
	
	@Autowired
	MessageDataDao messageDao;

	@Override
	public String sendMessage(MessageData messageData) {
		logger.debug("Data:" + messageData);
		Message m = new Message();
		m.setMessage(messageData.getMessage());
		m.setSender(messageData.getSender());
		m.setRecipient(messageData.getRecipient());
		messageDao.saveAndFlush(m);
		return "";
	}

}
