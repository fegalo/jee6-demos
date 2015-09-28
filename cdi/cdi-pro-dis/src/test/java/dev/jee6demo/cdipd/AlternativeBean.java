package dev.jee6demo.cdipd;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;

import dev.jee6demo.cdipd.HelloBean;

//@Specializes
@Alternative
public class AlternativeBean extends HelloBean{
	public AlternativeBean(){
		super();
		this.setText("Hello from Alternative Bean!");
	}

}
