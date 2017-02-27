package org.com.cay.action;

import java.util.List;

//import javax.servlet.ServletContext;
//import org.apache.struts2.ServletActionContext;
import org.com.cay.entity.Product;
import org.com.cay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ListAction extends ActionSupport {

	@Autowired
	private ProductService productService;
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String list() {
		//for c:forEach
		products = productService.listAll();
		
		//for s:iterator
		//ServletContext sc = ServletActionContext.getServletContext();
		//sc.setAttribute("products", products);
		return SUCCESS;
	}
}
