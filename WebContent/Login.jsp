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
  width: 300px;
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
  font-weight: 500;
}
.box input[type = "email"],.box input[type = "password"],.box input[type = "text"]{
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

	var eid=document.getElementById("email").value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!eid.match(filter))
	   { 
		 document.getElementById("Error").innerHTML = "Please Enter Valid Email";
		 return false;
	   }
	
	return true;
	
}

function showpass(){
	var ps=document.getElementById('ps');
	if(ps.type == "text")
		ps.type = "password";
	else
		ps.type = "text";
}
</script>
<body >
<jsp:include page="Header.jsp"/> 

	<form class="box" action="Login" method="post" onsubmit="return vali()">
	  <h1>Login</h1>
	  <input type="email" name="email" placeholder="Email Id" id="email" required="required"><span id="Error"></span>
	  <input type="password" name="password" id="ps" placeholder="Password" required="required">
	 <input  id="ckb1" type="checkbox"  onclick="showpass();">
	 <label >
							show password
	</label>
	  <input type="submit" value="Login">
	  <a href="CreateUser.jsp">Create Account</a>
	  
	</form>

</body>
</html>