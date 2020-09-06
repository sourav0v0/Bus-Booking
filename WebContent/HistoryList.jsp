<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.History"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History Data</title>
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
<center>
<table border="1">
<thead >
<tr>
	<td>Bus ID</td>
	<td>Customer Email</td>
	<td>Seat</td>
</tr>
<%ArrayList<History>data =(ArrayList<History>)session.getAttribute("History"); 
for(int i=0;i<data.size();i++){%>

								<tr>
									<td><%=data.get(i).getBid()%></td>
									<td><%=data.get(i).getName()%></td>
									<td><%=data.get(i).getSeat()%></td>
								</tr>
								

<%} %>
</thead>
</table>
</center>
</body>
</html>