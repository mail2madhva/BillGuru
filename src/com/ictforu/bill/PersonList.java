package com.ictforu.bill;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonList implements Serializable {
	
	private ArrayList<Person> list = new ArrayList<Person>();
	private static PersonList personList; 
	
	private PersonList() {
	}
	
	public static PersonList getPersonList() {
		if(personList == null ) {
			personList = new PersonList();
		}
		return personList;
	}
	
	public void addPerson(Person p) {
		if (p != null) list.add(p);
	}
	
	public void removePerson(Person p) {
		if (p != null) list.remove(p);
	}

	public void setPersonList(ArrayList<Person> list) {
		this.list = list;
	}
	
	
}
