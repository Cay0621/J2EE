package org.com.cay.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		if(session.get("loginInfo") != null){
			String result = invocation.invoke();
			return result;
		}else{
			return "login";
		}
	}

}
