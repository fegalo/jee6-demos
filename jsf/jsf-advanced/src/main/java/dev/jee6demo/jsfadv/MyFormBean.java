package dev.jee6demo.jsfadv;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@ManagedBean(name = "myFormBean", eager = true)
@SessionScoped
public class MyFormBean {

	@Size(min=2, max=30)
	private String name;
	private String password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Validators and listeners
	//------------------------------------------------------------
	
	public void nameListener(AjaxBehaviorEvent event){
		System.out.println("nameListener called");
		if(name!=null&&name.length()<5){
			String message="Possible too short name";
			FacesMessage fmessage = new FacesMessage(FacesMessage.SEVERITY_WARN,message,message);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(event.getComponent().getClientId(), fmessage);
		}
	}

	public void nameValidator(FacesContext context, UIComponent component,Object value) throws ValidatorException {
		String newValue=(String)value;
		System.out.println("validateName called");
		if(newValue!=null&&newValue.equals("john")){
			String message="Username already exists.Test with "+name+"123";
			FacesMessage fmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message);
			context.addMessage(component.getClientId(), fmessage);
		}if(newValue!=null&&newValue.matches("[\\p{Punct}]*")){
			String message="Name contains symbols";
			FacesMessage fmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message);
			context.addMessage(component.getClientId(), fmessage);
		}
	}

}
