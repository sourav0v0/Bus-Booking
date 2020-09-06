package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.BusDaoImpl;
import pojo.Bus;

@WebServlet("/BusControl")
public class BusController extends HttpServlet{
	/**
	 * 
	 */
	static final String uploadPath="D:\\as\\BusBookin\\WebContent\\Uploadedimage";
	static final String uploadPathHtML="Uploadedimage";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BusDaoImpl bd=new BusDaoImpl();
	static Bus b=null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Action=req.getParameter("Action");
		HttpSession session=req.getSession();
		System.out.println(Action);
		if((Action!=null && Action.equals("updatebus")))
		{
			System.out.println("update the bus");
			String source=(String)req.getParameter("source");
			String Destination=(String)req.getParameter("destination");
			String day=(String)req.getParameter("date");
			String time=(String)req.getParameter("time");
			int amount=Integer.parseInt(req.getParameter("Amount"));
			int id=Integer.parseInt(req.getParameter("id"));
			int seat=Integer.parseInt(req.getParameter("seat"));
			String type=(String)req.getParameter("type");
			Bus b=new Bus(source, Destination, seat, day, time, amount, type,"" );
			b.setBid(id);
			boolean bln=bd.updateBus(b);
			if(bln)
			{
				resp.sendRedirect("BusControl?Action=list");
			}
			else
				resp.sendRedirect("Fail.jsp");
		}
		else if((Action!=null && Action.equals("Add")))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String dateT=formatter.format(date);
			String source=req.getParameter("source");
			String Destination=req.getParameter("Destination");
			int seat=Integer.parseInt(req.getParameter("seat"));
			String day=req.getParameter("day");
			String month=req.getParameter("month");
			String year=req.getParameter("year");
			String time=req.getParameter("time");
			int amt=Integer.parseInt(req.getParameter("amount1"));
			String type=req.getParameter("type");
			b=new Bus(source, Destination, seat, day, time, amt, type, "");
			resp.sendRedirect("imageUpload.jsp");
			}
		else {
			File f=new File(uploadPath);
			String path=null;
			System.out.println(f.exists());
			if(f.exists()) {
			 String[] files = f.list();
			 System.out.println("in filse");
			 ArrayList<String> al=new ArrayList<>();
		        for (String file : files)
		        {
		        	System.out.println(file);
		            al.add(file);
		        }	
			MultipartRequest m=new MultipartRequest(req,uploadPath,100000*1024); 
			String[] file1 = f.list();
			 for (String file : file1)
		        {
		           if(!al.contains(file))
		           {
		        	  
		        	   path=file; 
		           }    	   
		        }
		     if(path!=null) {
		    	 b.setImage(path);
		    	 if(bd.addBus(b)) {
		    		 resp.setContentType("text/html");
						PrintWriter pw=resp.getWriter();
						pw.println("<script type=\"text/javascript\">");
						pw.println("alert('Bus Has Been Added');");
						pw.println("</script>");
						RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
						rd.include(req, resp);}
		    	 }
		    	 else
		    	 {
		    		 
		    		 session.setAttribute("Error", "image");
		    		 resp.sendRedirect("Fail.jsp");
		    	 }
		     }
		
		}}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in");
		String Action=(String)req.getParameter("Action");
		System.out.println(Action);
		String type=(String)req.getParameter("type");

		HttpSession session=req.getSession();
		session.setAttribute("Path", uploadPathHtML);
		//session.setAttribute("generalPath","C:\\imagesForProj\\");				//image path common part setting in session
		if((Action!=null && Action.equals("update")))
		{
			int id=Integer.parseInt(req.getParameter("bid"));
			Bus b=bd.searchBusById(id);
			if(b!=null) {
			session.setAttribute("bus", b);
			resp.sendRedirect("UpdateBus.jsp");
			}
			else
				resp.sendRedirect("Fail.jsp");
			

		}
		else if(Action!=null && Action.equals("delete"))
		{


			int id=Integer.parseInt(req.getParameter("bid"));
			boolean b=bd.deleteBus(id);
			if(b)
				resp.sendRedirect("index.jsp");
			else
				resp.sendRedirect("Fail.jsp");
		}
		if((Action!=null && Action.equals("list"))&&type==null)
		{

			ArrayList<Bus> al=(ArrayList<Bus>) bd.listBus();
			System.out.println(al.size());
			session.setAttribute("BusList", al);
			resp.sendRedirect("ViewAllBus.jsp");
		}
		else if((Action!=null && Action.equals("list"))&&(type!=null && type.equals("AC")))
		{
			System.out.println("ac");
			ArrayList<Bus> al=(ArrayList<Bus>) bd.searchBusByType("AC");

			session.setAttribute("BusList", al);
			resp.sendRedirect("ViewAllBus.jsp");
		}
		else if((Action!=null && Action.equals("list"))&&(type!=null && type.equals("NonAC")))
		{
			System.out.println("type");
			ArrayList<Bus> al=(ArrayList<Bus>) bd.searchBusByType("NON AC");
			session.setAttribute("BusList", al);
			resp.sendRedirect("ViewAllBus.jsp");
		}
		else if((Action!=null && Action.equals("sdlist")))
		{
			String source=(String)req.getParameter("Source");
			String desti=(String)req.getParameter("Destination");
			System.out.println(source+""+desti);
			ArrayList<Bus> al=(ArrayList<Bus>) bd.searchBusBySD(source,desti);
			System.out.println(al.size());
			session.setAttribute("BusList", al);
			resp.sendRedirect("ViewAllBus.jsp");
		}
	}

}
