package in.novopay.messenger.data.db;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message extends DatabaseEntity<Long> {

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "sender", nullable = false)
	private String sender;

	@Column(name = "recipient", nullable = false)
	private String recipient;

	@Column(name = "status", nullable = false, columnDefinition = "INT(3) UNSIGNED")
	private int status = 10;

	@Column(name = "send_time")
	private Date sendTime;

	@Column(name = "delivery_time")
	private Date deliveryTime;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "message", cascade = CascadeType.ALL)
	private Set<MessagePart> messageParts;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Set<MessagePart> getMessageParts() {
		return messageParts;
	}

	public void addMessageParts(MessagePart msgPart) {
		messageParts.add(msgPart);
	}

}
