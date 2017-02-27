package org.com.cay.dao.impl;

import org.com.cay.dao.AccountDAO;
import org.com.cay.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void transform(Account account1, Account account2, int money) {
		// TODO Auto-generated method stub
		account1.setMoney(account1.getMoney() - money);
		account2.setMoney(account2.getMoney() + money);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(account1);
		session.update(account2);
		tx.commit();
	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Account account = session.get(Account.class, id);
		return account;
	}

}
