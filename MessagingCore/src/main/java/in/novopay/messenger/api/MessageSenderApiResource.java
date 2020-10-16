package in.novopay.messenger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.novopay.messenger.constants.MessageApiConstants;
import in.novopay.messenger.data.dto.MessageData;
import in.novopay.messenger.service.SendMessagePlatformService;

@RestController
@RequestMapping(MessageApiConstants.SEND_MESSAGE_REST_CALL)
public class MessageSenderApiResource {

	private final SendMessagePlatformService sendMessageService;

	@Autowired
	public MessageSenderApiResource(final SendMessagePlatformService sendMessageService) {
		this.sendMessageService = sendMessageService;
	}

	@PostMapping()
	public boolean getMessageStatus(MessageData data) {
		return sendMessageService.sendMessage(data);
	}

}