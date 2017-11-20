package com.company;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

enum BloodType {
	A, B, AB, O, O_NEG, O_POS, A_NEG, A_POS, B_NEG, B_POS, AB_NEG, AB_POS
}

public class Patient extends People {
	private BloodType bloodType;
	private Integer priority;
//	private static final AtomicInteger counter = new AtomicInteger(); //generate random ID

	public Patient(String name, Gender gender, Integer age) {
		super(name, gender, age);
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
	
	void setBloodType(BloodType bt) {
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

	BloodType getBloodType() {
		return this.bloodType;
	}
	
	Integer getPriority() {
		return this.priority;
	}
}

class PatientIDCompare implements Comparator<Patient> {
	public int compare(Patient p1, Patient p2) {
		return p1.id.compareTo(p2.id);
	}
}

class PatientNameCompare implements Comparator<Patient> {
	public int compare(Patient p1, Patient p2) {
		return p1.name.compareTo(p2.name);
	}
}

class PatientAgeCompare implements Comparator<Patient> {
	public int compare(Patient p1, Patient p2) {
		return p1.age.compareTo(p2.age);
	}
}

class PatientGenderCompare implements Comparator<Patient> {
	public int compare(Patient p1, Patient p2) {
		return p1.gender.compareTo(p2.gender);
	}
}

class PatientBloodTypeCompare implements Comparator<Patient> {
	public int compare(Patient p1, Patient p2) {
		return p1.getBloodType().compareTo(p2.getBloodType());
	}
}

class PatientPriorityCompare implements Comparator<Patient> {
	public int compare(Patient p1, Patient p2) {
		return p1.getPriority().compareTo(p2.getPriority());
	}
}


