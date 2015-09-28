package dev.jee6demo.cdidemo;

import javax.inject.Inject;
import javax.inject.Named;

public class BeanConsumer {

	@Inject 
	@Named("type1")
	private HelloBean helloBean;
	
	public String use(){
		return "The bean contains the followin message: "+helloBean.getText();
	}
}