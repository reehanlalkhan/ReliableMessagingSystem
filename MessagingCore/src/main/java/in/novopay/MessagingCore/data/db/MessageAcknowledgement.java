package in.novopay.MessagingCore.data.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageAcknowledgement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "sender", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int sender;
	
	@Column(name = "recipient", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	private int recipient;

	@Column(name = "status", nullable = false, columnDefinition = "INT(3) UNSIGNED")
	private int status = 10;

	@Column(name = "send_time")
	private Date sendTime;

	@Column(name = "delivery_time")
	private Date deliveryTime;

}
