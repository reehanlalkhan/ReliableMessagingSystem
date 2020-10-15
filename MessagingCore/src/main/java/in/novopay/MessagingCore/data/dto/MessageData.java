package in.novopay.MessagingCore.data.dto;

import java.io.Serializable;

public class MessageData implements Comparable<MessageData>, Serializable {
	private final static long serialVersionUID = 194511097543456371L;

	private final String message;
	private final String sender;
	private final String recipient;

	public static MessageData instance(final String message, final String sender, final String recipient) {
		return new MessageData(message, sender, recipient);
	}

	protected MessageData(final String message, final String sender, final String recipient) {
		this.message = message;
		this.sender = sender;
		this.recipient = recipient;
	}

	public String getMessage() {
		return message;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	private String getAllPartsCombinedString() {
		StringBuffer sb = new StringBuffer();
		sb.append(message);
		sb.append(sender);
		sb.append(recipient);
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{message:");
		sb.append(message);
		sb.append(",sender:");
		sb.append(sender);
		sb.append(",recipient:");
		sb.append(recipient);
		sb.append("}");
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