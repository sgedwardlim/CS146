package com.company;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // sorting example
        ArrayList<Patient> list = new ArrayList();
        list.add(new Patient("BAC", Gender.Male, 10));
        list.add(new Patient("ABC", Gender.Male, 10));
        System.out.println("Unsorted patients");
        for (Patient patient : list) {
            System.out.println(patient.name);
        }
        PatientNameCompare cmp = new PatientNameCompare();
        Collections.sort(list, cmp);
        System.out.println("Sorted patients");
        for (Patient patient : list) {
            System.out.println(patient.name);
        }
    }
}
