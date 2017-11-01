package com.company;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;


public class Patient extends People{
;
	private String bloodType;
	private Integer priority;
//	private static final AtomicInteger counter = new AtomicInteger(); //generate random ID
	


	public Patient(String name, Gender gender, Integer age) {
		super(name, gender, age);
		// TODO Auto-generated constructor stub
		
	}
	
	public Patient(Integer id) {
		super(id);
	}
	
	void setID(Integer id) {
		this.id = id;
	}
	
	void setName(String n) {
		this.name = n;
	}
	void setGender (Gender g) {
		this.gender = g;
	}
	
	void setAge (Integer age) {
		this.age = age;
	}
	
	void setBloodType(String bt) {
		this.bloodType = bt;
	}
	
	void setPriorty(Integer p) {
		this.priority = p;
	}
	Integer getID() {
		return this.id;
	}
	String getName () {
		return this.name;
	}
	
	Gender getGender () {
		return this.gender;
	}
	
	Integer getAge () {
		return this.age;
	}
	
	String getBloodType() {
		return this.bloodType;
	}
	
	Integer getPriority() {
		return this.priority;
	}
	


	

}
