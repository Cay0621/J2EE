package org.com.cay.dao.impl;

import org.com.cay.dao.IAccountDAO;
import org.com.cay.entity.Account;

public class AccountDAOIml extends BaseDAO<Account> implements IAccountDAO {

	@Override
	public Account get(Integer accountId) {
		String sql = "SELECT accountId, balance FROM account WHERE accountId = ?";
		return query(sql, accountId); 
	}

	@Override
	public void updateBalance(Integer accountId, float amount) {
		String sql = "UPDATE account SET balance = balance - ? WHERE accountId = ?";
		update(sql, amount, accountId); 
	}

}
