package in.novopay.messenger.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.novopay.messenger.constants.MessageApiConstants;
import in.novopay.messenger.data.dto.MessageData;

public class RestMessagingUtil implements MessageApiConstants {
	private final static Logger logger = LoggerFactory.getLogger(RestMessagingUtil.class);

	public static boolean sendRequest(RestTemplate restTemplate, Environment env, MessageData data) {
		String port = env.getProperty(PORT);
		String url = "http://localhost:" + port + SEND_MESSAGE_REST_CALL;

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Map<String, Object> map = new HashMap<>();
		map.put("message", data.getMessage());
		map.put("recipient", data.getRecipient());
		map.put("sender", data.getSender());

		// build the request
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		// send POST request
		ResponseEntity<Boolean> response = restTemplate.postForEntity(url, entity, Boolean.class);

		if (response.getStatusCode() == HttpStatus.CREATED) {
			logger.debug("RestMessagingUtil.sendRequest:Request Successful");
			logger.debug("RestMessagingUtil.sendRequest:" + response.getBody());
			return response.getBody();
		} else {
			logger.debug("Request Failed");
			logger.debug("RestMessagingUtil.sendRequest:" + response.getStatusCode());
		}

		return false;
	}
}
