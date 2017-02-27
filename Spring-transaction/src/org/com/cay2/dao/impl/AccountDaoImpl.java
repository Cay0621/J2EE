package org.com.cay2.dao.impl;

import org.com.cay2.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void outMoney(int out_id, int money) {
		// TODO Auto-generated method stub
		String sql = "update Account set money = money - ? where aid = ?";
		this.getJdbcTemplate().update(sql, money, out_id);
	}

	@Override
	public void inMoney(int in_id, int money) {
		// TODO Auto-generated method stub
		String sql = "update Account set money = money + ? where aid = ?";
		this.getJdbcTemplate().update(sql, money, in_id);
	}

}
