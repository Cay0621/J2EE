package org.com.cay1.service.impl;

import javax.annotation.Resource;

import org.com.cay1.dao.AccountDao;
import org.com.cay1.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {

	@Resource(name = "accountDao")
	private AccountDao accountDao;
	
	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(final int out_id, final int in_id, final int money) {
		// TODO Auto-generated method stub
//		accountDao.outMoney(out_id, money);
//		int i = 1 / 0;
//		accountDao.inMoney(in_id, money);
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				accountDao.outMoney(out_id, money);
//				int i = 1 / 0;
//				System.out.println(i);
				accountDao.inMoney(in_id, money);
			}
		});
	}

}
