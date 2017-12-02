package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

enum Priority {
	LOW, MEDIUM, HIGH
}

enum Location {
	CUPERTINO, SAN_JOSE, LOS_ALTOS, SANTA_CLARA, MOUNTAIN_VIEW, HAYWARD, FRESNO, GILROY
}

public class Main {

	static Hospital hosp;

	public static void main(String[] args) {

		// sorting example
		ArrayList<Patient> list = new ArrayList();
		list.add(new Patient("BAC", Gender.Male, 10));
		list.add(new Patient("ABC", Gender.Male, 10));

		// By this point we should have a list of patients
		hosp = new Hospital();
		// hosp.insert(new Patient("BAC", Gender.Male, 10));
		// hospital.insert(new Patient("AC", Gender.Male, 10));

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
		// By this point we should have a graph of patients to hospital
		// patients are also inserted in a hash map
		// patients are also in a max heap

		// by this point we are ready to demo,
		// display list of patients sorted by name

		// insert patient via command line (hash map, graph, heap)

		// remove patient via command line ( get reference to patient object and set a
		// flag)

		// search for patient via id via command line (hash map)
		menu();

	}

	public static void display() {

	}

	public static void insertPatient() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter patient name: ");
		String name = scan.nextLine();

		System.out.print("Enter gender: ");
		String g = scan.nextLine();
		Gender gender = Gender.valueOf(g);

		System.out.print("Enter age: ");
		int age = scan.nextInt();
		System.out.print("Enter urgency (low, medium, high): ");
		scan.nextLine();
		String p = scan.nextLine();
		int priority = 0;
		switch (p) {
		case "low":
			priority = 1;
			break;
		case "medium":
			priority = 2;
			break;
		case "high":
			priority = 3;
			break;
		default:
			priority = 1;
			break;
		}

		Patient patient = new Patient(name, gender, age);
		patient.setPriority(priority);
		hosp.insert(patient);
		System.out.println("Your Patient ID is: " + patient.getID());
	}

	public static void printPatientDetail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter patient ID");
		Integer ID = scan.nextInt();

		Patient p = hosp.lookup(ID);

		System.out.println("Patient name: " + p.getName());
		System.out.println("Patient gender: " + p.getGender());
		System.out.println("Patient age: " + p.getAge());
		if (p.getBloodType() != null)
			System.out.println("Patient Blood Type: " + p.getBloodType());
		System.out.println("Urgency: " + p.getPriority());

	}

	public static void editPatient() {
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
			int priority = 0;
			switch (urgency) {
			case "low":
				priority = 1;
				break;
			case "medium":
				priority = 2;
				break;
			case "high":
				priority = 3;
				break;
			default:
				priority = 1;
				break;
			}
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

	public static void menu() {
		System.out.println("\nWelcome to the Hospital\n" + "1. Display all patients\n" + "2. Register patient\n"
				+ "3. Patient look up\n" + "4. Edit Patients\n\n" + "Pleae enter your choice\n" + "5. Exit\n");

		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();

		switch (input) {
		case 1:
			display();
			break;

		case 2:
			insertPatient();
			break;

		case 3:
			printPatientDetail();
			break;

		case 4:
			editPatient();
			break;

		case 5:
			System.exit(0);
			break;

		}
		menu();

	}
}
