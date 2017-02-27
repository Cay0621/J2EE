package bean;

import entity.Product;

/**
 * 商品条目类：
 * 	为了方便实现Cart类的操作而设计的一个类
 * @author 木石前盟Cam
 *
 */
public class CartItem {
	private Product pro;
	private int count;
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
