package org.com.cay.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车实体类
 *
 */
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 购物车中书籍的集合
	private Map<Integer, ShoppingCartItem> books = new HashMap<>();

	/**
	 * 更新购物车中指定id的书籍的数量
	 *
	 */
	public void updateItemQuantity(Integer id, int quantity) {
		ShoppingCartItem sci = books.get(id);
		if (sci != null) {
			sci.setQuantity(quantity);
		}
	}

	/**
	 * 从购物车中删除指定id的书籍
	 * 
	 * @param id
	 */
	public void removeItem(Integer id) {
		books.remove(id);
	}

	/**
	 * 清空购物车
	 */
	public void clear() {
		books.clear();
	}

	/**
	 * 判断购物车是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return books.isEmpty();
	}

	/**
	 * 计算购物车中所有书籍的总价
	 * 
	 * @return
	 */
	public float getTotalMoney() {
		float total = 0;

		for (ShoppingCartItem sci : getItems()) {
			total += sci.getItemMoney();
		}

		return total;
	}

	/**
	 * 获取购物车中所有的书籍集合
	 * 
	 * @return
	 */
	public Collection<ShoppingCartItem> getItems() {
		return books.values();
	}

	/**
	 * 获取购物车中所有书籍的数量
	 * 
	 * @return
	 */
	public int getBookNumber() {
		int total = 0;

		for (ShoppingCartItem sci : books.values()) {
			total += sci.getQuantity();
		}

		return total;
	}

	public Map<Integer, ShoppingCartItem> getBooks() {
		return books;
	}

	/**
	 * 判断购物车中是否含有指定id的书籍
	 */
	public boolean hasBook(Integer id) {
		return books.containsKey(id);
	}

	/**
	 * 向购物车中添加书籍
	 * 
	 * @param book
	 */
	public void addBook(Book book) {
		/**
		 * 1、先获取购物车中是否含有指定id的书籍 2、如果已有，则将数量加1，否则向集合中添加该书籍
		 */
		ShoppingCartItem sci = books.get(book.getId());

		if (sci == null) {
			sci = new ShoppingCartItem(book);
			books.put(book.getId(), sci);
		} else {
			sci.increment();
		}
	}
}
