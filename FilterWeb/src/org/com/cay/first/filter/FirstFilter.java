package org.com.cay.first.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FirstFilter
 */
//@WebFilter(filterName = "/FirstFilter", urlPatterns={"/*"}
//, initParams = {@WebInitParam(name = "", value = "")}, dispatcherTypes = DispatcherType.REQUEST)
public class FirstFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FirstFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("FirstFilter---firstFilter...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter---destroy...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("FirstFilter---start doFilter...");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//重定向，会跳转到main.jsp,main.jsp又执行doFilter，会造成死循环
		//resp.sendRedirect(req.getContextPath() + "/main.jsp");
		
		//转发,内部进行跳转到main.jsp，浏览器不经过过滤器
		//req.getRequestDispatcher("main.jsp").forward(request, response);
		chain.doFilter(request, response);//后序的工作，比如下一个过滤器，jsp输出等
		System.out.println("FirstFilter---end doFilter...");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter---init...");
	}

}
