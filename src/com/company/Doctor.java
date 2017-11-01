package com.company;

public class Doctor extends People {
	private String speciality;
	
	public Doctor(String name, Gender gender, Integer age, String speciality){
		super(name, gender, age);
		this.speciality = speciality;
	}
	
	public String getName(){
		return name;
	}
	
	public Gender getGender(){
		return gender;
	}
	
	public Integer getAge(){
		return age;
	}
	
	public String getSpeciality(){
		return speciality;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setGender(Gender gender){
		this.gender = gender;
	}
	
	public void setAge(Integer age){
		this.age = age;
	}
	
	public void setSpeciality(String speciality){
		this.speciality = speciality;
	}
	
}
