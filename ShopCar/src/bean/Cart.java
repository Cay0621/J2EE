package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ﳵ�ࣺ Ϊ�˷����session���в�������Ƶ�һ���� �ṩ����Ʒ����ӡ�ɾ�����޸ġ���ա��Ƽۼ��б����
 * 
 * @author ľʯǰ��Cam
 *
 */
public class Cart {
	// items���������û��������������Ʒ
	private List<CartItem> items = new ArrayList<CartItem>();

	// �����Ʒ����Ҫ��items���б�����
	// ����Ѿ����������Ʒ��������ӣ����ҷ���false��
	// ���򣬽�����Ʒ��ӵ��б��У�����true
	public boolean add(CartItem item) {
		for (CartItem cartItem : items) {
			if (item.getPro().getId() == cartItem.getPro().getId()) {
				// �Ѿ������
				return false;
			}
		}
		//û�����
		items.add(item);
		return true;
	}
	
	//�Ƽ�
	public int cost(){
		int total = 0;
		for (CartItem cartItem : items) {
			total += cartItem.getPro().getPrice() * cartItem.getCount();
		}
		return total;
	}
	
	//�����û��������������Ʒ
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
