package in.novopay.messenger.exception;

public class MessageSizeLimitExceeded extends Exception {
	public MessageSizeLimitExceeded() {
		super("Message size has exceeded the provided limit of message size");
	}
}
