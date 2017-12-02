package com.company;

enum Location {
	CUPERTINO, SAN_JOSE, LOS_ALTOS, SANTA_CLARA, MOUNTAIN_VIEW, HAYWARD, FRESNO, GILROY
}

public class Main {

	static Hospital hosp;

	public static void main(String[] args) {
		// By this point we should have a list of patients
		hosp = new Hospital();
        hosp.insert(new Patient("Fake Patient 1", Gender.Male, 10, 1));
        hosp.insert(new Patient("Fake Patient 2", Gender.Female, 12, 2));

        MenuManager menuManager = new MenuManager(hosp);
        menuManager.displayMenu();

		// By this point we should have a graph of patients to hospital
		// patients are also inserted in a hash map
		// patients are also in a max heap

		// by this point we are ready to demo,
		// display list of patients sorted by name

		// insert patient via command line (hash map, graph, heap)

		// remove patient via command line ( get reference to patient object and set a
		// flag)

		// search for patient via id via command line (hash map)
	}
}
