<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.left
	{
		margin-top:29px;
		margin-left:170px;
		width:50px;
		height: 600px;
		float: left;
	}
	.right
	{
		margin-top:29px;
		margin-right:170px;
		width:50px;
		height: 600px;
		float: right;
	}
	.container
	{
		position: static;
		
	}
	.right:hover {
	background-color: 1CFF10;
}
	
</style>

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="main">.
<button class="left" onclick="plusDivs(-1)">&#10094;</button>
<button class="right" onclick="plusDivs(1)">&#10095;</button>
<center>
	<div class="container">
	  <img class="mySlides" src="images/frame1.png" style="height: 600px;width: 900px">
	  <img class="mySlides" src="images/frame2.jpg" style="height: 600px;width: 900px">
	  <img class="mySlides" src="images/frame3.jpg" style="height: 600px;width: 900px">
	  <img class="mySlides" src="images/frame4.jpg"style="height: 600px;width: 900px">
	</div>
</center>
</div>
<jsp:include page="FeedBack.jsp"></jsp:include>
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>
<br>
<code>





</code>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>