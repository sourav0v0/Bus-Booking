package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Customer;
import pojo.FeedBack;
import utilty.Dbcon;

public class FeedbackDaoImpl implements FeedBackDao{
	private Connection con=Dbcon.connector();
	@Override
	public boolean addFeedback(String name, String email, String message) {
		String query="insert into feedback values (?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, message);
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
	public boolean delete(String email) {
		String query="delete from feedback where email=?";
		
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

	@Override
	public ArrayList<FeedBack> listOfFeedback() {
		ArrayList<FeedBack> al=new ArrayList<>();
		String query="select * from feedback";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
		
				al.add(new FeedBack(rs.getString(2),rs.getString(1), rs.getString(3)));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return al;
	}

}

