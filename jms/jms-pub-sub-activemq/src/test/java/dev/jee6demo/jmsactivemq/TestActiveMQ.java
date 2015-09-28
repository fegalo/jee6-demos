package dev.jee6demo.jmsactivemq;

import static org.junit.Assert.*;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestActiveMQ {
	static ConnectionFactory connectionFactory;
	private static String queueName;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
		queueName="TESTQUEUE";
	}

	@Test
	public void testProducerAndConsumer() throws JMSException, InterruptedException {
		
		Consumer consumer=new Consumer(connectionFactory,queueName);
		Thread threadConsumer=new Thread(consumer);
		threadConsumer.start();
		
		Producer producer=new Producer(connectionFactory,queueName);
		new Thread(producer).start();
		threadConsumer.join(5000);//wait until send and receive the message
		
		assertEquals(producer.getTextMessage(),consumer.getTextMessage());
	}
}

