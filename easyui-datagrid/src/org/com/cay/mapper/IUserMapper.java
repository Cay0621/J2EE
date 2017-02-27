package org.com.cay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.com.cay.entity.User;
import org.com.cay.model.Condition;

public interface IUserMapper {

	@Select("select * from user")
	public List<User> getListAllUser();

	
	public List<User> getUser(@Param("condition") Condition condition);


	public int getTotal(@Param("condition") Condition condition);
}
