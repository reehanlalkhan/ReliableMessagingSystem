package in.novopay.MessagingCore.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.novopay.MessagingCore.data.db.MessageAcknowledgement;

@Repository
public interface MessageAckDataDao extends JpaRepository<MessageAcknowledgement, Long> {
	
	// List<Message> getUnacknowledgedMessages();
}
