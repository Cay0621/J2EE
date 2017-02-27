package org.com.cay.test;


import org.com.cay.dao.UsersDAO;
import org.com.cay.dao.impl.UsersDAOImpl;
import org.com.cay.entity.Users;
import org.junit.Test;

public class TestUsers {

	@Test
	public void test() {
		Users u = new Users(1,"zhangsan", "123456");
		UsersDAO usersDAO = new UsersDAOImpl();
		System.out.println(usersDAO.usersLogin(u));
	}

}
