package in.novopay.messenger.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.novopay.messenger.data.db.MessagePart;

@Repository
public interface MessagePartDataDao extends JpaRepository<MessagePart, Long> {
	@Query("select msgPart from MessagePart msgPart where msgPart.id = msgId "
			+ "and msgPart.message.id = partId")
	MessagePart getMessagePartWithMessageIdPartId(long msgId, long partId);
	
	@Query("select msgPart from MessagePart msgPart where msgPart.id = msgId")
	List<MessagePart> getAllPartsForMessageId(long msgId);
}
