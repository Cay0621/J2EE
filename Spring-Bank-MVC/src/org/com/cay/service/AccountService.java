package org.com.cay.service;

import org.com.cay.entity.Account;

public interface AccountService {
	public Account getAccountById(int id);

	public void transform(Account account1, Account account2, int money);
}
