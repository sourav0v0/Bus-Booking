package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import utilty.Dbcon;

public class LoginDaoImpl implements LoginDao
{
	static Connection con=Dbcon.connector();

	@Override
	public boolean userLogin(String emailId, String passwd) 
	{
		String usr,pwd;
		PreparedStatement ps=null;
		ResultSet rs;
		String s="select * from customer where custemail=?";
		try
		{
			ps=con.prepareStatement(s);
			ps.setString(1, emailId);
			rs=ps.executeQuery();
			if(rs.next())
			{
				if(emailId.equals(rs.getString("custemail")) &&passwd.equals(rs.getString("custpassword")))
					return true;	

				else 
					return false;
			}

		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean userChangePassword(String emailId, String newPasswd) 
	{
		String update="update customer set custpassword=? where custemail=?";
		PreparedStatement ps;
		int row =0;
		try
		{
			ps=con.prepareStatement(update);
			ps.setString(1, newPasswd);
			ps.setString(2, emailId);
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean adminLogin(String aemailId, String apasswd) 
	{
		System.out.println(apasswd);
		PreparedStatement ps;
		String login="select * from Admin where email=? and password=?";
		ResultSet rs;
		try
		{
			ps=con.prepareStatement(login);
			ps.setString(1, aemailId);
			ps.setString(2, apasswd);
			rs=ps.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean adminChangePassword(String aemailId, String newPasswd) 
	{
		String update="update Admin set password=? where email=?";
		PreparedStatement ps;
		int row =0;
		try
		{
			ps=con.prepareStatement(update);
			ps.setString(1, newPasswd);
			ps.setString(2, aemailId);
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

}
