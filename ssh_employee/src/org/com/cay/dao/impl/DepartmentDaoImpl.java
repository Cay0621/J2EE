package org.com.cay.dao.impl;

import java.util.List;

import org.com.cay.dao.DepartmentDao;
import org.com.cay.entity.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

	@Override
	//查询部门
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}

}
