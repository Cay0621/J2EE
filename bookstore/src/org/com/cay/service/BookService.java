package org.com.cay.service;

import org.com.cay.dao.IBookDAO;
import org.com.cay.dao.impl.BookDAOImpl;
import org.com.cay.entity.Book;
import org.com.cay.web.CriteriaBook;
import org.com.cay.web.Page;

public class BookService {

	private IBookDAO bookDAO = new BookDAOImpl();
	
	public Page<Book> getPage(CriteriaBook cb){
		return bookDAO.getPage(cb); 
	}
}
