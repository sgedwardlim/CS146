package com.company;
import java.util.ArrayList;
import java.util.Collections;

enum Priority {
	LOW, MEDIUM, HIGH
}

enum Location {
	CUPERTINO, SAN_JOSE, LOS_ALTOS, SANTA_CLARA, MOUNTAIN_VIEW, HAYWARD, FRESNO, GILROY
}

public class Main {

    public static void main(String[] args) {
        // sorting example
        ArrayList<Patient> list = new ArrayList();
        list.add(new Patient("BAC", Gender.Male, 10, Location.CUPERTINO));
        list.add(new Patient("ABC", Gender.Male, 10, Location.SAN_JOSE));
        
        
        // By this point we should have a list of patients
        Hospital hospital = new Hospital();
        hospital.insert(new Patient("BAC", Gender.Male, 10));
        hospital.insert(new Patient("AC", Gender.Male, 10));
        // By this point we should have a graph of patients to hospital
        // patients are also inserted in a hash map
        // patients are also in a max heap
        
        
        
        
        // by this point we are ready to demo,
        // display list of patients sorted by name
        
        
        // insert patient via command line (hash map, graph, heap)
        
        
        // remove patient via command line ( get reference to patient object and set a flag)
        
        
        // search for patient via id via command line (hash map)
        
        
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
