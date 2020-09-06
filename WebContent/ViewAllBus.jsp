
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Bus"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ShopMax &mdash; Colorlib e-Commerce Template</title>
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
table, th, td { 
                border: 2px solid black; 
                text-align:center; 
            } 
            th, td { 
                padding: 20px; 
                background-color:none; 
            } 
              </style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<form action="BusControl">
		<input type="hidden" name="Action" value="sdlist"> <input
			type="text" style="position: relative; padding-left: 50px;"
			name="Source" placeholder="Source"> <input type="text"
			style="position: relative; padding-left: 50px;" name="Destination"
			placeholder="Destination"> <input type="submit"
			style="padding: 10px 20px; background-color: dodgerblue; border: 1px solid #ddd; color: white;"
			value="Apply Filter">
	</form>
	<div class="site-wrap">
		<div class="site-section">
			<div class="container">

				<div class="row mb-5">
					<div class="col-md-9 order-1">

						<div class="row align">
							<div class="col-md-12 mb-5">
								
								<div class="d-flex">
									<!-- Shop Menu -->
								</div>
							</div>
						</div>
						<%
							String aemail = (String) session.getAttribute("aemail");
							String uemail = (String) session.getAttribute("uemail");
							String gPath=(String) session.getAttribute("Path");
							if (aemail == null && uemail != null) {
						%>
						<%
							ArrayList<Bus> al = (ArrayList<Bus>) session.getAttribute("BusList");
								
								System.out.println(al.size());
								if (al.size() > 0) {
									System.out.println("in if block");
									for (int i = 0; i < al.size(); i++) {
										Bus b = al.get(i);
										String path = gPath + "\\" + b.getImage();
										System.out.println(path);
						%>
						<form action="CartController" method="get">
							<input type="hidden" name="Action" value="add">
							<div class="row mb-5">
								<div class="col-lg-6 col-md-6 item-entry mb-4">
									<a href="#" class="product-item md-height bg-gray d-block">
										<img src="<%=path%>" alt="Image" class="img-fluid">
									</a>
									<h2 class="item-title">
										<p>
											<b>Source :</b><%=b.getBsource()%><br> <b>Destination
											</b><%=b.getBdestination()%><br> <b>Time:</b><%=b.getTime()%></br>
											<b> Date:</b><%=b.getDay()%>
											<br> <b>Type :</b>
											<%=b.getType()%><br> <b>Available Seat</b>:
											<%=b.getBseat()%>
											<br> <b>Amount</b>:<%=b.getAmount() %>
										</p>
									</h2>
									<strong class="item-price"><code>
											 <input type="submit" value="Add to Booking Cart">
											  <input type="hidden" name="seat" value=<%=b.getBseat()%>>
										</code></strong> <input type="hidden" name="bid" value=<%=b.getBid()%>>

								</div>


							</div>
						</form>
						<%
							}
								} else {
						%>
						<h1>No Item Found</h1>
						<%
							}
							}
							else 	if (uemail == null &&  aemail!= null) { %>
						<table border="1">
							<thead >
								<tr>
									<td>ID</td>
									<td>SOURCE</td>
									<td>DESTINATION</td>
									<td>SEAT</td>
									<td>TIME</td>
									<td>LeavingDayForBus</td>
									<td>AMOUNT</td>
									<td>TYPE</td>
									<td colspan="3">Action</td>

								</tr>
								<%
								ArrayList<Bus> al = (ArrayList<Bus>) session.getAttribute("BusList");
								
								System.out.println(al.size());
								if (al.size() > 0) {
					
									for (int i = 0; i < al.size(); i++) {
										Bus b = al.get(i);
										String path = gPath + "\\" + b.getImage();
										System.out.println(path);
						%>

								<tr>
									<td><%=b.getBid() %></td>
									<td><%=b.getBsource() %></td>
									<td><%=b.getBdestination() %></td>
									<td><%=b.getBseat() %></td>
									<td><%=b.getTime() %></td>
									<td><%=b.getDay()%> &nbsp &nbsp &nbsp &nbsp </td>
									<td><%=b.getAmount() %></td>
									<td><%=b.getType() %></td>
									<td><a href="BusControl?Action=delete&bid=<%=b.getBid() %>">Delete</a></td>
									<td><a href="BusControl?Action=update&bid=<%=b.getBid() %>">Update</a></td>
									<td><a href="Customer?Action=BusCustomer&bid=<%=b.getBid() %>">List of customer who booked the Bus</a></td>
								</tr>
						
						<%
							}
								%></table><%
								
								
								}}else {
						%>
						<%
							ArrayList<Bus> al = (ArrayList<Bus>) session.getAttribute("BusList");
								
								if (al.size() > 0) {

									for (int i = 0; i < al.size(); i++) {
										Bus b = al.get(i);
										String path = gPath + "\\" + b.getImage();
										System.out.println(path);
						%>
						<form action="Login.jsp" method="get">
							<input type="hidden" name="Action" value="add">
							<div class="row mb-5">
								<div class="col-lg-6 col-md-6 item-entry mb-4">
									<a href="#" class="product-item md-height bg-gray d-block">
	<!-- edited -->				 	<img src="<%=path %>" alt="Image" class="img-fluid">
									</a>
									<h2 class="item-title">
										<p>
											<b>Source :</b><%=b.getBsource()%><br> <b>Destination
											</b><%=b.getBdestination()%><br> <b>Time:</b><%=b.getTime()%></br>
											<b> Date:</b><%=b.getDay()%>
											<br> <b>Type :</b>
											<%=b.getType()%><br> <b>Available Seat</b>:
											<%=b.getBseat()%>
											<br> <b>Amount</b>:<%=b.getAmount() %>
										</p>
									</h2>
									<strong class="item-price"><code>
											Price
											<%=b.getAmount()%>
											Rs <input type="submit" value="Add to Cart">
										</code></strong> <input type="hidden" name="bid" value=<%=b.getBid()%>>

								</div>


							</div>
						</form>
						<%
							}
								}else {
						%>
						<h1>No Item Found</h1>
						<%
							}
							}
						%>

					</div>
				</div>
			</div>
		</div>
	</div>

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
