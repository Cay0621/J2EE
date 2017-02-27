package org.com.cay.dao;

import org.com.cay.entity.Account;

public interface AccountDAO {

	public Account getAccountById(int id);

	public void transform(Account account1, Account account2, int money);
}
