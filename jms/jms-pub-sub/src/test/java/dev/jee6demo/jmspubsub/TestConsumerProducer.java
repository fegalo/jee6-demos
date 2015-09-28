package dev.jee6demo.jmspubsub;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.jmq.jmsclient.runtime.BrokerInstance;
import com.sun.messaging.jmq.jmsclient.runtime.ClientRuntime;

import dev.jee6demo.jmspubsub.Consumer;
import dev.jee6demo.jmspubsub.EmbeddedBrokerExample;
import dev.jee6demo.jmspubsub.Producer;

public class TestConsumerProducer {
	static BrokerInstance brokerInstance;
	static ConnectionFactory connectionFactory;
	private static String queueName;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initBroker();
		com.sun.messaging.ConnectionFactory openQMconnectionFactory=new com.sun.messaging.ConnectionFactory();
		openQMconnectionFactory.setProperty(ConnectionConfiguration.imqAddressList, "mq://localhost/direct");
		connectionFactory=openQMconnectionFactory;
		queueName="TESTQUEUE";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		stopBroker();
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
	
	private static void initBroker() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		ClientRuntime clientRuntime = ClientRuntime.getRuntime();
		brokerInstance = clientRuntime.createBrokerInstance();
		final String IMQ_HOME = EmbeddedBrokerExample.class.getClassLoader().getResource("openmq").getPath();
		Properties props = brokerInstance.parseArgs(new String[]{
				"-imqhome", IMQ_HOME
		});
		brokerInstance.init(props, null);	
		brokerInstance.start();
	}
	
	private static void stopBroker() {
		brokerInstance.stop();	
		brokerInstance.shutdown();
	}
}

