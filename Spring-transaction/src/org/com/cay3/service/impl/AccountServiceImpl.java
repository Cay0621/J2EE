package org.com.cay3.service.impl;

import javax.annotation.Resource;

import org.com.cay3.dao.AccountDao;
import org.com.cay3.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Resource(name = "accountDao")
	private AccountDao accountDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(final int out_id, final int in_id, final int money) {
		// TODO Auto-generated method stub
		accountDao.outMoney(out_id, money);
		//int i = 1 / 0;
		accountDao.inMoney(in_id, money);
	}

}
