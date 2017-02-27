package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.User;
import org.com.cay.model.Condition;

public interface IUserService {

	public List<User> getListAllUser();
	
	public List<User> getUser(Condition condition);

	public int getTotal(Condition condition);
}
