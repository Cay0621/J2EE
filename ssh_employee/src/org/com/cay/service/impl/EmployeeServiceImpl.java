package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.dao.EmployeeDao;
import org.com.cay.entity.Employee;
import org.com.cay.entity.PageBean;
import org.com.cay.service.EmployeeService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findByPage(Integer curPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean = new PageBean<Employee>();
		
		pageBean.setCurrentPage(curPage);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		int begin = (curPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		
		
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
	
	
}
