package org.com.cay.service.impl;

import org.com.cay.dao.AccountDAO;
import org.com.cay.entity.Account;
import org.com.cay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class AccountSeriveImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public void transform(Account account1, Account account2, int money) {
		// TODO Auto-generated method stub
		accountDAO.transform(account1, account2, money);
	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return accountDAO.getAccountById(id);
	}

}
