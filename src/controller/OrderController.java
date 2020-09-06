package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDaoImpl;
import pojo.Order;
import utilty.BillForward;
@WebServlet("/OrderControll")
public class OrderController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in order");
		String Action=(String)req.getParameter("Action");
		OrderDaoImpl od=new OrderDaoImpl();
		System.out.println(Action);
		HttpSession session=req.getSession();
		String user=(String)session.getAttribute("uemail");
		if(Action!=null&&Action.equals("bill"))
		{
			int i=od.placeOrder(user);
			System.out.println(i +" order ,id is ");
			if(i>0) {
				Order o=od.showOrder(user);
				BillForward.send(user," INSTRUCTION \n "
						+ "You have to carry a copy of the bill before going to your journey \n "
						+ "Your Order Id is"+ o.getOrderId()
						+"\n Your Total Bill is "+o.getTotalBill()
						+"\n You will Be Contacted Befor you journey By Driver If you are late"
						+"\n If You wont Showup For The Booking you will Be Warned once If again This Happends your account will be Banned"
						+"\n This is the Private Bar Code Dont Share it "
						+"\n https://chart.googleapis.com/chart?chl=BookMyBus"+user+""+o.getOrderId()+"&chs=200x200&cht=qr&chld=H%7C0&g-recaptcha-response=03AOLTBLSsC8rTxRoN30qWKDs8M19ZS7A_B0KUEUp818GRsNrRicEToiuj_6a1N2scjBJqAe6v5sM8sF82gB4yjrI3rGJcUiFRrApisyF2xPTP7D_O9i1hThXqCIYXT69SftZFkunL2Ca7uA1LMZpF4aBxuxp4zjO_dKLVZbKFyDOW4MvrOm8RMuxvHyE4LaT_sbHybvaxbrKFdtqb8qDNw47YwmshDIYX1ALmSNtIUHWPO0gIfAxY2ZObUpSC3I_x1bOxPVosnTBHt62-DUm36oeDPURJu6KAqYRHAxJ1WYaho5NHswXSdTvx3tr9ADfQyVFP0gSoj5zAOkcfex_V1eYDkrAgbcxcgSCLBuXdp-6wa0l3oAN-BiAzZ7LL18fC0E4dkc0sr0OfM5bb8gtqmH56W7I6veDxciOgokvM55QLQJqOOYDgdYQ2FmzMTWnObofLuUD28tQzZg07t5BjCsKjHTg2A9pa-AEwqAng5SESsz377_u29XK3vdVR06Lb16SL8CtdWuKEDlASXu7h5m-H4H6HQAU1Vw");
				session.setAttribute("orderDetail",o);
				System.out.println(od.remove(user));
				resp.sendRedirect("FinalBill.jsp");
			
			}
			else
				resp.sendRedirect("Fail.jsp");
		}
	}

}
