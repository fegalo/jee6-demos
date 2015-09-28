package dev.jee6demo.cdipd;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class BeanFactory {
	@Produces
	@MyAnnotation
	@ApplicationScoped
	public HelloBean generateBean(){
		System.out.println("--- Produce bean");
		HelloBean helloBean = new HelloBean();
		helloBean.setText("Hello from BeanFactory");
		return helloBean;
	}
	public void disposeBean(@Disposes @MyAnnotation HelloBean helloBean){
		System.out.println("--- Dispose bean");
		helloBean.setText("");	  
	}
}
