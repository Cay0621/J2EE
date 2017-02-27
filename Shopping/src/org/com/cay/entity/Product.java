package org.com.cay.entity;

import javax.persistence.Entity;

@Entity
public class Product {

	private Integer id;
	private String name;
	private Integer amounts;
	private int price;
	private int modifyAmounts;
	
	public Product(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmounts() {
		return amounts;
	}

	public void setAmounts(Integer amounts) {
		this.amounts = amounts;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getModifyAmounts() {
		return modifyAmounts;
	}

	public void setModifyAmounts(Integer modifyAmounts) {
		this.modifyAmounts = modifyAmounts;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", amounts=" + amounts
				+ ", price=" + price + "]";
	}

	
	
	
}
