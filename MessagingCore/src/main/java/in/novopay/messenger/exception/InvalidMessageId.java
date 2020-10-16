package in.novopay.messenger.exception;

public class InvalidMessageId extends Exception {
	public InvalidMessageId(final long messageId) {
		super("Message with message ID: " + messageId + " does not exist!");
	}
}
