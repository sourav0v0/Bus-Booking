package test;

import java.util.concurrent.SynchronousQueue;

import dao.OrderDaoImpl;

public class OrderTest {
public static void main(String[] args) {
	OrderDaoImpl od=new OrderDaoImpl();
/*	int i=od.placeOrder("sourav@mea");
	System.out.println(i)*/;
	//System.out.println(od.showOrder("sourav@mea"));
	//System.out.println(od.incrementPoints("sourav@mea"));

	java.util.Date date=new java.util.Date(System.currentTimeMillis());
	System.out.println(date.getDate());
}
}
