package org.com.cay.dao.impl;

import java.util.List;

import org.com.cay.dao.EmployeeDao;
import org.com.cay.entity.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}

}
