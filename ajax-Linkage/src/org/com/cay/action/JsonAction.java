package org.com.cay.action;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport implements ServletRequestAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String execute() throws IOException{
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println(request.getParameter("username"));
		result.put("success", "success");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		return SUCCESS;
	}

	
}
