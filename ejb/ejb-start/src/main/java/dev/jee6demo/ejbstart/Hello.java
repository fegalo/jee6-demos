package dev.jee6demo.ejbstart;

import javax.ejb.Remote;

@Remote
public interface Hello {
	public String sayHello(String s);
}
