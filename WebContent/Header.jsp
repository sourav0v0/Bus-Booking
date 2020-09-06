<%@page import="dao.CustomerDaoImpl"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.CardDaoImpl"%>
<%@ page import="dao.BusDaoImpl"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BookMyBus &mdash;</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">


<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">
<style type="text/css">
.gooey
  position: absolute
  top: 50%
  left: 50%
  width: 142px
  height: 40px
  margin: -20px 0 0 -71px
  background: white
  filter: contrast(20)
  .dot
    position: absolute
    width: 16px
    height: 16px
    top: 12px
    left: 15px
    filter: blur(4px)
    background: #000
    border-radius: 50%
    transform: translateX(0)
    animation: dot 2.8s infinite
  .dots
    transform: translateX(0)
    margin-top: 12px
    margin-left: 31px
    animation: dots 2.8s infinite
    span
      display: block
      float: left
      width: 16px
      height: 16px
      margin-left: 16px
      filter: blur(4px)
      background: #000
      border-radius: 50%

@keyframes dot
  50%
    transform: translateX(96px)
@keyframes dots
  50%
    transform: translateX(-31px)</style>
</head>
<body>
<script>
$(document).ready(function() {
//Preloader
$(window).on("load", function() {
preloaderFadeOutTime = 500;
function hidePreloader() {
var preloader = $('.gooey');
preloader.fadeOut(preloaderFadeOutTime);
}
hidePreloader();
});
});
</script>
<div class="gooey">
  <span class="dot"></span>
  <div class="dots">
    <span></span>
    <span></span>
    <span></span>
  </div>
</div>

<%
/* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
LocalDateTime now = LocalDateTime.now();  
String date[]=dtf.format(now).split(" ");
new BusDaoImpl().updateBusList(date[0],date[1]);  */
String aemail=(String)session.getAttribute("aemail");
String uemail=(String)session.getAttribute("uemail");
CardDaoImpl cdi=new CardDaoImpl();
int itemNumber=cdi.noOfItem(uemail);  	 
if(uemail==null && aemail!=null){%>
	<!-- 	Admin -->
	<div class="site-wrap">
		<div class="site-navbar bg-white py-2">
			<div class="search-wrap">
				<div class="container">
					<a href="#" class="search-close js-search-close"><span
						class="icon-close2"></span></a>
					<form action="#" method="post">
						<input type="text" class="form-control"
							placeholder="Search keyword and hit enter...">
					</form>
				</div>
			</div>

			<div class="container">
				<div class="d-flex align-items-center justify-content-between">
					<div class="logo">
						<div class="site-logo">
							<a href="index.jsp" class="js-logo-clone">BookMyBus</a>
						</div>
					</div>
					<div class="main-nav d-none d-lg-block">
						<nav class="site-navigation text-right text-md-center"
							role="navigation">
							<ul class="site-menu js-clone-nav d-none d-lg-block">
								<li><a href="index.jsp">Home</a></li>					
								<li><a href="BusControl?Action=list">Bus List</a></li>
								<li><a href="AddBus.jsp">Bus Add</a></li>
								<li><a href="Customer?Action=Custlist">Customer List</a></li>
								<li><a href="Contact.jsp">Contact</a></li>
								<li><a href="utility">List of FeedBack</a></li>
							</ul>
						</nav>
					</div>
					<div class="icons">
								<a href="Login?action=logout"><IMG SRC="images/logout.png" ALT="some text" WIDTH=21 HEIGHT=20></a>
						
						</a> <a href=""
							class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
							class="icon-menu"></span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%}else if(aemail==null && uemail!=null){ %>
	<!-- 	Customer -->
	<div class="site-wrap">
		<div class="site-navbar bg-white py-2">
			<div class="search-wrap">
				<div class="container">
					<a href="#" class="search-close js-search-close"><span
						class="icon-close2"></span></a>
					<form action="#" method="post">
						<input type="text" class="form-control"
							placeholder="Search keyword and hit enter...">
					</form>
				</div>
			</div>

			<div class="container">
				<div class="d-flex align-items-center justify-content-between">
					<div class="logo">
						<div class="site-logo">
							<a href="index.jsp" class="js-logo-clone">BookMyBus</a>
						</div>
					</div>
					<div class="main-nav d-none d-lg-block">
						<nav class="site-navigation text-right text-md-center"
							role="navigation">
							<ul class="site-menu js-clone-nav d-none d-lg-block">
								<li><a href="index.jsp">Home</a></li>
								<li class="has-children active"><a href="index.jsp">Bus</a>
									<ul class="dropdown">
										<li><a href="BusControl?Action=list">List of All Bus</a></li>
										<li class="has-children"><a href="#">Type of Bus</a>
											<ul class="dropdown">
												<li><a href="BusControl?Action=list&type=AC">AC</a></li>
												<li><a href="BusControl?Action=list&type=NonAC">Non AC</a></li>

											</ul></li>
									</ul>
								</li>
								<li><a href="Contact.jsp">Contact</a></li>
								<li class="has-children active"><a href="#">Setting</a>
									<ul class="dropdown">
										<li><a href="ChangePassword.jsp">Change Password</a></li>
										<li><a href="Login?action=logout">Logout</a></li>
									</ul>
								</li>
							</ul>
							
						</nav>
					</div>
					<div class="icons">
						
							<a href="Login?action=logout"><IMG SRC="images/logout.png" ALT="some text" WIDTH=21 HEIGHT=20></a>
						
						
						
						
						<a href="CartController?Action=cartItem" class="icons-btn d-inline-block bag"> <span
							class="icon-shopping-bag"></span> <span class="number"><%=itemNumber %></span>
						</a> <a href="#"
							class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
							class="icon-menu"></span></a>
					</div>
				</div>
			</div>
		</div>
	</div>







	<%}else{ %>
	<div class="site-wrap">
		<div class="site-navbar bg-white py-2">
			<div class="search-wrap">
				<div class="container">
					<a href="#" class="search-close js-search-close"><span
						class="icon-close2"></span></a>
					<form action="#" method="post">
						<input type="text" class="form-control"
							placeholder="Search keyword and hit enter...">
					</form>
				</div>
			</div>

			<div class="container">
				<div class="d-flex align-items-center justify-content-between">
					<div class="logo">
						<div class="site-logo">
							<a href="index.jsp" class="js-logo-clone">BookMyBus</a>
						</div>
					</div>
					<div class="main-nav d-none d-lg-block">
						<nav class="site-navigation text-right text-md-center"
							role="navigation">
							<ul class="site-menu js-clone-nav d-none d-lg-block">
								<li><a href="index.jsp">Home</a></li>
								<li><a href="Login.jsp">Login</a></li>
								<li class="has-children active"><a href="index.jsp">Bus</a>
									<ul class="dropdown">
										<li><a href="BusControl?Action=list">List of Bus</a></li>
										<li class="has-children"><a href="Login.jsp">Booking</a>
											<ul class="dropdown">
												<li><a href="Login.jsp">AC</a></li>
												<li><a href="Login.jsp">Non AC</a></li>
												
											</ul></li>
									</ul></li>
								<li><a href="Contact.jsp">Contact</a></li>
							</ul>
						</nav>
					</div>
					<div class="icons">
						
						</a> <a href="#"
							class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
							class="icon-menu"></span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%} %>


	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>

</body>
</html>