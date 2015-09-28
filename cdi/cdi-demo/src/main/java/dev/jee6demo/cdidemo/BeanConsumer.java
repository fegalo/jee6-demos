package dev.jee6demo.cdidemo;

import javax.inject.Inject;

public class BeanConsumer {

	@Inject 
	private HelloBean helloBean;
	
	public String use(){
		return "The bean contains the followin message: "+helloBean.getText();
	}
}