package dev.jee6demo.cdievent;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class BeanConsumer {

	@Inject 
	private HelloBean helloBean;
	
	@Inject Event<HelloEvent> events;
	
	public String use(){
		events.fire(new HelloEvent("from bean " + System.currentTimeMillis()));
		return "The bean contains the followin message: "+helloBean.getText();
	}
}