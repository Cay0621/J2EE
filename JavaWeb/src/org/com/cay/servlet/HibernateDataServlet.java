package org.com.cay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.cay.entity.Constant;
import org.com.cay.entity.Cost;
import org.com.cay.entity.Pager;
import org.com.cay.service.CostService;
import org.com.cay.service.impl.HibernateCostServiceImpl;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class SublistServlet
 */
@WebServlet(urlPatterns = "/HibernateDataServlet")
public class HibernateDataServlet extends HttpServlet {       
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2915223185194371401L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public HibernateDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CostService costService = new HibernateCostServiceImpl();
		//接收request参数
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("costName");
		
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = Constant.DEFAULT_PAGE_NUM;//显示第几页数据
		
		if(pageNumStr != null && !"".equals(pageNumStr.trim()))
			pageNum = Integer.parseInt(pageNumStr);
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr != null && !"".equals(pageSizeStr.trim()))		
			pageSize = Integer.parseInt(pageSizeStr);
		
		//组装查询条件
		Cost costModel = new Cost();
		costModel.setName(name);
		
		//调用service获取查询结果
		Pager<Cost> result = costService.findCost(costModel, pageNum, pageSize);
		
		//设置无缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//设置超时时间为0
		response.addDateHeader("Expires", 0);
		response.setContentType("text/html;charset=utf-8");
		
		//获取查询数据的json格式
		String responseStr = JSON.toJSONString(result);
		
		//写入数据到response
		PrintWriter write = response.getWriter();
		write.write(responseStr);
		write.flush();
	}

}
