package dev.jee6demo.ejbstart;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements Hello{
	public String sayHello(String s){
		return "Hello "+s;
	}
}
