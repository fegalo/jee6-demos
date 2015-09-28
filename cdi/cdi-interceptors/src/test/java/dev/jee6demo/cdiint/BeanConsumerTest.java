package dev.jee6demo.cdiint;

import static org.junit.Assert.*;

import java.util.Set;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.Any;
import javax.enterprise.util.AnnotationLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import dev.jee6demo.cdiint.BeanConsumer;

public class BeanConsumerTest 
{
	@Test
	public void testInjection()
	{
		Weld weld = new Weld();
		//Runtime.getRuntime().addShutdownHook(new ShutdownHook(weld));
		WeldContainer container = weld.initialize();
		BeanConsumer beanConsumer=container.instance().select(BeanConsumer.class).get();
		assertEquals("The bean contains the followin message: Hello World!-intercepted-",beanConsumer.use());
		weld.shutdown();
	}
	@Test
	public void testShowBeansList(){
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BeanManager beanManager=container.getBeanManager();
		Set<Bean<?>> beans = beanManager.getBeans(Object.class,new AnnotationLiteral<Any>(){});
        for (Bean<?> bean : beans) {
            System.out.println(bean.getBeanClass().getName());
        }
		weld.shutdown();
		assertTrue( true );
	}
}
