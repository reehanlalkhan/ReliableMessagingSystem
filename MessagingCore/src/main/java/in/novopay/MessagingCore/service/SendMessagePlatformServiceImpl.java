package in.novopay.MessagingCore.service;

import org.springframework.beans.factory.annotation.Autowired;

import in.novopay.MessagingCore.data.dao.MessagePartDataDao;
import in.novopay.MessagingCore.data.dto.MessageData;

public class SendMessagePlatformServiceImpl implements SendMessagePlatformService {

	@Autowired
	MessagePartDataDao messagePartDao;

	// MessageData
	@Override
	public boolean sendMessage(MessageData m) {
		int randomNumber = (int) (Math.random() * 10);
		if ((randomNumber % 2) == 0) {
			return true;
		}
		return false;
	}

}
