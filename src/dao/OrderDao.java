package dao;

import java.util.List;

import pojo.Order;

public interface OrderDao {
	int placeOrder(String emailId);
	
	Order showOrder(String emailId);
	List<Order>getAllOrder();
	boolean incrementPoints(String emailId);
}
