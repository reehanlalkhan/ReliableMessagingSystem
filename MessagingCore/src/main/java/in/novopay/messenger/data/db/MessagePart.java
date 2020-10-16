package in.novopay.messenger.data.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message_part")
public class MessagePart extends DatabaseEntity<Long> {

	@Column(name = "start_offset", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int startOffset;

	@Column(name = "end_offset", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int endOffset;

	@Column(name = "message_part")
	private String messagePart;

	@Column(name = "is_last", nullable = false)
	private boolean isLast = false;

	@Column(name = "is_acknowledged", nullable = false)
	private boolean isAcknowledged = false;

	@ManyToOne
	@JoinColumn(name = "message_id")
	private Message message;

	@Column(name = "is_delivered", nullable = false)
	private boolean isDelivered;

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

	public String getMessagePart() {
		return messagePart;
	}

	public void setMessagePart(String messagePart) {
		this.messagePart = messagePart;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

	public boolean getIsAcknowledged() {
		return this.isAcknowledged;
	}

	public void setIsAcknowledged(boolean isAcknowledged) {
		this.isAcknowledged = isAcknowledged;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public boolean getIsDelivered() {
		return this.isDelivered;
	}

	public void setIsDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
}
