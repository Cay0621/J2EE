package org.com.cay.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.com.cay.dao.StudentsDAO;
import org.com.cay.dao.impl.StudentsDAOImpl;
import org.com.cay.entity.Students;

public class StudentsAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		if(list != null && list.size() > 0){
			session.setAttribute("students_list", list);
		}else{
			session.setAttribute("students_list", null);
		}
		return "query_success";
	}
	
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	public String add() throws ParseException{
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setAddress(request.getParameter("address"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
	}
	
	public String modify(){
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsById(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	public String save() throws ParseException{
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setAddress(request.getParameter("address"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
	}
}
