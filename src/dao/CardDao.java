package dao;

import java.util.List;

import pojo.Bus;

public interface CardDao {
	boolean addCart(int busid,int bseat,String email);
	boolean removeItemFromCart(int bid,String email);
	List<Bus> showCart(String emailId);
	boolean clearCart(String emailId);
	boolean updateCartQuantity(int bId,int bseat);

}
