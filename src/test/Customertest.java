package test;

import java.util.ArrayList;
import java.util.Iterator;

import dao.CustomerDaoImpl;
import pojo.Customer;

public class Customertest {
 public static void main(String[] args) {
	CustomerDaoImpl cd=new CustomerDaoImpl();
	boolean b=cd.addCustomer(new Customer("soruav","sourav@mea","123","89750222222","asdfasf"));
	if(b)
		System.out.println("add");
	else
		System.out.println("fail");
	Customer c=cd.searchCustomer("sourav@mea");
	System.out.println(c);
	ArrayList<Customer> al=(ArrayList<Customer>) cd.listOfCustomer();
	Iterator<Customer> it=al.iterator();
	while (it.hasNext())
	{
		System.out.println(it.next());
	}
	 b=cd.deleteCustomer("sourav@mea");
	 if(b)
			System.out.println("add");
		else
			System.out.println("fail");
 }
}
