package org.com.cay.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.com.cay.dao.PersonDAO;
import org.com.cay.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Resource
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return (List<Person>)this.getSession().createQuery("from Person").getResultList();
	}

	@Override
	public Person getPersonById(String id) {
		// TODO Auto-generated method stub
		return (Person) this.getSession().createQuery("from Person where id = ?").setParameter(0, id).getSingleResult();
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		this.getSession().save(person);
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		this.getSession().update(person);
	}

	@Override
	public void deletePersonById(String id) {
		// TODO Auto-generated method stub
		this.getSession().createQuery("delete from Person where id = ?").setParameter(0, id).executeUpdate();
	}

}
