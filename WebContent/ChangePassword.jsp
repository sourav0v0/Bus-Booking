<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	
.box{
  padding: 40px;
  position: absolute;
  top :50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background: white;
  text-align: center;
}
.box h1{
  color: black;
  text-transform: uppercase;
  font-weight: 300 	;
}
.box input[type = "email"],.box input[type = "password"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: gray;
  border-radius: 24px;
  transition: 0.25s;
}
.box input[type = "email"]:focus,.box input[type = "password"]:focus{
  width: 280px;
  border-color: #2ecc71;
}
.box input[type = "submit"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #2ecc71;
  padding: 14px 40px;
  outline: none;
  color: gray;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}
.box input[type = "submit"]:hover{
  background: #2ecc71;
}	

p{
padding: 100px;}
</style>
<script type="text/javascript">
function vali()
{
	var x=document.getElementById("Np").value;
	var y=document.getElementById("Cp").value;	
	if (x != y) {
	    alert(" Password dosent match");
	    return false;
	  }
	return true;
	
}
</script>
<body >
<jsp:include page="Header.jsp"/> 
<%String aemail=(String)session.getAttribute("aemail");
String uemail=(String)session.getAttribute("uemail");
if(uemail==null && aemail!=null){ %>	
 <h1>Change Password</h1>															<!-- Admin -->
	<form class="box" action="Customer" method="post">
	<input type="hidden" name="Action" value="changeAdminPassword">
	  <input type="email" name="email" placeholder="Username" value=<%=aemail %> readonly="readonly">
	  <input type="password"  id="Np" placeholder=" New Password" required="required">
	  <input type="password" id="Cp" name="password" placeholder="Confirm Password" required="required">
	  <input type="submit" value="Change Password">	  
	</form>
<%}if(aemail==null &&uemail !=null){ %>													<!-- User -->
<form class="box" action="Customer" method="post" onsubmit="return vali()">
	  <h1>Change Password</h1>
	  <input type="hidden" name="Action" value="changeUserPassword">
	  <input type="email" name="email" readonly="readonly" placeholder="Username" value=<%=uemail %>>
	  <input type="password" id="Np" placeholder="New Password">
	  <input type="password" id="Cp"name="password" placeholder="Confirm Password">
	  <input type="submit" value="Change Password"> 
	</form>
<%} %>

</body>
</html>