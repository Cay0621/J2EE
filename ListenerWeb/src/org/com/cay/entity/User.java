package org.com.cay.entity;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener, HttpSessionActivationListener {

	private String username;
	private String password;
	
	
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

	@Override
	//绑定
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("valueBound: " + arg0.getName());
	}

	@Override
	//解除绑定
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("valueUnbound: " + arg0.getName());
	}

	@Override
	//活化
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("sessionDidActivate: " + arg0.getSource());
	}

	@Override
	//钝化
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("sessionWillPassivate: " + arg0.getSource());
	}

}
