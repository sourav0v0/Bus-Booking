package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Customer;
import utilty.Dbcon;

public class CustomerDaoImpl implements CustomerDao{
	private Connection con=Dbcon.connector();
	@Override
	public boolean addCustomer(Customer cust) {
		String query="insert into customer(custemail ,custName ,custcontact,custaddress ,custpoint, custpassword) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cust.getCustEmailId());
			ps.setString(2, cust.getCustName());
			ps.setString(3, cust.getCustContactNo());
			ps.setString(4, cust.getCustAddress());
			ps.setInt(5, 0);
			ps.setString(6, cust.getCustPassword());
			int row=ps.executeUpdate();
			if(row>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer cust) {
		String query="update customer set custName=?,custcontact=?,custaddress=?,custpoint=?, custpassword =?  where custemail=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(6, cust.getCustEmailId());
			ps.setString(1, cust.getCustName());
			ps.setString(2, cust.getCustContactNo());
			ps.setString(3, cust.getCustAddress());
			ps.setInt(4, cust.getCustPoints()); 	//cannot b set 
			ps.setString(5, cust.getCustPassword());
			int row=ps.executeUpdate();
			if(row>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Customer searchCustomer(String email) {
		Customer c=null;
		String query="select * from customer where custemail=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{//String custName, String custEmailId, String custPassword, String custContactNo,String custAddress, int custPoints
				c=new Customer(rs.getString("custName"),rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;
			}

	@Override
	public List<Customer> listOfCustomer() {
		ArrayList<Customer> al=new ArrayList<>();
		String query="select * from customer";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer(rs.getString("custName"),rs.getString(1),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				al.add(c);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public boolean deleteCustomer(String email) {
		String query="delete from customer where custemail=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			
			int row=ps.executeUpdate();
			if(row>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

}
