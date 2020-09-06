package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;



import pojo.Bus;
import utilty.Dbcon;

public class BusDaoImpl implements BusDao {
	private final Connection con=Dbcon.connector();
	@Override
	public boolean addBus(Bus b) {
		String query="insert into bus (source,destination,seat,day,time,amount,type,image)values(?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,b.getBsource());
			ps.setString(2,b.getBdestination());
			ps.setInt(3,b.getBseat());
			ps.setString(4,b.getDay());
			ps.setString(5,b.getTime());	
			ps.setInt(6,b.getAmount());
			ps.setString(7,b.getType());	
			ps.setString(8,b.getImage());	
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
	public boolean updateBus(Bus b) {
		String query="update bus set source =?,destination=?,seat=?,day=?,time=?,amount=?,type=? where bid=? ";
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,b.getBsource());
			ps.setString(2,b.getBdestination());
			ps.setInt(3,b.getBseat());
			ps.setString(4,b.getDay());
			ps.setString(5,b.getTime());
			ps.setInt(6,b.getAmount());
			ps.setString(7,b.getType());
			ps.setInt(8,b.getBid());
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
	public boolean deleteBus(int id) {
		String query="delete from bus where bid=? ";
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,id);
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
	public List<Bus> listBus() {
		String query="select * from bus";
		ArrayList<Bus> al=new ArrayList<>();
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(" in");
				//String bsource, String bdestination, int bseat, String day, String time, int amount,String type,String image
			Bus b=new Bus(rs.getString("source"),rs.getString("destination"),rs.getInt("seat"),rs.getString("day"),rs.getString("time"),rs.getInt("amount"),rs.getString("type"),rs.getString("image"));
			b.setBid(rs.getInt("bid"));
			System.out.println("Add");
			al.add(b);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public Bus searchBusById(int id) {
		String query="select * from bus where bid=? ";
		Bus b=null;
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				//int bid, String bsource, String bdestination, int bseat, String day, String time
				b=new Bus(rs.getString("source"),rs.getString("destination"),rs.getInt("seat"),rs.getString("day"),rs.getString("time"),rs.getInt("amount"),rs.getString("type"),rs.getString("image"));
				b.setBid(rs.getInt("bid"));	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public List<Bus> searchBusBySD(String source, String Destination) {
		String query="select * from bus where source=? and destination =?";
		ArrayList<Bus> al=new ArrayList<>();
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, source);
			ps.setString(2, Destination);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				//int bid, String bsource, String bdestination, int bseat, String day, String time
				Bus b=new Bus(rs.getString("source"),rs.getString("destination"),rs.getInt("seat"),rs.getString("day"),rs.getString("time"),rs.getInt("amount"),rs.getString("type"),rs.getString("image"));
				b.setBid(rs.getInt("bid"));			
			al.add(b);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public boolean updateBusList(String date,String time) {
		String query="delete from bus where STR_TO_DATE(day, '%Y/%m/%d')>STR_TO_DATE(?, '%Y/%m/%d') and Time(time)>Time(?);";
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,date);
			ps.setString(2,time);
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
	public List<Bus> searchBusByType(String type) {
		String query="select * from bus where type=?";
		ArrayList<Bus> al=new ArrayList<>();
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, type);		
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				//int bid, String bsource, String bdestination, int bseat, String day, String time
				Bus b=new Bus(rs.getString("source"),rs.getString("destination"),rs.getInt("seat"),rs.getString("day"),rs.getString("time"),rs.getInt("amount"),rs.getString("type"),rs.getString("image"));
				b.setBid(rs.getInt("bid"));			
			al.add(b);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return al;
	}
	public static void main(String[] args) {
		BusDaoImpl bd=new BusDaoImpl();
		System.out.println(bd.listBus().size());
	}
}
