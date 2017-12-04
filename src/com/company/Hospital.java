package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Hospital implements Serializable{
	
	public ArrayList<Patient> patientsList;
	public HashMap<Integer,Patient> patientsMap;
	
	
	
	public Hospital(){
		patientsList = new ArrayList<Patient>();
		patientsMap = new HashMap<Integer, Patient>();
	}

	public void insert(Patient patient){

		int n = generateID();
		while(patientsMap.containsKey(n)) {
			n = generateID();
		}
		patient.setID(n);
		patientsList.add(patient);
		patientsMap.put(patient.getID(),patient);
		moveUp();
	}
	
	public Patient lookup(Integer ID) {
		
		
		return patientsMap.get(ID);
	}
	
	private int generateID() {
		Random rand = new Random();
		
		int ID = rand.nextInt(89999999) + 10000000;
		
		return ID;
		
	}
	
	private void moveUp(){
		int x = patientsList.size() -1;
		while (x > 0){
			int p = (x-1)/2;
			Patient patient = patientsList.get(x);
			Patient parent = patientsList.get(p);
			
			if (patient.compareTo(parent)>0){
				
				//swap
				patientsList.set(x, parent);
				patientsList.set(p, patient);
				
				//move up a level
				x = p;
			}else{
				break;
			}
		}
	}
	
	private void moveDown(){
		int x = 0;
		int left = 2 * x + 1;
		while(left < patientsList.size()) {
			int max = left;
			int right = left + 1;
			
			if (right < patientsList.size()){
				if (patientsList.get(right).compareTo(patientsList.get(left)) > 0){
					max++;
				}
			}
			if(patientsList.get(x).compareTo(patientsList.get(max)) < 0){
				Patient temp = patientsList.get(x);
				patientsList.set(x, patientsList.get(max));
				patientsList.set(max, temp);
				x = max;
				left = 2 * x + 1;
			}else{
				break;
			}
		}
	}
	
	public Patient delete() throws NoSuchElementException{
		if (patientsList.size() == 0){
			throw new NoSuchElementException();
		}
		if (patientsList.size() == 1){
			return patientsList.remove(0);
		}
		
		Patient hold = patientsList.get(0);
		patientsList.set(0, patientsList.remove(patientsList.size() - 1));
		moveDown();
		return hold;
	}

    @Override
    public String toString() {
	    String stars = "\n*******************************\n";
	    String patientListString = "";
        Iterator itr = patientsList.iterator();
        while (itr.hasNext()) {
            Patient patient = (Patient) itr.next();
            String formattedPatientInfo = String.format("%s Name: %s\nGender: %s\nAge: %s\nUrgency: %s\nBlood Type: %s\n %s",
                                                        stars,
                                                        patient.name,
                                                        patient.getGender(),
                                                        patient.age,
                                                        patient.getPriority(),
                                                        patient.getBloodType(),
                                                        stars);
            patientListString += formattedPatientInfo;
        };
        return patientListString;
    }
}
