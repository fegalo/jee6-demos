package dev.jee6demo.cdidec;

import javax.inject.Inject;

public class BeanConsumerImpl implements BeanConsumer {

	@Inject 
	private HelloBean helloBean;
	
	public String use(){
		return "The bean contains the followin message: "+helloBean.getText();
	}
}