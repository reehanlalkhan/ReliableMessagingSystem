
package in.novopay.MessagingCore.service;

import in.novopay.MessagingCore.constants.MessageResponse;
import in.novopay.MessagingCore.data.dto.MessageData;
import in.novopay.MessagingCore.exception.InvalidMessageId;

public interface MessagePlatformService {

	MessageResponse sendMessage(final MessageData messageData);

	MessageResponse getMessageStatus(long messageId) throws InvalidMessageId;

}
