package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.dao.IUserDao;
import org.com.cay.entity.User;
import org.com.cay.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User queryUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryUserById(id);
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		return userDao.queryAllUser();
	}

}
