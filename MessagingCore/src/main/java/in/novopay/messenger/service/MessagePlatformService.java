
package in.novopay.messenger.service;

import in.novopay.messenger.constants.MessageResponse;
import in.novopay.messenger.data.dto.MessageData;
import in.novopay.messenger.exception.InvalidMessageId;
import in.novopay.messenger.exception.MessageSizeLimitExceeded;

public interface MessagePlatformService {

	MessageResponse sendMessage(final MessageData messageData) throws MessageSizeLimitExceeded;

	MessageResponse getMessageStatus(long messageId) throws InvalidMessageId;

}
