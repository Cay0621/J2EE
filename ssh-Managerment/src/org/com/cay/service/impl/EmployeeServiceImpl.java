package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.dao.IEmployeeDAO;
import org.com.cay.entity.Employee;
import org.com.cay.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDAO employeeDao;
	
	
	public void setEmployeeDao(IEmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}


	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeDao.getAll();
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeDao.delete(id);
	}

}
