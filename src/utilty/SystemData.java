package utilty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemData {
	public static String[] getDateTime()
	{
		LocalDateTime myDateObj = LocalDateTime.now(); 
	     
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");     
	    String formattedDate = myDateObj.format(myFormatObj); 
	    String[] dateTime=formattedDate.split(" ");
	    return dateTime;
 	}
	

}
