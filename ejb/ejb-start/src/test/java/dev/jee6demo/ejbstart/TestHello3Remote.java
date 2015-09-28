package dev.jee6demo.ejbstart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.jee6demo.ejbstart.Hello;

public class TestHello3Remote {

	/**
	 * Test Local
	 * @throws NamingException 
	 */
	@Test
	public void testLocal() throws NamingException {
		Properties properties = new Properties();
	    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
	    InitialContext localContext = new InitialContext(properties);
		
		Object object = localContext.lookup("java:global/classpath.ear/ejb-start/HelloBean");
		assertTrue(object instanceof Hello);
		Hello hellobean = (Hello) object;
		
		String text=hellobean.sayHello("Ralph");
		System.out.println(text);
		assertEquals(text, "Hello Ralph");

	}
	
	/**
	 * Test Remote
	 * @throws NamingException 
	 */
	@Test
	public void testRemote() throws NamingException {
		Properties properties = new Properties();
		properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
		properties.setProperty(Context.PROVIDER_URL, "ejbd://localhost:4201");
		InitialContext remoteContext = new InitialContext(properties);
		
		Object object = remoteContext.lookup("java:global/classpath.ear/ejb-start/HelloBean");
		assertTrue(object instanceof Hello);
		Hello hellobean = (Hello) object;
		
		String text=hellobean.sayHello("Ralph");
		System.out.println(text);
		assertEquals(text, "Hello Ralph");

	}
}
