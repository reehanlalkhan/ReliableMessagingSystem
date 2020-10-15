package in.novopay.MessagingCore.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.novopay.MessagingCore.data.db.Message;

@Repository
public interface MessageDataDao extends JpaRepository<Message, Long> {
	
	// List<Message> getUnacknowledgedMessages();
}
