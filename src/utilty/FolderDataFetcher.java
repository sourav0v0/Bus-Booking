package utilty;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class FolderDataFetcher {
	public static String returnFileName(String[] name)
	{
		Connection con=Dbcon.connector();
		File folder = new File("D:\\eclip_WorkSpace\\College\\BusTicketBooking\\WebContent\\BusImage");	 
		if(name!=null) {
		for (String file : name)
		{
			PreparedStatement ps;
			try {
				for(int i=0;i<name.length;i++) {
					ps = con.prepareStatement("select * from bus where image=?");
					ps.setString(1,name[i]);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						if(rs.getString("image").equals(name[i]))
						{

						}
						else
							return name[i];

					}

				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		return null;

	}
}
