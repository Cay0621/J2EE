package org.com.cay.dao;

import java.util.List;

import org.com.cay.entity.Employee;

public interface IEmployeeDAO {

	public List<Employee> getAll();
	
	public void delete(Integer id);
}
