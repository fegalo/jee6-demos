package dev.jee6demo.jsfstart;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "myBean", eager = true)
@SessionScoped
public class MyBean {
	private String message;

	public MyBean() {
		super();
		System.out.println("MyBean created!");
		message="This is my message";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
