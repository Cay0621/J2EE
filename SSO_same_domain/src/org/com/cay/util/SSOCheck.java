package org.com.cay.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SSOCheck {

	public static final String USERNAME = "admin";
	public static final String PASSWORD = "123";
	
	public static boolean checkLogin(String username, String password){
		if(USERNAME.equals(username) && PASSWORD.equals(password))
			return true;
		else
			return false;
	}
	
	public static boolean checkCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("ssocookie") && 
						cookie.getValue().equals("sso")){
					return true;
				}
			}
		}
		return false;
	}
}
