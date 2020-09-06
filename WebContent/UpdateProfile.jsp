<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function vali()
{
	var name=document.getElementById("uname").value;
	var eid=document.getElementById("number").value;
	var letters = /^[A-Za-z]+$/;
	if(!name.match(letters))
		   { 
			 document.getElementById("userMsg").innerHTML = "Please Enter Character";
			 return false;
		   }
	if(eid.length!=10)
	{ 
		 document.getElementById("noMsg").innerHTML = "Please Enter Character";
		 return false;
	   }
	return true;
}
</script>
<body>
<%Customer c=(Customer)session.getAttribute("Customer"); %>
<form class="box" action="Customer" method="get">
	  <h1>Update User</h1>
	  <h6><%=c.getCustEmailId() %></h6>
	  <input type="text"  value="<%=c.getCustName() %>" id="uname" name="name" placeholder="Name " required="required"><span id="userMsg"></span>
	  <input type="number" value="<%=c.getCustContactNo() %>" id="number" name="Number" placeholder="Phone Number"  required="required"><span id="noMsg"></span>	  
	  <input type="text"  value="<%=c.getCustAddress()%>" id="address" name="Address" placeholder="Address" required="required">
	  <input type="submit" value="Update User">
</form>
</body>
</html>