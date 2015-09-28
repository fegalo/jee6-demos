package dev.jee6demo.ejbtimer;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements Hello{
	public String sayHello(String s){
		return "Hello "+s;
	}
}
