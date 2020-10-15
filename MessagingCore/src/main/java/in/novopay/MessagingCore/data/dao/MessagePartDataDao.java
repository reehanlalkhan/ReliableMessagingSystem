package in.novopay.MessagingCore.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.novopay.MessagingCore.data.db.MessagePart;

@Repository
public interface MessagePartDataDao extends JpaRepository<MessagePart, Long> {
	
	// List<Message> getUnacknowledgedMessages();
}
