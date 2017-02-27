package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = null;
		try {
			birth = sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		
		String[] hobbies = request.getParameterValues("hobby");
		String introduce = request.getParameter("introduce");
		String acceptflag = request.getParameter("acceptflag");
		if(acceptflag == null)
			acceptflag = "false";
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setBirthday(birth);
		user.setEmail(email);
		user.setHobbies(hobbies);
		user.setIntroduce(introduce);
		user.setAcceptflag(acceptflag.equals("true"));
		
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("./userinfo.jsp").forward(request, response);
	}

}
