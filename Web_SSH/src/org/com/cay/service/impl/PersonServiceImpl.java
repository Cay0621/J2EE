package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.dao.PersonDAO;
import org.com.cay.entity.Person;
import org.com.cay.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	
	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return personDAO.getPersons();
	}

	@Override
	public Person getPersonById(String id) {
		// TODO Auto-generated method stub
		return personDAO.getPersonById(id);
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		personDAO.addPerson(person);
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		personDAO.updatePerson(person);
	}

	@Override
	public void deletePersonById(String id) {
		// TODO Auto-generated method stub
		personDAO.deletePersonById(id);
	}

}
