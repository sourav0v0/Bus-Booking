package dao;

public interface LoginDao 
{
	boolean userLogin(String emailId,String passwd);
	boolean userChangePassword(String emailId,String newPasswd);
	boolean adminLogin(String aemailId,String apasswd);
	boolean adminChangePassword(String aemailId,String newPasswd);
}
