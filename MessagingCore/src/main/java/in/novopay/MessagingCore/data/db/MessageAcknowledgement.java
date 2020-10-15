package in.novopay.MessagingCore.data.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message_ack")
public class MessageAcknowledgement extends DatabaseEntity<Long> {

	@Column(name = "is_ack", nullable = false)
	private boolean isAck = false;

	@Column(name = "ack_message")
	private String ackMessage;

	@Column(name = "ack_time")
	private Date ackTime;
	
	@ManyToOne
	@JoinColumn(name = "message_part_id")
	private MessagePart messagePart;

	public boolean isAck() {
		return isAck;
	}

	public void setAck(boolean isAck) {
		this.isAck = isAck;
	}

	public String getAckMessage() {
		return ackMessage;
	}

	public void setAckMessage(String ackMessage) {
		this.ackMessage = ackMessage;
	}

	public Date getAckTime() {
		return ackTime;
	}

	public void setAckTime(Date ackTime) {
		this.ackTime = ackTime;
	}

}
