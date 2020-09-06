package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CardDaoImpl;
import pojo.Bus;
import pojo.Cart;
@WebServlet("/CartController")
public class CartController extends HttpServlet{
	CardDaoImpl cdi=new CardDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int quan=Integer.parseInt(req.getParameter("quantity"));
		int quantity[];
		//cdi.updateCartQuantity(,);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Action =(String)req.getParameter("Action");
		System.out.println("Cart Controll Action"+Action);
		HttpSession session=req.getSession();
		String Currentuser =(String)session.getAttribute("uemail");
		System.out.println("Cart Cont Current User"+Currentuser);
		if(Action!=null  && Action.equals("add")) {
			
			System.out.println("Enter in add action");
			int BusId=Integer.parseInt(req.getParameter("bid"));
			boolean b=cdi.addCart(BusId, 1,Currentuser);
			System.out.println(b);
			if (b)
				resp.sendRedirect("BusControl?Action=list");
			else {
				resp.setContentType("text/html");
				PrintWriter pw=resp.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Item  May be added in the Cart');");
				pw.println("</script>");
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				rd.include(req, resp);
			}
		}
		else if(Action!=null  && Action.equals("cartItem"))
		{
			System.out.println("Cart Controll Action"+Action);
			ArrayList<Bus> al=(ArrayList<Bus>) cdi.showCart(Currentuser);
		    ArrayList<Integer> Quantity=cdi.seatOfBus(Currentuser);		    
			System.out.println("lent of cart"+al.size());
			session.setAttribute("Quantity", Quantity);
			session.setAttribute("Data",al);
			resp.sendRedirect("ShopCart.jsp");
		}
		else if(Action!=null  && Action.equals("update"))
		{
			ArrayList<Bus> al=(ArrayList<Bus>) cdi.showCart(Currentuser);
			ArrayList<Integer> bid=new ArrayList<>();
			boolean b=false;
			ArrayList<Integer> Quantity=new ArrayList<>();
			for(int i=0;i<al.size();i++)
			{
			   
				 Bus bus=al.get(i);
				 int quan=Integer.parseInt(req.getParameter(""+bus.getBid()));
				 Quantity.add(quan);
			}
			
			ArrayList<Integer> CartID=(ArrayList<Integer>)cdi.cartId(Currentuser);
			for(int i=0;i<Quantity.size()&&i<CartID.size();i++)
			{
				b=cdi.updateCartQuantity(CartID.get(i), Quantity.get(i));	
			}
			if(b)
			{
				session.setAttribute("Quantity", Quantity);
				resp.setContentType("text/html");
				PrintWriter pw=resp.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Cart has been Updated');");
				pw.println("</script>");
				RequestDispatcher rd=req.getRequestDispatcher("");
				rd.include(req, resp);
				resp.sendRedirect("CartController?Action=cartItem");
				
			}
			else
			{
				resp.setContentType("text/html");
				PrintWriter pw=resp.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Please check the seat Available');");
				pw.println("</script>");
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				rd.include(req, resp);
				}
			}
		
		else if(Action!=null  && Action.equals("remove"))	
		{
			 int bid =Integer.parseInt(req.getParameter("bid"));
			 boolean b=cdi.removeItemFromCart(bid, Currentuser);
			 if(b)
				 resp.sendRedirect("CartController?Action=cartItem");
			 else
				 resp.sendRedirect("Fail.jsp");
		}
		else
		{
			System.out.println("Cart Controll Action"+Action);
			ArrayList<Bus> al=(ArrayList<Bus>) cdi.showCart(Currentuser);
		    ArrayList<Integer> Quantity=cdi.seatOfBus(Currentuser);		    
			System.out.println("lent of cart"+al.size());
			session.setAttribute("Quantity", Quantity);
			session.setAttribute("Data",al);
			resp.sendRedirect("ShopCart.jsp");
		}
		
	}

}
