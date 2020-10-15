
package in.novopay.MessagingCore.service;

import in.novopay.MessagingCore.data.dto.MessageData;

public interface MessagePlatformService {
	
	String sendMessage(final MessageData messageData);

}
