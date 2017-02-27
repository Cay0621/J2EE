package org.com.cay2.service.impl;

import javax.annotation.Resource;

import org.com.cay2.dao.AccountDao;
import org.com.cay2.service.AccountService;

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
	public void transfer(int out_id, int in_id, int money) {
		// TODO Auto-generated method stub
		accountDao.outMoney(out_id, money);
		int i = 1 / 0;
		accountDao.inMoney(in_id, money);
	}

}
