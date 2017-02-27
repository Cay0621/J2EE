package org.com.cay.util;

import java.util.List;

import org.com.cay.entity.User;

public class SessionUtil {
	
	public static User getUserBySessionId(List<User> userList, String sessionId){
		for (User user : userList) {
			if(user.getSessionIdString().equals(sessionId)){
				return user;
			}
		}
		
		return null;
	}
}
