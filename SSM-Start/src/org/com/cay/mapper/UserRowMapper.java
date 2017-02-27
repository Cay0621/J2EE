package org.com.cay.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.com.cay.entity.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(rs.getInt("ID"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setAge(rs.getInt("age"));
		user.setBirthday(rs.getDate("birthday"));
		return user;
	}


}
