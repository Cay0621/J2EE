package org.com.cay.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.cay.entity.Book;
import org.com.cay.service.BookService;
import org.com.cay.web.CriteriaBook;
import org.com.cay.web.Page;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNoStr = request.getParameter("pageNo");
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");
		
		int pageNo = 1;
		int minPrice = 0;
		int maxPrice = Integer.MAX_VALUE;
		
		try{
			pageNo = Integer.parseInt(pageNoStr);
		}catch(NumberFormatException e){}
		
		try{
			minPrice = Integer.parseInt(minPriceStr);
		}catch(NumberFormatException e){}
		
		try{
			maxPrice = Integer.parseInt(maxPriceStr);
		}catch(NumberFormatException e){}
		
		CriteriaBook criteriaBook = new CriteriaBook(minPrice, maxPrice, pageNo);
		Page<Book> page = bookService.getPage(criteriaBook);
		request.setAttribute("bookpage", page);
		request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);
	}

}
