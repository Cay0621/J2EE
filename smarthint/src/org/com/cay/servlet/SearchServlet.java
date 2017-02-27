package org.com.cay.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static List<String> datas = new ArrayList<String>();
	static{
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("ajax异步");
		
		datas.add("bill");
		datas.add("black");
		
		datas.add("jame");
		datas.add("jetty");
		
		datas.add("pear");
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String keyword = request.getParameter("keyword");
		
		//获得关键字之后进行处理，模拟
		List<String> listData = getData(keyword);
		String jsonStr = JSONArray.toJSONString(listData);
		//System.out.println(jsonStr);
		response.getWriter().print(jsonStr);
	}
	
	private List<String> getData(String keyword){
		List<String> list = new ArrayList<String>();
		for(String data : datas){
			if(data.startsWith(keyword)){
				list.add(data);
			}
		}
		return list;
	}

}
