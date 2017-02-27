package org.com.cay.action;

import java.util.List;

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
public class ModifyAction extends ActionSupport {

	@Autowired
	private ProductService productService;

	private List<Integer> modifyAmounts;
	private List<Product> products;
	private int totalPrice;

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Integer> getModifyAmounts() {
		return modifyAmounts;
	}

	public void setModifyAmounts(List<Integer> modifyAmounts) {
		this.modifyAmounts = modifyAmounts;
	}

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

	@Transactional(propagation = Propagation.REQUIRED)
	public String modify() {
		products = productService.listAll();

		productService.modifyProducts(products, modifyAmounts);

		totalPrice = productService.calculateTotalPrice(products);
		
		for (@SuppressWarnings("unused") Integer modifyAmount : modifyAmounts) {
			modifyAmount = 0;
		}
		return SUCCESS;
	}
}
