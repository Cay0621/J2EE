package org.com.cay.service;

import org.com.cay.entity.Employee;
import org.com.cay.entity.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer curPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);
}
