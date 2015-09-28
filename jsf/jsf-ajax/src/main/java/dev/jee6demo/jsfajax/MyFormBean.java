package dev.jee6demo.jsfajax;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@ManagedBean(name = "myFormBean", eager = true)
@SessionScoped
public class MyFormBean {

	@Size(min=2, max=30)
	private String name;
	@Max(120)
	@Min(0)
	private double weight;
	@Past
	private Date birthDate;	
	
	public MyFormBean() {
		super();
		System.out.println("MyFormBean created!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
