package dao;

import java.util.List;

import pojo.Customer;

public interface CustomerDao {
boolean addCustomer(Customer cust);
boolean updateCustomer(Customer cust);
Customer searchCustomer(String email);
List<Customer> listOfCustomer();
boolean deleteCustomer(String email);
}
