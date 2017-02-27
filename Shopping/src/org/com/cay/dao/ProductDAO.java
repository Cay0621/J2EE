package org.com.cay.dao;

import java.util.List;

import org.com.cay.entity.Product;

public interface ProductDAO {

	public List<Product> listAll();

	public void modifyProducts(List<Product> products,
			List<Integer> modifyAmounts);
}
