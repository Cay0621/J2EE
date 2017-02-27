package org.com.cay4.service.impl;

import javax.annotation.Resource;

import org.com.cay4.dao.AccountDao;
import org.com.cay4.service.AccountService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Cay
 *
 *	@Transactional注解中的属性：
 *		propagation		:事务传播行为
 *		isolation		:事务隔离级别
 *		readOnly		:只读
 *		RollbackFor		:发生哪些异常回滚
 *		noRollbackFor	:发生哪些异常不回滚
 *		timeout			:过期信息
 */

@Transactional
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
		int i = 1 / 0;
		accountDao.inMoney(in_id, money);
	}

}
