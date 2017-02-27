package org.com.cay.entity;

import java.io.Serializable;

/**
 * 购物车中每种书籍的详细信息
 */
public class ShoppingCartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Book book;// 书籍实体
	private int quantity;// 数量

	public ShoppingCartItem(Book book) {
		this.book = book;
		this.quantity = 1;
	}

	public Book getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 该类书籍所需要的金额
	 */
	public float getItemMoney() {
		return book.getPrice() * quantity;
	}

	/**
	 * 数量加1
	 */
	public void increment() {
		quantity++;
	}

}
