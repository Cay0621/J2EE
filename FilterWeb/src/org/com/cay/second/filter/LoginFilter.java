package org.com.cay.second.filter;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName = "/LoginFilter", urlPatterns="/*",
initParams = {@WebInitParam(name="noLoginPaths",value="login.jsp,failure.jsp,LoginServlet"),
		@WebInitParam(name="charset",value="UTF-8")})
public class LoginFilter implements Filter {

	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
//		if(((HttpServletRequest)request).getRequestURI().indexOf("login.jsp") != -1
//				|| ((HttpServletRequest)request).getRequestURI().indexOf("LoginServlet") != -1){
//			chain.doFilter(request, response);
//			return;
//		}
		
		String charset = config.getInitParameter("charset");
		if(charset == null)
			charset = "UTF-8";
		((HttpServletRequest)request).setCharacterEncoding(charset);
		
		String noLoginPaths = config.getInitParameter("noLoginPaths");
		if(noLoginPaths != null){
			String[] values = noLoginPaths.split(",");
			for (String value : values) {
				if(value == null || "".equals(value.trim()))
					continue;
				
				if(((HttpServletRequest)request).getRequestURI().indexOf(value) != -1){
					chain.doFilter(request, response);
					return;
				}
			}
		}
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("username") != null){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse)response).sendRedirect("login.jsp");
		}
		
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}

}
