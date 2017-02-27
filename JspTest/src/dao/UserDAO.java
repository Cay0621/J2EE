package dao;

import entity.User;

public class UserDAO {
	//ÓÃ»§µÇÂ¼
	public boolean userLogin(User user){
		if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
	}
}
