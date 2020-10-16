package in.novopay.messenger.service;

import in.novopay.messenger.data.dto.MessageData;

public interface SendMessagePlatformService {
	boolean sendMessage(MessageData m);
}
