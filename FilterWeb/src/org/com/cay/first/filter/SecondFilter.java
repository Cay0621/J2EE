package org.com.cay.first.filter;

import java.io.IOException;

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
 * Servlet Filter implementation class SecondFilter
 */
//@WebFilter(filterName = "/SecondFilter", urlPatterns="/*"
//,initParams = {@WebInitParam(name="",value="")})
public class SecondFilter implements Filter {

	/**
     * Default constructor. 
     */
    public SecondFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("SecondFilter---SecondFilter...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter---destroy...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("SecondFilter---start doFilter...");
		chain.doFilter(request, response);
		System.out.println("SecondFilter---end doFilter...");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter---init...");
	}

}
