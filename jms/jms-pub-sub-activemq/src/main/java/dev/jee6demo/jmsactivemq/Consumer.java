package dev.jee6demo.jmsactivemq;

import javax.jms.*;

public class Consumer implements Runnable{
	private ConnectionFactory connectionFactory;
	// Name of the queue we will receive messages from
	private String queueName;
	private String textMessage;
	public String getTextMessage() {
		return textMessage;
	}

	public Consumer(ConnectionFactory connectionFactory,String queueName){
		this.connectionFactory=connectionFactory;
		this.queueName=queueName;
	}

	public void consume() throws JMSException {
		// Getting JMS connection from the server
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// Getting the queue 'TESTQUEUE'
		Destination destination = session.createQueue(queueName);

		// MessageConsumer is used for receiving (consuming) messages
		MessageConsumer consumer = session.createConsumer(destination);

		// Here we receive the message.
		// By default this call is blocking, which means it will wait
		// for a message to arrive on the queue.
		Message message = consumer.receive();

		// There are many types of Message and TextMessage
		// is just one of them. Producer sent us a TextMessage
		// so we must cast to it to get access to its .getText()
		// method.
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			this.textMessage=textMessage.getText();
			System.out.println("Received message '"
					+ textMessage.getText() + "'");
		}
		connection.close();
	}

	public void run() {
		try{
			consume();
		}catch(JMSException ex){
			ex.printStackTrace();
		}
	}
}