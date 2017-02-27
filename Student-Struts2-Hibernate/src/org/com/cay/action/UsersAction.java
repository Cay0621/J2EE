package org.com.cay.action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.com.cay.dao.UsersDAO;
import org.com.cay.dao.impl.UsersDAOImpl;
import org.com.cay.entity.Users;

import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users users = new Users();
	
	public String login(){
		UsersDAO usersDAO = new UsersDAOImpl();
		if(usersDAO.usersLogin(users)){
			//在session中保存登录成功的用户信息
			session.setAttribute("loginUserName", users.getUsername());
			
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.users;
	}

	@SkipValidation//在注销的时候跳过表单验证
	public String logout(){
		if(session.getAttribute("loginUserName") != null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(users.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空！");
		}
		if(users.getPassword().length() < 6){		
			this.addFieldError("passwordError", "密码长度不少于6位！");
		}
	}
	
	
}
