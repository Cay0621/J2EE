package org.com.cay.dao.impl;

import java.util.List;

import org.com.cay.dao.IEmployeeDAO;
import org.com.cay.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}


	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		String hql = "from Employee e left join fetch e.department";
		Session session = getSession();
		Query<Employee> query = session.createQuery(hql, Employee.class);
		
		return query.getResultList();
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.setId(id);
		getSession().delete(e);
	}

}
