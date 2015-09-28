package dev.jee6demo.ejbtimer;

import javax.ejb.Remote;

@Remote
public interface Hello {
	public String sayHello(String s);
}
