package org.com.cay.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SublistServlet
 */
@WebServlet(urlPatterns = "/HibernateServlet")
public class HibernateServlet extends HttpServlet {       
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2915223185194371401L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public HibernateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("hibernateCost.jsp").forward(request, response);
	}

}
