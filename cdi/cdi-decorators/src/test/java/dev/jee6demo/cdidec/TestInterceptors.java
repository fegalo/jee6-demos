package dev.jee6demo.cdidec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;  

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;  
import org.junit.runner.RunWith;  

import dev.jee6demo.cdidec.BeanConsumerImpl;


@RunWith(WeldJUnit4Runner.class)  
public class TestInterceptors {  


	@Inject   
	private BeanConsumerImpl beanConsumer; 
	
	@Test
	public void testInjection()
	{
		assertEquals("The bean contains the followin message: Hello World!-intercepted--decorator-",beanConsumer.use());
	}

}