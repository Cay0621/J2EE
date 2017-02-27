package org.com.cay.action;

import com.opensymphony.xwork2.ActionSupport;

public class TimerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		for(int i = 0;i < 10000;++i)
			System.out.println("I Love You!");
		
		return SUCCESS;
	}
}
