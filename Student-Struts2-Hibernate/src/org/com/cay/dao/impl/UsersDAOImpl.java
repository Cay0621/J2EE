package org.com.cay.dao.impl;



import org.com.cay.dao.UsersDAO;
import org.com.cay.entity.Users;
import org.com.cay.utils.MyHibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users users) {
		// TODO Auto-generated method stub
		String hql = "";
		Transaction tx = null;

		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username = :username and password = :password";
			Query query = session.createQuery(hql);
			
//			query.setParameter("username", users.getUsername());
//			query.setParameter("password", users.getPassword());
			query.setProperties(users);

			Users u = (Users) query.uniqueResult();
			if (u == null) {
				return false;
			} else {
				tx.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			tx = null;
		}
	}

}
