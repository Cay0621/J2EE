package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetInitServletConfig
 */
@WebServlet(urlPatterns={"/getInitServletConfig"},
			initParams={
		@WebInitParam(name="name", value="admin"),
		@WebInitParam(name="password", value="123456")
})
public class GetInitServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String username;
	private String password;
	
    public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		username = this.getInitParameter("name");
		password = this.getInitParameter("password");
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public GetInitServletConfig() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>" + this.getUsername()
				+ "</h2>");
		out.println("<h2>" + this.getPassword()
				+ "</h2>");
		out.close();
	}

}
