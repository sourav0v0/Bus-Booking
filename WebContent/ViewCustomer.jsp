<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td { 
                border: 2px solid black; 
                text-align:center; 
            } 
            th, td { 
                padding: 20px; 
                background-color:none; 
            } 
              </style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<table>
<thead>
	<tr>
	<th>Email</th>
	<th>Name</th>
	<th>Contact</th>
	<th>Address</th>
	<td>Delete</td>
	</tr>
</thead>
<%ArrayList<Customer> al=(ArrayList<Customer>) session.getAttribute("listC");
for(int i=0;i<al.size();i++){%>
<tr>
	<td><%=al.get(i).getCustEmailId() %></td>
	<td><%=al.get(i).getCustName() %></td>
	<td><%=al.get(i).getCustContactNo() %></td>
	<td><%=al.get(i).getCustAddress()%></td>
	<td><a href="Customer?Action=delete&email=<%=al.get(i).getCustEmailId()%>">Delete</a></td>
	
<tr>
<%}%>
</table>
</body>
</html>