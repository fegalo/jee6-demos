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

public class TestHello2Context {

	private static EJBContainer ejbContainer;
	private static Context ctx;
	private Hello hellobean;

	@BeforeClass
	public static void startTheContainer() throws NamingException {
		Properties p = new Properties();
		//p.put("java.naming.factory.initial", "org.apache.openejb.client.LocalInitialContextFactory");
		p.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
		ctx = new InitialContext(p);
	}
	
	@AfterClass
	public static void stopTheContainer() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void lookupABean() throws NamingException {
		Object object = ctx.lookup("java:global/classpath.ear/ejb-start/HelloBean");
		assertTrue(object instanceof Hello);
		hellobean = (Hello) object;
	}

	@Test
	public void testEjb() {
		String text=hellobean.sayHello("Ralph");
		System.out.println(text);
		assertEquals(text, "Hello Ralph");

	}
}
