package org.com.cay.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.cay.entity.Constant;
import org.com.cay.entity.Cost;
import org.com.cay.entity.Pager;
import org.com.cay.service.CostService;
import org.com.cay.service.impl.SublistCostServiceImpl;
import org.com.cay.util.StringUtil;

/**
 * Servlet implementation class SublistServlet
 */
@WebServlet(urlPatterns = "/SublistServlet")
public class SublistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SublistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CostService costService = new SublistCostServiceImpl();
		//接收request参数
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("costName");
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "参数错误");
			request.getRequestDispatcher("sublistCost.jsp").forward(request, response);
			return;
		}
		
		
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
		
		
		//返回结果到页面
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("sublistCost.jsp").forward(request, response);
	}

}
