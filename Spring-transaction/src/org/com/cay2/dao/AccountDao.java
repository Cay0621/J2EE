package org.com.cay2.dao;

public interface AccountDao {

	public void outMoney(int out_id, int money);
	
	public void inMoney(int in_id, int money);
}
