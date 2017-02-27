package org.com.cay.dao;

import java.util.List;

import org.com.cay.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public interface IUserDao {

	// 根据id查询用户信息
	public User queryUserById(Integer id);
	
	public List<User> queryAllUser();
}
