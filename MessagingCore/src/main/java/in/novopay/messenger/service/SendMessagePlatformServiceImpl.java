package in.novopay.messenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.novopay.messenger.data.dao.MessagePartDataDao;
import in.novopay.messenger.data.dto.MessageData;

@Service
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
