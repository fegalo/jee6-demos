package dev.jee6demo.jmspubsub;

import javax.jms.*;
/**
 * Class from
 * http://www.javablogging.com/simple-guide-to-java-message-service-jms-using-activemq/
 *
 */
public class Producer implements Runnable{
	private ConnectionFactory connectionFactory;
	// Name of the queue we will receive messages from
	private String queueName;
	
	private String textMessage;
	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public Producer(ConnectionFactory connectionFactory,String queueName){
		this.connectionFactory=connectionFactory;
		this.queueName=queueName;
	}

	public void produce() throws JMSException {
		// Getting JMS connection from the server and starting it
		Connection connection = connectionFactory.createConnection();
		connection.start();

		// JMS messages are sent and received using a Session. We will
		// create here a non-transactional session object. If you want
		// to use transactions you should set the first parameter to 'true'
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// Destination represents here our queue 'TESTQUEUE' on the
		// JMS server. You don't have to do anything special on the
		// server to create it, it will be created automatically.
		Destination destination = session.createQueue(queueName);

		// MessageProducer is used for sending messages (as opposed
		// to MessageConsumer which is used for receiving them)
		MessageProducer producer = session.createProducer(destination);

		// We will send a small text message saying 'Hello' in Japanese
		TextMessage message = session.createTextMessage("Hello OpenMQ");

		// Here we are sending the message!
		producer.send(message);
		textMessage=message.getText();
		System.out.println("Sent message '" + message.getText() + "'");
		connection.close();
	}
	public void run() {
		try{
			produce();
		}catch(JMSException ex){
			ex.printStackTrace();
		}
	}
}
