package org.com.cay.dao;

import org.com.cay.entity.User;

public interface IUserDAO {

	/**
	 * 根据用户名获取 User 对象
	 * 
	 * @param username
	 * @return
	 */
	public abstract User getUser(String username);

}
