package org.com.cay.dao;

import java.util.List;

import org.com.cay.entity.Students;

public interface StudentsDAO {

	//查询所有学生信息
	public List<Students> queryAllStudents();
	
	//根据学生编号查询指定学生的信息
	public Students queryStudentsById(String sid);
	
	//添加学生
	public boolean addStudents(Students stu);
	
	//修改学生
	public boolean updateStudents(Students stu);
	
	//删除学生
	public boolean deleteStudents(String sid);

}
