package com.company;

import java.util.UUID;

enum Gender {
    Male, Female
}

public class People {
    Integer id;
    String name;
    Gender gender;
    Integer age;

    public People(String name, Gender gender, Integer age) {
        id = new Integer(this.hashCode());
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

	public People(Integer id2) {
		// TODO Auto-generated constructor stub
	}
}
