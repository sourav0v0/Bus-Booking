<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
String error=(String)session.getAttribute("Error");
if(error!=null && error.equals("AddedItem")){ %>
<h1 style="color: red;">Fail to Added</h1>
<li>
	<ul type="disc"><h5 style="color: red;">1. Item May be Added in the Cart</h5></ul>
	<ul type="disc"><h5 style="color: red;">2. Try it Later</h5></ul>
	<ul type="disc"><h5 style="color: red;">3. Contact the Admin</h5></ul>
</li>

<%}else if(error!=null && error.equals("Fail_to_Login")){ %>
	<h4 style="color: red;">Fail to Login </h4>
	<h5 style="color: red;">  1. Wrong Credential Passed <br> solution-Create a new User <br><a href="CreateUser.jsp">Click me to create new user</a></h5>
	<h5></h5>
<%}else if(error!=null && error.equals("image")){ %>
	<h4 style="color: red;">Fail to Upload Image </h4>
	<h5 style="color: red;">  1. Re-upload the image<br>2.Re-upload the image With unique Name add some extra character in the name of the file<h5>
<%}else if(error!=null && error.equals("feedback")){ %>
	<h4 style="color: red;">Fail to Upload Your FeedBack </h4>
	<h5 style="color: red;"> 1.Your internet May not be Working <br> 2.Internal Error<h5>
<%}else{ %>
<h4>SomeThing Got Worng</h4>
<%} %>
</body>
</html>