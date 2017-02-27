package org.com.cay.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimerInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//1、执行action之前
		long start = System.currentTimeMillis();
		
		//2、执行拦截器，返回action的结果
		String result = invocation.invoke();
		
		//3、执行action之后
		long end = System.currentTimeMillis();
		
		System.out.println("花费了" + (end - start) + " ms");
		
		return result;
	}

}
