package dev.jee6demo.jsfform;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "myFormBean", eager = true)
@SessionScoped
public class MyFormBean {

	private String name;
	private int age;
	private int gender;
	private double weight;
	private Date birthDate;
	private boolean carLicense;
	private boolean bikeLicense;
	private List<String> interests;
	private String notes;
	
	
	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isCarLicense() {
		return carLicense;
	}

	public void setCarLicense(boolean carLicense) {
		this.carLicense = carLicense;
	}

	public boolean isBikeLicense() {
		return bikeLicense;
	}

	public void setBikeLicense(boolean bikeLicense) {
		this.bikeLicense = bikeLicense;
	}
	

}
