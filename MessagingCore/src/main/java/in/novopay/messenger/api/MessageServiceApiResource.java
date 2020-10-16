package in.novopay.messenger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.novopay.messenger.constants.MessageApiConstants;
import in.novopay.messenger.constants.MessageResponse;
import in.novopay.messenger.data.dto.MessageData;
import in.novopay.messenger.exception.InvalidMessageId;
import in.novopay.messenger.exception.MessageSizeLimitExceeded;
import in.novopay.messenger.service.MessagePlatformService;

@RestController
@RequestMapping(MessageApiConstants.MESSAGE_REST_CALL)
public class MessageServiceApiResource {

	private final MessagePlatformService messageService;

	@Autowired
	public MessageServiceApiResource(final MessagePlatformService messageService) {
		this.messageService = messageService;
	}

	//@GetMapping("/{messageId}")
	@RequestMapping(value ="/{messageId}", produces =MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<MessageResponse> getMessageStatus(@PathVariable long messageId) throws InvalidMessageId {
		MessageResponse response = messageService.getMessageStatus(messageId);
		return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);

	}

	@PostMapping("/sendMessage")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MessageResponse> sendMessage(@RequestBody final MessageData messageData) throws MessageSizeLimitExceeded {
		MessageResponse response = messageService.sendMessage(messageData);
		return new ResponseEntity<MessageResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/{messageId}/{partId}")
	public HttpStatus acknowledgeMessage(@PathVariable long messageId, @PathVariable long partId) {
		messageService.acknowledgeMessage(messageId, partId);
		return HttpStatus.OK;
	}

}