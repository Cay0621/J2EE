package bean;

import entity.Product;

/**
 * ��Ʒ��Ŀ�ࣺ
 * 	Ϊ�˷���ʵ��Cart��Ĳ�������Ƶ�һ����
 * @author ľʯǰ��Cam
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
