package org.com.cay.test;

import java.util.Date;
import java.util.List;

import org.com.cay.dao.StudentsDAO;
import org.com.cay.dao.impl.StudentsDAOImpl;
import org.com.cay.entity.Students;
import org.junit.Test;

public class TestStudents {

	@Test
	public void testQueryAll(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		for (Students students : list) {
			System.out.println(students);
		}
	}
	
	@Test
	public void testAddStudents(){
		Students s = new Students();
		s.setSname("令狐冲");
		s.setAddress("华山");
		s.setGender("男");
		s.setBirthday(new Date());
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.addStudents(s);
	}
}
