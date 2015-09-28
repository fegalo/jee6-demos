package dev.jee6demo.cdiint;

import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyInterceptor {
	@AroundInvoke
    public Object logCall(InvocationContext context) throws Exception{
        System.out.println("--- Method: " + context.getMethod());
        System.out.println("--- Parameters: " + Arrays.asList(context.getParameters()));
        Object returnedObject=context.proceed();	//call method
        if(returnedObject instanceof String){		//modify returned String
        	returnedObject=((String)returnedObject)+"-intercepted-";
        }
        return returnedObject;
    }
}
