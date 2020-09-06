package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CardDaoImpl;
import dao.CustomerDaoImpl;
import dao.HistoryDaoImpl;
import dao.LoginDaoImpl;
import dao.OrderDaoImpl;
import pojo.Customer;
import pojo.History;
import utilty.EncryDecry;
@WebServlet("/Customer")
public class CustomerController extends HttpServlet{
	private static CustomerDaoImpl cust=new CustomerDaoImpl();
	private static LoginDaoImpl log=new LoginDaoImpl();
	static String pass;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Action=(String)req.getParameter("Action");
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("ueamil");
		if(Action!=null && Action.equals("BusCustomer"))
		{
			HistoryDaoImpl hd=new HistoryDaoImpl();
			int id=Integer.parseInt(req.getParameter("bid"));
			ArrayList<History> da= hd.showHistory(id);
			session.setAttribute("History", da);
			System.out.println("i m out of here histroy");
			resp.sendRedirect("HistoryList.jsp");
			
		}
		else if(Action!=null && Action.equals("update"))
		{
		
			Customer c=cust.searchCustomer(email);
			if(c!=null)
			{
				pass=c.getCustPassword();
				session.setAttribute("Customer", c);
				
			}
		}
		else if(Action!=null && Action.equals("BusCustomer"))
		{
			OrderDaoImpl id=new OrderDaoImpl();
			ArrayList<Customer> al=(ArrayList<Customer>) cust.listOfCustomer();
			session.setAttribute("listC", al);
			System.out.println("i m out of here");
			resp.sendRedirect("ViewCustomer.jsp");
			
		}
		else if(Action!=null && Action.equals("UpdateCustomer"))
		{
			Customer customer=new Customer(req.getParameter("uname"), email, pass, req.getParameter("Number"), req.getParameter("Address"));
			boolean b=cust.updateCustomer(customer);
			if(b)
				resp.sendRedirect("index.jsp");
			else
				resp.sendRedirect("Fail.jsp");
		}
		else if(Action!=null && Action.equals("delete"))
		{
			email=req.getParameter("email");
			boolean b=cust.deleteCustomer(email);
			if(b)
				resp.sendRedirect("Customer?Action=Custlist");
			else
				resp.sendRedirect("Fail.jsp");
		}
		else if(Action!=null && Action.equals("Custlist")){
			ArrayList<Customer> al=(ArrayList<Customer>) cust.listOfCustomer();
			session.setAttribute("listC", al);
			System.out.println("i m out of here");
			resp.sendRedirect("ViewCustomer.jsp");
			
			
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Action=(String)req.getParameter("Action");
		HttpSession session=req.getSession();
		if(Action!=null && Action.equals("createUser"))
		{
			String email=(String)req.getParameter("email");
			String username=(String)req.getParameter("Username");
			String phoneNo=(String)req.getParameter("Number");
			String pass=(String)req.getParameter("Password");
			String Adderss=(String)req.getParameter("Address");
			Customer c=new Customer(username, email, EncryDecry.encryptThisString(pass), phoneNo, Adderss);
			boolean b=cust.addCustomer(c);
			if(b)
				resp.sendRedirect("Login.jsp");
			else
				resp.sendRedirect("Fail.jsp");
		}
		else if(Action!=null && Action.equals("changeUserPassword")){
			System.out.println("in 4 changfe"+(String)req.getParameter("email") +""+(String)req.getParameter("password"));
			if(log.userChangePassword((String)req.getParameter("email"), EncryDecry.encryptThisString((String)req.getParameter("password"))))
					{
				resp.sendRedirect("index.jsp");
					}
			else
			{
				System.out.println("Fail");
			}
			
		}
		else if(Action!=null && Action.equals("changeAdminPassword")){
			System.out.println("in 4 asd"+(String)req.getParameter("email") +""+(String)req.getParameter("password"));
			if(log.adminChangePassword((String)req.getParameter("email"), EncryDecry.encryptThisString((String)req.getParameter("password"))))
					{
				resp.sendRedirect("index.jsp");
					}
			else
			{
				System.out.println("Fail");
			}
			
		}
		
	}
}
