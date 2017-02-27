package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.Product;

public interface ProductService {

	public List<Product> listAll();

	public void modifyProducts(List<Product> products,
			List<Integer> modifyAmounts);
	
	public int calculateTotalPrice(List<Product> products);
}
