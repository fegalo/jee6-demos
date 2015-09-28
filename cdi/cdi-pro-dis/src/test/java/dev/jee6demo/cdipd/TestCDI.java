package dev.jee6demo.cdipd;

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

import dev.jee6demo.cdipd.BeanConsumer;
import dev.jee6demo.cdipd.HelloBean;
import dev.jee6demo.cdipd.MyAnnotation;


@RunWith(WeldJUnit4Runner.class)  
public class TestCDI {  

	@Inject   
	private BeanManager beanManager;  

	@Inject   
	private BeanConsumer beanConsumer; 
	
	@Test
	public void testAlternativeBean()
	{
		assertEquals("The bean contains the followin message: Hello from Alternative Bean!",beanConsumer.use());
	}
	
	@Inject
	@MyAnnotation
	private HelloBean helloBean;
	@Test
	public void testProducerDisposer()
	{
		assertEquals("Hello from BeanFactory",helloBean.getText());
		
	}
}