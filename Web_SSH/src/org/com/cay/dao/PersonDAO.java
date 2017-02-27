package org.com.cay.dao;

import java.util.List;

import org.com.cay.entity.Person;

public interface PersonDAO {

	public List<Person> getPersons();
	
	public Person getPersonById(String id);
	
	public void addPerson(Person person);
	
	public void updatePerson(Person person);
	
	public void deletePersonById(String id);
}
