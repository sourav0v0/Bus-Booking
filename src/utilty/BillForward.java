package utilty;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BillForward {
	 public static boolean send(String to,String msg){     
		 String from=""; // Email id and passowrd
		 String password=""; // Email id and passowrd
         Properties props = new Properties();    
         props.put("mail.smtp.host", "smtp.gmail.com");    
         props.put("mail.smtp.socketFactory.port", "465");    
         props.put("mail.smtp.socketFactory.class",    
                   "javax.net.ssl.SSLSocketFactory");    
         props.put("mail.smtp.auth", "true");    
         props.put("mail.smtp.port", "465"); 
         //get Session   
         Session session = Session.getInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication("","");  // Email id and passowrd
          }    
         });    
         //compose message    
         try {    
          MimeMessage message = new MimeMessage(session);
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
          message.setSubject("In Regards Of Bill");    
          message.setText(msg);    
          //send message  
          Transport.send(message);    
          return true;
          
         } catch (MessagingException e) {
        	 
        	e.printStackTrace();
        	 return false;}    
            
   }  
 
}
