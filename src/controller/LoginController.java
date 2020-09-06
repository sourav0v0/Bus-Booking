package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDaoImpl;
import utilty.EncryDecry;
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("asdfa");
		HttpSession session=req.getSession();
		session.invalidate();
		resp.sendRedirect("Login.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginDaoImpl ldi= new LoginDaoImpl();
		HttpSession session=req.getSession();
		
		if(ldi.userLogin((String)req.getParameter("email"), EncryDecry.encryptThisString(req.getParameter("password"))))
		{
		session.setAttribute("uemail",(String)req.getParameter("email"));
		resp.sendRedirect("index.jsp");
		}
		else
		{
			if(ldi.adminLogin((String)req.getParameter("email"), EncryDecry.encryptThisString(req.getParameter("password"))))
			{
			session.setAttribute("aemail",(String)req.getParameter("email"));
			resp.sendRedirect("index.jsp");
			}
			else {
				resp.setContentType("text/html");
				PrintWriter pw=resp.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Invalid Username or Password');");
				pw.println("</script>");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.include(req, resp);
				
			}
		}
			
	}

}
