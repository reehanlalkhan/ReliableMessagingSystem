
package in.novopay.messenger.service;

import in.novopay.messenger.constants.MessageResponse;
import in.novopay.messenger.data.dto.MessageData;
import in.novopay.messenger.exception.InvalidMessageId;

public interface MessagePlatformService {

	MessageResponse sendMessage(final MessageData messageData);

	MessageResponse getMessageStatus(long messageId) throws InvalidMessageId;

}
