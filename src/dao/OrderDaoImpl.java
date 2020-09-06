package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Bus;
import pojo.Cart;
import pojo.Order;
import utilty.Dbcon;


public class OrderDaoImpl implements OrderDao {
	private static CardDaoImpl cdi=new CardDaoImpl();
	Connection con=Dbcon.connector();
	@Override
	public int placeOrder(String emailId) {
		List<Cart> c=new CardDaoImpl().showCartData(emailId);
		
		try {
			for(int i=0;i<c.size();i++) {
				String que="insert into history values (?,?,?)";
				PreparedStatement ps= con.prepareStatement(que);
			ps.setString(3,c.get(i).getCustEmail());
			ps.setInt(1,c.get(i).getBid());
			ps.setInt(2,c.get(i).getBseat());
			int q=ps.executeUpdate();
			if(q>0)
			{
				
			}
			System.out.println("u came in jogesh ahhhh");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String query=" select sum(c.bseat *b.amount) from cart as c inner join bus as b on c.bid=b.bid and custemail=?;";
		int i=0;
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,emailId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				int totalAmount=rs.getInt(1);
				query="insert into orderBus (custemail,totalbill) values (?,?)";
				ps= con.prepareStatement(query);
				ps.setString(1, emailId);
				ps.setInt(2, totalAmount);
				int i1=ps.executeUpdate();
				if(i1>0)
				{
				
					query="insert into bill (custemail,totalbill) values (?,?)";
					ps= con.prepareStatement(query);
					ps.setString(1, emailId);
					ps.setInt(2, totalAmount);
					i1=ps.executeUpdate();
					if(i1>0) {
						cdi.clearCart(emailId);			//clearing the card 
						query="select id from bill where custemail=? and totalbill=?";
						ps= con.prepareStatement(query);
						ps.setString(1,emailId);
						ps.setInt(2,totalAmount);
						 rs=ps.executeQuery();
						if(rs.next())
						{
							return rs.getInt(1);
						}
					}

				}


			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;

	}
	public boolean remove(String emailId) {
		String query="delete  from orderBus where custemail=?;";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1,emailId);
			int rs=ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public Order showOrder(String emailId) {
		String query="select * from orderBus where custemail=?;";
		ArrayList<Order> al=new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1,emailId);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{

				Order o=new Order(rs.getInt(1), rs.getString(2), rs.getInt(3));
				return o;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Order> getAllOrder() {
		String query="select * from orderBus";
		ArrayList<Order> al=new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);

			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{

				Order o=new Order(rs.getInt(1), rs.getString(2), rs.getInt(3));
				al.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return al;
	}


	@Override
	public boolean incrementPoints(String emailId) {
		String query="select sum(totalbill) from orderBus where custemail=?;";
		PreparedStatement ps;
		int total;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1,emailId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				total=rs.getInt(1);		
				if(total>1000)
				{
					int pinc=checker(total,1);
					query="update customer set custpoint=? where custemail=?";				
					ps= con.prepareStatement(query);
					ps.setInt(1,pinc*10);
					ps.setString(2,emailId);	
					int i=ps.executeUpdate();
					if(i>0)
						return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	int checker(int total,int returnValue)		//return Values always b one
	{
		if(total>1000)
		{
			returnValue=1+returnValue;
			total=total-1000;
			checker(total,returnValue);
		}

		return returnValue;

	}
	
}
