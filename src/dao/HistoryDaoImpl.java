package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Customer;
import pojo.History;
import utilty.Dbcon;

public class HistoryDaoImpl {
	public ArrayList<History> showHistory(int id){
Connection con=Dbcon.connector();
	ArrayList<History> al=new ArrayList<>();
	String query="select * from History where bid=?";
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			History h=new History(rs.getInt(1), rs.getInt(3), rs.getString(2));
			al.add(h);
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return al;
}}