package dev.jee6demo.ejbstart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.jee6demo.ejbstart.Hello;

public class TestHello1 {

	private static EJBContainer ejbContainer;

	private Hello hellobean;

	@BeforeClass
	public static void startTheContainer() {
		ejbContainer = EJBContainer.createEJBContainer();
	}
	
	@AfterClass
	public static void stopTheContainer() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void lookupABean() throws NamingException {
		// --- glassfish ---
		// "java:global/classes/HelloBean"
		// --- openejb ---
		// "java:global/ejb-start/HelloBean"
		Object object = ejbContainer.getContext().lookup("java:global/ejb-start/HelloBean");
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
