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

</style>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script  src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet">
<script>
$(document).ready(function(){
	var minDate =new Date();
	$("#return").datepicker({
		showAnim:'drop',
		numberOfMonth:1,
		minDate : minDate,
		dateFormat:'dd/mm/yy',
		onClose: function selectDate() {
			$('#return').datepicker("option","minDate",selectDate)
		}
	})
});
</script>
<%-- <%
Date date = new Date();
%>
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

</script> --%>
</head>
<body >
<div>
<jsp:include page="Header.jsp"></jsp:include>
</div>
<div >
<input type="text" id="return">
</div>
</body>
</html>