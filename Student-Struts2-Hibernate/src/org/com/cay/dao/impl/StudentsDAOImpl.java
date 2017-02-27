package org.com.cay.dao.impl;

import java.util.List;

import org.com.cay.dao.StudentsDAO;
import org.com.cay.entity.Students;
import org.com.cay.utils.MyHibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentsDAOImpl implements StudentsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);

			list = query.list();

			tx.commit();
			tx = null;
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;

		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public Students queryStudentsById(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Students s = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			s = session.get(Students.class, sid);

			tx.commit();
			return s;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return null;

		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean addStudents(Students stu) {
		// TODO Auto-generated method stub
		stu.setSid(getNewSid());
		Transaction tx = null;
		
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(stu);
			tx.commit();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}

	@Override
	public boolean updateStudents(Students stu) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(stu);
			tx.commit();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
			
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}

	@Override
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();

			Students s = session.get(Students.class, sid);
			session.delete(s);

			tx.commit();
			tx = null;
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
			
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	//生成学生的学号
	private String getNewSid(){
		Transaction tx = null;
		String hql = "";
		String sid = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = query.uniqueResult().toString();
			if(sid == null || "".equals(sid)){
				//给一个默认的最大编号
				sid = "S0000001";
			}else{
				String temp = sid.substring(1);//取后七位
				int i = Integer.parseInt(temp);
				++i;
				//再还原
				temp = String.valueOf(i);
				int len = temp.length();
				for(int j = 0;j < 7 - len;++j){
					temp = "0" + temp;
				}
				sid = "S" + temp;
			}
			tx.commit();
			return sid;
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return null;
			
		}finally{
			if(tx != null){
				tx = null;
			}
		}
	}
}
