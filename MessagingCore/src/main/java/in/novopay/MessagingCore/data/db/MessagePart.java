package in.novopay.MessagingCore.data.db;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class MessagePart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "start_offset", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int startOffset;

	@Column(name = "end_offset", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int endOffset;

	@Column(name = "is_last", nullable = false)
	private boolean isLast = false;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MessageAcknowledgement", cascade = CascadeType.ALL)
	private Set<MessageAcknowledgement> messageAcknwoledgement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStartOffset() {
		return startOffset;
	}

	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	public int getEndOffset() {
		return endOffset;
	}

	public void setEndOffset(int endOffset) {
		this.endOffset = endOffset;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

	public Set<MessageAcknowledgement> getMessageAcknwoledgement() {
		return messageAcknwoledgement;
	}

	public void setMessageAcknwoledgement(Set<MessageAcknowledgement> messageAcknwoledgement) {
		this.messageAcknwoledgement = messageAcknwoledgement;
	}
}
