package in.novopay.messenger.constants;

public interface MessageApiConstants {

	String extMessageServiceRESTName = "message";
	String intMessageServiceRESTName = "sndmsg";
	String SLASH = "/";
	String HYPHEN = "-";
	String VERSION = "v1";
	String PORT = "server.port";
	int MSG_SIZE = 500;
	String MESSAGE_REST_CALL = SLASH + VERSION + SLASH + extMessageServiceRESTName;

	String SEND_MESSAGE_REST_CALL = SLASH + VERSION + SLASH + intMessageServiceRESTName;

	int MSG_PART_SIZE = 150;
}
