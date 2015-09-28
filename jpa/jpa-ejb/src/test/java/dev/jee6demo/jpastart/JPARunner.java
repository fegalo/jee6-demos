package dev.jee6demo.jpastart;

import java.lang.reflect.Constructor;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import junit.framework.TestCase;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class JPARunner extends BlockJUnit4ClassRunner {  
  
    private final Class<?> klass;
    private final Context context;

  
    public JPARunner(final Class<Object> klass) throws InitializationError {  
        super(klass);  
        this.klass = klass;  
        this.context=EJBContainer.createEJBContainer(new Properties()).getContext();
    }  
  
    @Override  
    protected Object createTest() throws Exception{  
    	Constructor<?> ctor = klass.getConstructor();
    	Object test = ctor.newInstance(new Object[] {});
    	context.bind("inject", test);
        return test;  
    }

}
