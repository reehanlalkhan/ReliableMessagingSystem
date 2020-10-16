# Reliable Messaging System
---------------
This is an example reliable messaging system using a Spring Boot application with REST APIs which will guarantee delivery of text messages from the sender to the recipient. 

1. This should include a MySQL data store for each message sent, sender number, recipient number with send time and delivery time. When the message is successfully delivered, the time is updated and an acknowledgement is also recorded in the DB. 

2. When you design the message packet, fix the size of the message body to 150 characters, and additional metadata in the header to store message length , order etc.

3. The length of the actual message from the sender can be longer than 150 characters so implementation should split longer messages into packets, however you must ensure that the messages are delivered in the correct order to the recipient.

4. Implemention needs Send API (called by Sender) , Message API (To send message to Recipient), Acknowledge API (called by Recipient) and Status API  (called by Sender)  to meet above requirement. 

5. Send, Acknowledge and Status would be called externally. Message API is internally called by Send API

6. No need to have call or implement the actual sending of messages through the network. Assume it would work through some messaging gateway (use a stub, always returning success)

## DB Details
---------------
* Database name is: **novo_message**
* SQLs to create required tables are under the folder: **SQLs**
* Project content is under the folder: **MessagingCore**
