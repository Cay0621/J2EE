package org.com.cay.entity;

import java.io.Serializable;

/**
 * 每个交易项的详情实体类
 */
public class TradeItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tradeItemId;

	// 书籍实体类
	private Book book;

	// 数量
	private int quantity;

	//
	private Integer bookId;

	private Integer tradeId;

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public Integer getTradeItemId() {
		return tradeItemId;
	}

	public void setTradeItemId(Integer tradeItemId) {
		this.tradeItemId = tradeItemId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public TradeItem(Integer tradeItemId, Integer bookId, int quantity, Integer tradeId) {
		super();
		this.tradeItemId = tradeItemId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.tradeId = tradeId;
	}

	public TradeItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TradeItem [tradeItemId=" + tradeItemId + ", quantity=" + quantity + ", bookId=" + bookId + "]";
	}

}
