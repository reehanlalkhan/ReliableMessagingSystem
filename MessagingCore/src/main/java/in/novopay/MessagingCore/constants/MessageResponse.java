package in.novopay.MessagingCore.constants;

public enum MessageResponse {
	MSG_DEFAULT_CODE(10, "Created"), MSG_SUBMITTED_CODE(20, "Message has been submitted - queued for delivery"),
	MSG_UNDER_DELIVERY_CODE(30, "Message is under the process of delivery"),
	MSG_DELIVERED_CODE(40, "Message has been delivered"),
	MSG_DELIVERY_FAILED_RETRY_CODE(50, "Message delivery has failed - retrying"),
	MSG_DELIVERY_FAILED_NORETRY_CODE(60, "Message delivery has failed permanently - no more retry");

	private final Integer responseCode;
	private final String response;

	private MessageResponse(Integer responseCode, String response) {
		this.responseCode = responseCode;
		this.response = response;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public String getResponse() {
		return response;
	}

	public static MessageResponse getResponseCode(int code) {
		MessageResponse result = null;
		switch (code) {
		case 10:
			result = MSG_DEFAULT_CODE;
			break;
		case 20:
			result = MSG_SUBMITTED_CODE;
			break;
		case 30:
			result = MSG_UNDER_DELIVERY_CODE;
			break;
		case 40:
			result = MSG_DELIVERED_CODE;
			break;
		case 50:
			result = MSG_DELIVERY_FAILED_RETRY_CODE;
			break;
		case 60:
			result = MSG_DELIVERY_FAILED_NORETRY_CODE;
			break;

		default:
			break;
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{response-code:");
		sb.append(getResponseCode());
		sb.append(",response-message:");
		sb.append(getResponse());
		sb.append("}");
		return sb.toString();
	}
}
