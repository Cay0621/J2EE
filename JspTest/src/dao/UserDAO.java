package dao;

import entity.User;

public class UserDAO {
	//�û���¼
	public boolean userLogin(User user){
		if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
	}
}
