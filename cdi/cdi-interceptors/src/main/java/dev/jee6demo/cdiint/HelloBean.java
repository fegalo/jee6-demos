package dev.jee6demo.cdiint;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptors;

@ApplicationScoped
@Interceptors(MyInterceptor.class)
public class HelloBean {  
	
	private String text="Hello World!";

	public String getText() {  
		return text;  
	}
	public void setText(String text) {
		this.text = text;
	}  
	@PostConstruct
	void initialize() { 
		System.out.println("+++ PostConstruct method +++");
	}
	
	@PreDestroy
	void cleanup() {
		System.out.println("+++ PreDestroy method +++");
	}
}