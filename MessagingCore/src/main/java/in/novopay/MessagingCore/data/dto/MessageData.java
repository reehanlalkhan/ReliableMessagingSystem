package in.novopay.MessagingCore.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import in.novopay.MessagingCore.data.db.MessagePart;

/**
 * Immutable data object for service charge data
 */
public class MessageData implements Comparable<MessageData>, Serializable {
	private final static long serialVersionUID = 194511097543456371L;

	private final String message;
	private final int sender;
	private final int recipient;
	private final int status;
	private final Date sendTime;
	private final Date deliveryTime;
	private final List<MessagePart> messageParts;

	public static MessageData instance(final String message, final int sender, final int recipient, final int status,
			final Date sendTime, final Date deliveryTime, final List<MessagePart> messagePart) {

		return new MessageData(message, sender, recipient, status, sendTime, deliveryTime, messagePart);
	}

	protected MessageData(final String message, final int sender, final int recipient, final int status,
			final Date sendTime, final Date deliveryTime, final List<MessagePart> messagePart) {
		this.message = message;
		this.sender = sender;
		this.recipient = recipient;
		this.status = status;
		this.sendTime = sendTime;
		this.deliveryTime = deliveryTime;
		this.messageParts = messagePart;
	}

	public List<MessagePart> getMessageParts() {
		return messageParts;
	}

	public void addMessageParts(MessagePart mp) {
		messageParts.add(mp);
	}

	private StringBuffer appendIfNotNull(Object o, StringBuffer sb) {
		if (o != null) {
			sb.append(o);
		}
		return sb;
	}

	private String getAllPartsCombinedString() {
		StringBuffer sb = new StringBuffer();
		sb.append(message);
		sb.append(sender);
		sb.append(recipient);
		sb.append(status);
		sb = appendIfNotNull(sendTime, sb);
		sb = appendIfNotNull(deliveryTime, sb);
		return sb.toString();
	}

	@Override
	public boolean equals(final Object obj) {
		final MessageData data = (MessageData) obj;
		return this.getAllPartsCombinedString().equals(data.getAllPartsCombinedString());
	}

	@Override
	public int hashCode() {
		return this.getAllPartsCombinedString().hashCode();
	}

	@Override
	public int compareTo(final MessageData obj) {
		if (obj == null) {
			return -1;
		}
		return obj.getAllPartsCombinedString().compareTo(this.getAllPartsCombinedString());
	}

}