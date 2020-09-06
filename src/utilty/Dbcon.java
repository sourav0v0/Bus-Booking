package utilty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {
	public static Connection connector()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/CoreProj","root","root");
		} catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		Connection con=connector();
		if(con==null)
			System.out.println("Fail");
		else
			System.out.println("Suck");
	}
}
