package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.entity.User;
import org.com.cay.mapper.IUserMapper;
import org.com.cay.model.Condition;
import org.com.cay.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	@Override
	public List<User> getListAllUser() {
		// TODO Auto-generated method stub
		return userMapper.getListAllUser();
	}
	
	@Override
	public List<User> getUser(Condition condition) {
		// TODO Auto-generated method stub
		condition.setRowStart((condition.getPage() - 1) * condition.getRows());
		return userMapper.getUser(condition);
	}

	@Override
	public int getTotal(Condition condition) {
		// TODO Auto-generated method stub
		return userMapper.getTotal(condition);
	}

}
