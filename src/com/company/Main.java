package com.company;

public class Main {

    public static void main(String[] args) {
	    People x = new People("ed", Gender.Female, 8);
	    System.out.println(x.name);
        System.out.println(x.gender);
        System.out.println(x.id);
    }
}
