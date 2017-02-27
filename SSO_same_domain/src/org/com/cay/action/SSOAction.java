package org.com.cay.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.com.cay.util.SSOCheck;

import com.opensymphony.xwork2.ActionSupport;

public class SSOAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String gotoUrl;
	
	public String getGotoUrl() {
		return gotoUrl;
	}
	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String doLogin(){
		boolean ok = SSOCheck.checkLogin(username, password);
		if(ok){
			Cookie cookie = new Cookie("ssocookie", "sso");
			//设置到同域顶层
			cookie.setPath("/");
			ServletActionContext.getResponse().addCookie(cookie);
			
			return SUCCESS;
		}
		return null;
	}
}
