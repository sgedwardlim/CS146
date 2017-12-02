package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by edward on 12/1/17.
 */
public class MenuManager {
    private Hospital hosp;

    public MenuManager(Hospital hosp) {
        this.hosp = hosp;
    }

    public void displayMenu() {
        String options[] = {"Display all patients",
                            "Register patient",
                            "Patient look up",
                            "Edit Patients",
                            "Exit"
                            };
        String welcomeMessage = "\nWelcome to the Hospital\n";
        for (int i = 0; i < options.length; i++) {
            welcomeMessage += String.format("%d. %s\n", i + 1, options[i]);
        }

        System.out.println(welcomeMessage);

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch (input) {
            case 1:
                displayPatients();
                break;

            case 2:
                insertPatient();
                break;

            case 3:
                displayPatientDetail();
                break;

            case 4:
                editPatient();
                break;

            case 5:
                System.exit(0);
                break;

            default:
                String errorMessage = "\nInvalid input, please try again\n";
                System.out.println(errorMessage);
                break;

        }
        displayMenu();
    }

    private void displayPatients() {
        System.out.println(hosp);
    }

    private void insertPatient() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter patient name: ");
        String name = scan.nextLine();

        System.out.print("Enter gender: ");
        String g = scan.nextLine();
        Gender gender;
        switch (g) {
            case "male":
                gender = Gender.Male;
                break;
            case "female":
                gender = Gender.Female;
                break;
            default:
                gender = Gender.Male;
        }
        System.out.print("Enter age: ");
        int age = 0;

        boolean inputErr = true;
        
        while(inputErr) {
        	if (scan.hasNextInt()) {
        		age = scan.nextInt();
        	}
        	else {
        		System.out.print("Invalid age input, please enter an integer: ");
        		scan.next();
        		continue;
        	}
        	inputErr = false;
        }


       
        System.out.print("Enter urgency (low, medium, high): ");
        scan.nextLine();
        String p = scan.nextLine();
        int priority = priorityMap(p);

        Patient patient = new Patient(name, gender, age, priority);
        hosp.insert(patient);
        System.out.println("Your Patient ID is: " + patient.getID());
    }

    private void displayPatientDetail() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter patient ID");
        Integer ID = scan.nextInt();

        Patient p = hosp.lookup(ID);
        while(p == null) {
        	System.out.print("Invalid ID, Please Enter another ID:");
        	p = hosp.lookup(ID);
        	ID = scan.nextInt();
        }

        System.out.println("Patient name: " + p.getName());
        System.out.println("Patient gender: " + p.getGender());
        System.out.println("Patient age: " + p.getAge());
        if (p.getBloodType() != null)
            System.out.println("Patient Blood Type: " + p.getBloodType());
        System.out.println("Urgency: " + p.getPriority());

    }

    private void editPatient() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter patient ID");
        int id = scan.nextInt();
        hosp.patientsMap.get(id);

        System.out.println("Select Category to edit");
        System.out.println("1. Name");
        System.out.println("2. Gender");
        System.out.println("3. Age");
        System.out.println("4. Urgency");
        System.out.println("5. Blood Type");

        int input = scan.nextInt();

        String name;
        String g;
        Integer age;
        String urgency;
        String bloodtype;

        switch (input) {
            case 1:
                System.out.println("Enter new name: ");
                name = scan.nextLine();
                hosp.patientsMap.get(id).setName(name);
                break;
            case 2:
                System.out.println("Enter gender: ");
                g = scan.nextLine();
                Gender gender = Gender.valueOf(g);
                hosp.patientsMap.get(id).setGender(gender);
                break;
            case 3:
                System.out.println("Enter new age: ");
                age = scan.nextInt();
                hosp.patientsMap.get(id).setAge(age);
                break;
            case 4:
                System.out.println("Enter urgency(low, medium, high): ");
                urgency = scan.nextLine();
                int priority = priorityMap(urgency);
                hosp.patientsMap.get(id).setPriority(priority);
                break;
            case 5:
                System.out.println("Enter blood type: ");
                bloodtype = scan.nextLine();
                BloodType bt = BloodType.valueOf(bloodtype);
                hosp.patientsMap.get(id).setBloodType(bt);
                break;
        }
    }

    private int priorityMap(String urgency) {
        switch (urgency) {
            case "low":
                return 1;
            case "medium":
                return 2;
            case "high":
                return 3;
            default:
                return 1;
        }
    }
}
