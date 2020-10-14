package in.novopay.MessagingCore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.novopay.MessagingCore.constants.MessageApiConstants;
import in.novopay.MessagingCore.service.MessagePlatformService;

@RestController(MessageApiConstants.MESSAGE_REST_CALL)
public class MessageServiceApiResource {

	private final MessagePlatformService messageService;

	@Autowired
	public MessageServiceApiResource(final MessagePlatformService messageService) {
		this.messageService = messageService;
	}

}