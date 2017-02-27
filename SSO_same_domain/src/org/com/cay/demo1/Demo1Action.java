package org.com.cay.demo1;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.com.cay.util.SSOCheck;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gotoUrl;
	
	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}



	public String mainHome(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(SSOCheck.checkCookie(request)){
			return SUCCESS;
		}
		gotoUrl = "/demo1/main.action";
		return LOGIN;
	}
}
