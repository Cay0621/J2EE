package org.com.cay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AutoRefreshServlet
 */
@WebServlet("/autoRefresh")
public class AutoRefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoRefreshServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String returnType = request.getParameter("type");
		//System.out.println(returnType);
		num++;

		if (returnType == null || !"".equals(returnType.trim())) {
			if ("xml".equals(returnType)) {
				// 使用xml返回
				response.setContentType("text/xml;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<num>" + num + "</num>");
			} else if ("text".equals(returnType)) {
				// 使用文本返回
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(num);
			} else if ("json".equals(returnType)) {
				// 使用json返回
				Map<String, Integer> map = new HashMap<String, Integer>();
				
				map.put("num", num);
				
				JSONObject json = JSONObject.fromObject(map);
				PrintWriter out = response.getWriter();
				out.print(json.toString());
				//System.out.println(json.toString());
			}
		}
	}

}
