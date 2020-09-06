<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.box{
 max-width: 600px;
 min-width:285px;
 
  position: relative;
  
  left: 50%;
  transform: translate(-50%,-50%);
  background: white;
  text-align: center;
}
.box h1{
  color: gray;
  text-transform: uppercase;
  font-weight: 500;
}
.box input[type = "text"],.box input[type = "password"],.box input[type = "number"]{
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
.box input[type = "text"]:focus,.box input[type = "password"]:focus,.box input[type = "number"]:focus{
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
padding: 150px;}
.Error
{
position: absolute;
	float: right;
	background-color: black;
}
#passwordError
{
color: red;
}
	
 
}
   
	
</style>
<script type="text/javascript">
function vali()
{
	var name=document.getElementById("uname").value;
	var eid=document.getElementById("eid").value;
	var x=document.getElementById("rp").value;
	var y=document.getElementById("cp").value;
	var con=document.getElementById("number").value;
	var letters = /^[A-Za-z]+$/;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(!name.match(letters))
		   { 
			 document.getElementById("errorName").innerHTML = "Please Enter Character";
			 return false;
		   }
	if(!eid.match(filter))
	   { 
		 document.getElementById("errorEmail").innerHTML = "Please Enter Valid Email";
		 return false;
	   }
	if (con.length<10) {
	    alert("Invalid phone number");
	    return false;
	  }
	if (x.length<10) {
	    alert("Length of password is less than 10");
	    return false;
	  }
	if (x != y) {
	    alert("New Password and Confirm Password dosent match");
	    return false;
	  }
	return true;
}



</script>
</head>
<body>
<jsp:include page="Header.jsp"/> 
<p></p>

<form class="box" action="Customer" method="post" onsubmit="return vali()">
	  <h1>Create User</h1>
	  <input type="hidden" name="Action" value="createUser">
	  <input type="text" name="email" id="eid" placeholder="Email Id" required="required"  autocomplete="off"><span id="errorEmail"></span>
	  <input type="text" id="uname" name="Username" placeholder="Name" required="required" autocomplete="off"><span id="errorName"></span>
	  <input type="number" id="number" name="Number" placeholder="Phone Number"  required="required" autocomplete="off">
	  <input type="password" id="rp" name="" placeholder="Password"  required="required" autocomplete="off">
	  <input type="password" id="cp" name="Password" placeholder="Confirm Password"  required="required" autocomplete="off">
	  <input type="text" id="address" name="Address" placeholder="Address" required="required" autocomplete="off">
	  <input type="submit" value="Create User">
	</form>
</body>
</html>