package dev.jee6demo.cdipd;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

public class BeanConsumer {

	@Inject 
	@Alternative
	private HelloBean helloBean;
	
	public String use(){
		return "The bean contains the followin message: "+helloBean.getText();
	}
}