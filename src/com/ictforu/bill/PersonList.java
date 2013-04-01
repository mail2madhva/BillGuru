package com.ictforu.bill;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class PersonList implements Serializable {
	
	private DefaultListModel<Person> list = new DefaultListModel();
	private static volatile PersonList personList; 
	
	private PersonList() {
	}
	
	public static PersonList getPersonList() {
		if(personList == null ) {
			personList = new PersonList();
		}
		return personList;
	}
	
	public void addPerson(Person p) {
		if (p != null) list.addElement(p);
	}
	
	public void removePerson(Person p) {
		if (p != null) list.removeElement(p);
	}

	public void setPersonList(DefaultListModel<Person> list) {
		this.list = list;
	}
	
	public DefaultListModel<Person> getPersonListArray() {
		return this.list;
	}
	
}
