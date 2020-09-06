<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	
.box{
  width: 300px;
  padding: 40px;
  position: relative;
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

.box input[type = "text"],input[type = "number"],input[type = "date"],input[type = "time"],select{
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
.box input[type = "text"]:focus,.box input[type = "number"]:focus,.box input[type = "date"]:focus,.box input[type = "time"]:focus{
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
padding: 200px;}
.fileContainer {
    overflow: hidden;
    position: relative;
}

.fileContainer [type=file] {
    cursor: inherit;
    display: block;
    font-size: 999px;
    margin:30px;
    filter: alpha(opacity=0);
    min-height: 100%;
    min-width: 100%;
    opacity: 0;
    position: absolute;
    right: 0;
    text-align: right;
    top: 0;
}
span{
color: red;}
</style>
<%SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String dateT=formatter.format(new Date());
System.out.println("fate is "+dateT);%>
<script type="text/javascript">
function validateForm()
{
	 var letters = /^[A-Za-z]+$/;
	 var source=document.getElementById("source").value;
	 var Destination=document.getElementById("Destination").value;
	 
		 if(!source.match(letters))
		   {
			 
			 document.getElementById("se").innerHTML = "Fail";
			 return false;
		   }
		 if(!Destination.match(letters))
		   {
			 document.getElementById("de").innerHTML = "Fail";
			 return false;
		  
		   }
	return true;

}

</script>
</head>
<body >

<jsp:include page="Header.jsp"/> 
<p></p>
<div>
	<form class="box" action="BusControl" method="post" onsubmit="return validateForm()">
	  <h1>Add Bus</h1>
	   <input type="hidden" name="Action" value="Add">
	  <input type="text" name="source" id="source" placeholder="SOURCE" required="required">
	  <span id="se"></span>
	  <input type="text" name="Destination" id="Destination" placeholder="DESTINATION" required="required">
	   <span id="de"></span>
	  <input type="number" name="seat" placeholder="SEAT" required="required">
	  <input type="date" name="day" placeholder="DAY MM/dd/yyyy" required="required" value="<%=dateT %>" min="<%=dateT %>" >
	  <input type="time" name="time" placeholder="TIME HH:MM" required="required" >
	  <input type="number" name="amount1" placeholder="AMOUNT" required="required">
	  <select name="type">
	  <option value="AC">AC</option>
	  <option value="NON AC">NON AC</option>
	  </select> 
	  
	
	 
	  <input type="submit" value="Add bus">
	</form>

</div>
</body>
</html>