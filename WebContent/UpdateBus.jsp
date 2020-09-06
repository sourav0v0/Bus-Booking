<%@ page import="pojo.Bus"%>
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
.box input[type = "text"],.box input[type = "password"],.box input[type = "number"],.box input[type = "date"],.box input[type = "time"]{
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
.box input[type = "text"]:focus,.box input[type = "password"]:focus,.box input[type = "number"]:focus,.box input[type = "date"]:focus,.box input[type = "time"]:focus{
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
padding: 300px;}
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
span{
display: none;
}	
 
}
   
	
</style>
<script type="text/javascript">
function validateForm()
{
	 var letters = /^[A-Za-z]+$/;
	 var source=document.getElementById("source").value;
	 var Destination=document.getElementById("destination").value;
	
		 if(!source.match(letters))
		   {
			 
			 document.getElementById("se").innerHTML = "Enter Only Character";
			 return false;
		   }
		 if(source.match(letters))
		   {
			 document.getElementById("de").innerHTML = "Enter Only Character";
			 return false;
		  
		   }
		

	return true;

}

</script>
</head>
<body>
<%SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String dateT=formatter.format(new Date());
System.out.println("fate is "+dateT);%>
<jsp:include page="Header.jsp"></jsp:include>
<%Bus b=(Bus)session.getAttribute("bus"); %>
<form class="box" action="BusControl" method="post" >
<p></p>
	  <h1>Update Bus</h1>
	  <input type="hidden" name="Action" value="updatebus">
	  <input type="hidden" name="id" value="<%=b.getBid()%>">
	  <input type="hidden" name="type" value="<%=b.getType()%>">
	  <input type="text" name="source" id="source" placeholder="source" value="<%=b.getBsource()%>" required="required"><span id="se"></span>
	  <input type="text" name="destination" id="destination" placeholder="destination" value="<%=b.getBdestination()%>" required="required"><span id="de"></span>
	  <input type="number" name="seat" placeholder="seat" value="<%=b.getBseat() %>"  required="required" >
	  <input type="date" name="date" placeholder="date" value="<%=b.getDay() %>" required="required"  min="<%=dateT %>">
	  <input type="time" name="time" placeholder="time" value="<%=b.getTime() %>" required="required">
	  <input type="number"  name="Amount" placeholder="Amount" value="<%=b.getAmount() %>" required="required">
	  <input type="submit" value="Update bus">
	</form>
</body>
</html>