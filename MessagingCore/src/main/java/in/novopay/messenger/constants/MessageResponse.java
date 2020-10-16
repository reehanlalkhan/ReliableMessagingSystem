package in.novopay.messenger.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageResponse {
	//@JsonProperty("default-code")
	MSG_DEFAULT_CODE(10, "Created"),
	//@JsonProperty("message-submitted")
	MSG_SUBMITTED_CODE(20, "Message has been submitted - queued for delivery"),
	//@JsonProperty("message-under-delivery")
	MSG_UNDER_DELIVERY_CODE(30, "Message is under the process of delivery"),
	//@JsonProperty("message-delivered")
	MSG_DELIVERED_CODE(40, "Message has been delivered"),
	//@JsonProperty("retrying-message-delivery")
	MSG_DELIVERY_FAILED_RETRY_CODE(50, "Message delivery has failed - retrying"),
	//@JsonProperty("message-delivery-failed")
	MSG_DELIVERY_FAILED_NORETRY_CODE(60, "Message delivery has failed permanently - no more retry");

	private final Integer responseCode;
	private final String response;

	private MessageResponse(Integer responseCode, String response) {
		this.responseCode = responseCode;
		this.response = response;
	}

	//@JsonValue
	public Integer getResponseCode() {
		return responseCode;
	}

	//@JsonValue
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

	@JsonCreator
	public static MessageResponse forValues(@JsonProperty("code") int code) {
		for (MessageResponse mr : MessageResponse.values()) {
			if (mr.getResponseCode() == code) {
				return mr;
			}
		}

		return null;
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
