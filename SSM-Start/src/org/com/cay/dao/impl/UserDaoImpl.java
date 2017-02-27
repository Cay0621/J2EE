package org.com.cay.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.com.cay.dao.IUserDao;
import org.com.cay.entity.User;
import org.com.cay.mapper.UserRowMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {

	
	@Override
	public User queryUserById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id = " + id;
//		System.out.println(sql);
		return super.getJdbcTemplate().queryForObject(sql, new UserRowMapper());
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		List<Map<String, Object>>maps = super.getJdbcTemplate().queryForList(sql);
		
		List<User> users = new ArrayList<User>();
		
		for(Map<String, Object> m : maps){
			User user = new User();
			user.setId((Integer) m.get("id"));
			user.setUsername((String) m.get("username"));
			user.setPassword((String) m.get("password"));
			user.setAge((Integer) m.get("age"));
			user.setBirthday((Date) m.get("birthday"));
			users.add(user);
		}
		return users;
	}

}

