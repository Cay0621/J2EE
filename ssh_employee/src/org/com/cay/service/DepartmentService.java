package org.com.cay.service;


import java.util.List;

import org.com.cay.entity.Department;
import org.com.cay.entity.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer curPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
