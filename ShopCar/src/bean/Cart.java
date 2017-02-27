package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类： 为了方便对session进行操作而设计的一个类 提供了商品的添加、删除、修改、清空、计价及列表操作
 * 
 * @author 木石前盟Cam
 *
 */
public class Cart {
	// items用来保存用户所购买的所有商品
	private List<CartItem> items = new ArrayList<CartItem>();

	// 添加商品：需要对items进行遍历，
	// 如果已经购买过该商品，则不再添加，并且返回false；
	// 否则，将该商品添加到列表中，返回true
	public boolean add(CartItem item) {
		for (CartItem cartItem : items) {
			if (item.getPro().getId() == cartItem.getPro().getId()) {
				// 已经购买过
				return false;
			}
		}
		//没有买过
		items.add(item);
		return true;
	}
	
	//计价
	public int cost(){
		int total = 0;
		for (CartItem cartItem : items) {
			total += cartItem.getPro().getPrice() * cartItem.getCount();
		}
		return total;
	}
	
	//返回用户所购买的所有商品
	public List<CartItem> list(){
		return items;
	}
	
	public void del(int id){
		for (CartItem cartItem : items) {
			if(cartItem.getPro().getId() == id){
				items.remove(cartItem);
				break;
			}
		}
	}
	
	public void clear(){
		items.clear();
	}
	
	public void modify(int id, int value){
		for (CartItem cartItem : items) {
			if(cartItem.getPro().getId() == id){
				cartItem.setCount(value);
			}
		}
	}
}
