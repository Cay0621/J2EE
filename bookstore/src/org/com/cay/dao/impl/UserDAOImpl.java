package org.com.cay.dao.impl;

import org.com.cay.dao.IUserDAO;
import org.com.cay.entity.User;

public class UserDAOImpl extends BaseDAO<User> implements IUserDAO {

	@Override
	public User getUser(String username) {
		String sql = "SELECT userId, username, accountId " +
				"FROM userinfo WHERE username = ?";
		return query(sql, username); 
	}

}
