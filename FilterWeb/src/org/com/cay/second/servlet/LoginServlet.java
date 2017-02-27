package org.com.cay.second.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//System.out.println(new String(username.getBytes("iso-8859-1"), "utf-8"));
		System.out.println(username);//可以在本函数里设置编码格式，也可以在过滤器中设置编码格式
		
		if("admin".equals(username) && "admin".equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath() + "/success.jsp");
		}else{
			response.sendRedirect(request.getContextPath() + "/failure.jsp");
		}
	}
}
