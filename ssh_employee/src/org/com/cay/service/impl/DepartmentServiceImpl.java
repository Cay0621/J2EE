package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.dao.DepartmentDao;
import org.com.cay.entity.Department;
import org.com.cay.entity.PageBean;
import org.com.cay.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findByPage(Integer curPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean = new PageBean<Department>();
		
		//封装当前页数
		pageBean.setCurrentPage(curPage);
		
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//封装每页需要显示的数据
		int begin = (curPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

	
}
