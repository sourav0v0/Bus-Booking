<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div style="text-align: center; position: relative;margin-top: 200px;">
<form action="BusControl" method="post" enctype="multipart/form-data">
	<input type="file" name="data" placeholder="Upload "  required="required"> 
	<input type="submit" >
</form>	 
</div>  	
</body>
</html>