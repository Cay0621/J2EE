package org.com.cay.entity;

import java.io.Serializable;

/**
 * 账户实体类
 *
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer accountId;// 账户ID
	private int balance;// 余额

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Account(Integer accountId, int balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
}
