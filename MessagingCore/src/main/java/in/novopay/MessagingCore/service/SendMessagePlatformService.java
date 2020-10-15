package in.novopay.MessagingCore.service;

import in.novopay.MessagingCore.data.dto.MessageData;

public interface SendMessagePlatformService {
	boolean sendMessage(MessageData m);
}
