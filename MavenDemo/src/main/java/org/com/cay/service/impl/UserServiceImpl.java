package org.com.cay.service.impl;

import org.com.cay.entity.User;
import org.com.cay.mapper.UserMapper;
import org.com.cay.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public User getByUsernameAndPwd(String username, String password) {
		// TODO Auto-generated method stub
		return userMapper.getByUsernameAndPwd(username, password);
	}

}
