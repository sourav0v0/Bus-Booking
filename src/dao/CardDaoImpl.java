package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Bus;
import pojo.Cart;
import utilty.Dbcon;

public class CardDaoImpl implements CardDao {
	Connection con=Dbcon.connector();
	@Override
	public boolean addCart(int busid,int bseat,String email) {
		String query="select * from cart where bid=? and custemail=?";
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,busid);
			ps.setString(2,email);		
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return false;
			else
			{
				 query=" insert into cart (bid,bseat,custemail) values(?,?,?);";				
					try {
						ps= con.prepareStatement(query);
						ps.setInt(1,busid);
						ps.setInt(2,bseat);
						ps.setString(3,email);		
						int row=ps.executeUpdate();
						if(row>0)
							return true;
						else
							return false;
					} catch (SQLException e) {

						e.printStackTrace();
					}
			}
				
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Bus> showCart(String emailId) {
		String query="select * from cart as c inner join bus as b on c.bid=b.bid and custemail=?;";
		ArrayList<Bus> b=new ArrayList<>();
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,emailId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				//int bid, String bsource, String bdestination, int bseat, String day, String time
				Bus b1=new Bus(rs.getString("source"),rs.getString("destination"),rs.getInt("seat"),rs.getString("day"),rs.getString("time"),rs.getInt("amount"),rs.getString("type"),rs.getString("image"));
				b1.setBid(rs.getInt("bid"));
				b.add(b1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return b;
	}


	@Override
	public boolean clearCart(String emailId) {
		String query=" delete from cart where custemail=?";
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,emailId);		
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
	public boolean updateCartQuantity(int CartId, int quantity) {
		String query="select * from cart where cartid=?";
		int bid=0;
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,CartId);	
			ResultSet rs=ps.executeQuery();
			if(rs.next())		{		
				bid=rs.getInt("bid");
				query=" update cart set bseat=? where bid=?";
				Bus b=new BusDaoImpl().searchBusById(bid);
				if(b.getBseat()>=quantity) {
					try {
						ps= con.prepareStatement(query);
						ps.setInt(1,quantity);	
						ps.setInt(2,bid);		
						int row=ps.executeUpdate();
						if(row>0) {
							b.setBseat(b.getBseat()-quantity);
							new BusDaoImpl().updateBus(b);
							return true;}
						else
							return false;
						}
				
				catch (SQLException e) {

					e.printStackTrace();
				}}}

		}
		catch (Exception e) {
			e.printStackTrace();
		}				return false;
			}

			@Override
			public boolean removeItemFromCart(int bid, String email) {
				String query=" delete from cart where custemail=? and bid=?";
				try {
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,email);	
					ps.setInt(2,bid);		
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
			
			public int noOfItem(String email) {
				String query=" select count(*) from cart where custemail=?";
				try {
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,email);	
					ResultSet rs=ps.executeQuery();
					if(rs.next()) 
						return rs.getInt(1);
					else
						return 0;
				} catch (SQLException e) {

					e.printStackTrace();
				}
				return 0;
			}
			public ArrayList<Integer> cartId(String email)
			{
				String query="select * from cart where custemail=?;";
				ArrayList<Integer> b=new ArrayList<>();
				try {
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,email);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						b.add(rs.getInt("cartid"));
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

				return b;
			}
			public ArrayList<Integer> seatOfBus(String email)
			{
				String query="select * from cart where custemail=?;";
				ArrayList<Integer> b=new ArrayList<>();
				try {
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,email);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						b.add(rs.getInt("bseat"));
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

				return b;
			}
			public boolean CheckSeat(String email)
			{
				String query="select bus.seat-cart.bseat from bus,cart where cart.bid=bus.bid && custemail=?";
				try {
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,email);	
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						if(rs.getInt(1)<0)
							{
							return false;
							}
					}
					return true;
				} catch (SQLException e) {

					e.printStackTrace();
				}


				return false;
			}
			public List<Cart> showCartData(String emailId) {
				String query="select * from cart where custemail=?;";
				ArrayList<Cart> b=new ArrayList<>();
				try {
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,emailId);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						
						Cart c=new Cart(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4));
						b.add(c);
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

				return b;
			}
		}
