package in.novopay.MessagingCore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.novopay.MessagingCore.constants.MessageApiConstants;
import in.novopay.MessagingCore.data.dto.MessageData;
import in.novopay.MessagingCore.service.MessagePlatformService;

@RestController
@RequestMapping(MessageApiConstants.MESSAGE_REST_CALL)
public class MessageServiceApiResource {

	private final MessagePlatformService messageService;

	@Autowired
	public MessageServiceApiResource(final MessagePlatformService messageService) {
		this.messageService = messageService;
	}

	@GetMapping
	public ResponseEntity<String> getAllMessage() {
		return new ResponseEntity<String>("Response", HttpStatus.OK);

	}

	@PostMapping("/sendMessage")
	public ResponseEntity sendMessage(@RequestBody final MessageData messageData) {
		String output = "";
		return new ResponseEntity("output", HttpStatus.OK);
	}

}