package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

	public User queryUserById(Integer id);
	
	public List<User> queryAllUser();
}
