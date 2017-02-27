package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.dao.ProductDAO;
import org.com.cay.entity.Product;
import org.com.cay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return productDAO.listAll();
	}

	@Override
	public void modifyProducts(List<Product> products,
			List<Integer> modifyAmounts) {
		// TODO Auto-generated method stub
		productDAO.modifyProducts(products, modifyAmounts);
	}

	@Override
	public int calculateTotalPrice(List<Product> products) {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		for (Product product : products) {
			totalPrice += product.getPrice() * product.getAmounts();
		}
		return totalPrice;
	}


}
