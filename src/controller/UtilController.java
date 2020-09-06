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

import dao.FeedbackDaoImpl;
import pojo.FeedBack;
import utilty.MailFeedback;
@WebServlet("/utility")
public class UtilController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mes=req.getParameter("message");
		HttpSession session=req.getSession();
		
		
			boolean b1=new FeedbackDaoImpl().addFeedback(name, email, mes);
	      if(b1)
			{
	    	  boolean b=new MailFeedback().send(email,"Book by bus",mes);
	    	  if(b) {
	    	  resp.setContentType("text/html");
				PrintWriter pw=resp.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Message Has Been Send');");
				pw.println("</script>");
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				rd.include(req, resp);
				
	    	  }
				else
				{
					session.setAttribute("Error", "feedback");
					 resp.sendRedirect("Fail.jsp");
				}
			}
	      else {
	    	  session.setAttribute("Error", "feedback");
				 resp.sendRedirect("Fail.jsp");
	      }
	       
		}
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		ArrayList<FeedBack> list=(ArrayList<FeedBack>) new FeedbackDaoImpl().listOfFeedback();
	session.setAttribute("list", list);
	resp.sendRedirect("FeedBackList.jsp");
	}
}
