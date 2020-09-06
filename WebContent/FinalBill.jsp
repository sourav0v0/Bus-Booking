<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Order"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%Order o=(Order)session.getAttribute("orderDetail");%>
                  <div align="center">
                    <h3 >Cart Id :<%=o.getOrderId() %></h3>
                    <span class="text-black">Total Bill</span>
                    <strong class="text-black"><%=o.getTotalBill() %></strong>
                    <h3>Your Bill Has been send to your Email Further process is there in the email</h3> 
                    <a href="https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin" target="_blank">Click me to go to Gmail</a>
                    <br>
                    
                    <div class="row">
                  <div class="col-md-12">
                    <button class="btn btn-primary btn-lg btn-block"><a href="OnlinePay.jsp" target="_blank" style="color: white;">Online Payment</a></button>
                  </div>
                  </div>
                  </div>
</body>
</html>