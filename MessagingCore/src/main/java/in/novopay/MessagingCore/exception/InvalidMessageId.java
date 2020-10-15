package in.novopay.MessagingCore.exception;

public class InvalidMessageId extends Exception {
	public InvalidMessageId(final long messageId) {
		super("Message with message ID: " + messageId + " does not exist!");
	}
}
