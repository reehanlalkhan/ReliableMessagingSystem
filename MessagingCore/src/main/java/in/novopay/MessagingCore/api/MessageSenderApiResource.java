package in.novopay.MessagingCore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.novopay.MessagingCore.constants.MessageApiConstants;
import in.novopay.MessagingCore.data.dto.MessageData;
import in.novopay.MessagingCore.service.SendMessagePlatformService;

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