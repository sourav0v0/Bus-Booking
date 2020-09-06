<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
     <%@ page import="pojo.FeedBack"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>
<jsp:include page="Header.jsp"></jsp:include>
<center>
<div>
<%ArrayList<FeedBack> al=(ArrayList<FeedBack>) session.getAttribute("list");%>
<%if(al.size()>0){ %>
<table>
<thead>
	<tr>
	<th>Email</th>
	<th>Name</th>
	<th>Message</th>
	
	</tr>
</thead>

<% for(int i=0;i<al.size();i++){%>
<tr>
	<td><%=al.get(i).getEmail()%></td>
	<td><%=al.get(i).getName() %></td>
	<td><%=al.get(i).getMessage() %></td>
<tr>
<%}%>
</table>
<%}else{%>
Sorry No data Available
<%}%>
</div>
</center>
</body>
</html>