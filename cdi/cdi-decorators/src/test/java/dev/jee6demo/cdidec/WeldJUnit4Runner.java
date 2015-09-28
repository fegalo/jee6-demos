package dev.jee6demo.cdidec;

import org.jboss.weld.environment.se.Weld;  
import org.jboss.weld.environment.se.WeldContainer;  
import org.junit.runners.BlockJUnit4ClassRunner;  
import org.junit.runners.model.InitializationError;  
  
  
public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {  
  
    private final Class<?> klass;  
    private final Weld weld;  
    private final WeldContainer container;  
  
    public WeldJUnit4Runner(final Class<Object> klass) throws InitializationError {  
        super(klass);  
        this.klass = klass;  
        this.weld = new Weld();  
        Runtime.getRuntime().addShutdownHook(new ShutdownHook(weld));
        this.container = weld.initialize();  
    }  
  
    @Override  
    protected Object createTest() throws Exception {  
        final Object test = container.instance().select(klass).get();  
        return test;  
    }
    /**
     * @see https://github.com/weld/core/pull/444
     *
     */
    static class ShutdownHook extends Thread {
        private final Weld weld;

        ShutdownHook(Weld weld) {
            this.weld = weld;
        }

        public void run() {
            weld.shutdown();
        }
    }
} 
