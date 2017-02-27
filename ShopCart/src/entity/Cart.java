package entity;

import java.util.HashMap;
import java.util.Set;

public class Cart {

	//购物车商品集合
	private HashMap<Items, Integer> goods;
	
	//购物车商品总金额
	private double totalPrice;
	
	public Cart() {
		super();
		goods = new HashMap<Items, Integer>();
		totalPrice = 0.0;
	}

	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//向购物车添加商品
	public boolean addGoodsInCart(Items item, int number){
		if(goods.containsKey(item)){
			goods.put(item, goods.get(item) + number);
		}
		else
			goods.put(item, number);
		
		//重新计算总金额
		calTotalPrice();
		return true;
	}
	
	//从购物车删除指定商品
	public boolean removeGoodsFromCart(Items item){
		goods.remove(item);
		
		//重新计算总金额
		calTotalPrice();
		return true;
	}
	
	//计算购物车总金额
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Items> keys = goods.keySet();
		for (Items items : keys) {
			double price = items.getPrice();
			sum += price * goods.get(items);
		}
		this.setTotalPrice(sum);
		return totalPrice;
	}
}
