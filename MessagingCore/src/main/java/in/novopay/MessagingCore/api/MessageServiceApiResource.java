package in.novopay.MessagingCore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.novopay.MessagingCore.constants.MessageApiConstants;
import in.novopay.MessagingCore.constants.MessageResponse;
import in.novopay.MessagingCore.data.dto.MessageData;
import in.novopay.MessagingCore.exception.InvalidMessageId;
import in.novopay.MessagingCore.service.MessagePlatformService;

@RestController
@RequestMapping(MessageApiConstants.MESSAGE_REST_CALL)
public class MessageServiceApiResource {

	private final MessagePlatformService messageService;

	@Autowired
	public MessageServiceApiResource(final MessagePlatformService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/{messageId}")
	public ResponseEntity<MessageResponse> getMessageStatus(@PathVariable long messageId) throws InvalidMessageId {
		MessageResponse response = messageService.getMessageStatus(messageId);
		return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);

	}

	@PostMapping("/sendMessage")
	public ResponseEntity<MessageResponse> sendMessage(@RequestBody final MessageData messageData) {
		MessageResponse response = messageService.sendMessage(messageData);
		return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/{messageId}/{partId}")
	public ResponseEntity acknowledgeMessage(@PathVariable long messageId, @PathVariable long partId) {
		MessageResponse response = MessageResponse.MSG_DEFAULT_CODE;
		return new ResponseEntity(response.getResponse(), HttpStatus.OK);
	}

}