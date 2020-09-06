<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pojo.Bus"%>
<html lang="en">
  <head>
    <title>ShopMax &mdash; Colorlib e-Commerce Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">


    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
    
  </head>
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
   <% ArrayList<Bus> al=(ArrayList<Bus>)session.getAttribute("Data");
  System.out.println(al.size());%>
  <div class="site-wrap">  
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Cart</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
      <form class="col-md-12"  action="CartController" >
        <div class="row mb-5">
            <div class="site-blocks-table">
              <%if(al.size()>0){  %>   
            	  <table class="table table-bordered">
                  <!-- <thead> -->                  <tr>
                      <th class="product-thumbnail">Source</th>
                      <th class="product-name">Destination</th>
                      <th class="product-price">Price</th>
                      <th class="product-quantity">Time&Date</th>
                      <th class="product-total">Sets</th>
                      <th class="product-remove">Remove</th>
                    </tr>
                 <!--  </thead> -->
                  <tbody>
             
           <% for(int i=0;i<al.size();i++){
            	Bus b=al.get(i); %>
            	
                  <tr>
                    <td class="product-thumbnail">
                      <b><%=b.getBsource() %></b>
                    </td>
                    <td class="product-name">
                      <h2 class="h5 text-black"><%=b.getBdestination() %></h2>
                    </td>
                    <td><%= b.getAmount() %></td>
                   
                    <td><%=b.getDay() %>/ <%=b.getTime()%></td>
                  
                     <td>
                      <div class="input-group mb-3" style="max-width: 120px;">
                        <div class="input-group-prepend">
                          <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
                        </div>
                        <% ArrayList<Integer> quan=(ArrayList<Integer>) session.getAttribute("Quantity");
                        if(quan!=null&&quan.size()>0){%>
                        <input type="number" min="1" class="form-control text-center" name="<%=b.getBid()%>" value="<%=quan.get(i) %>" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                        <%}else{ %>
                         <input type="text" class="form-control text-center" name="<%=b.getBid()%>" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                         <%} %>
                        <div class="input-group-append">
                          <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
                        </div>
                      </div>
                    </td>
                    <td><a href="CartController?Action=remove&bid=<%=b.getBid()%>" class="btn btn-primary height-auto btn-sm">X</a></td>
                  </tr>
			
                  <%}}else{ %>
                  <h1>Sorry No Item Added In Cart</h1>
                  <%} %>
                  	
                </tbody>
              </table>
            </div>
         
        </div>

        <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">
              <div class="col-md-6 mb-3 mb-md-0">
              <input type="hidden" name="Action" value="update"> 
                <input type="submit" class="btn btn-primary btn-sm btn-block" value="Update Cart" onclick="pop()">
              </div>
              
            </div>
         </form>
         
          </div>
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                
                <div class="row">
                  <div class="col-md-12">
                    <button class="btn btn-primary btn-lg btn-block" style="width: 200px; "><a href="OrderControll?Action=bill" style="color: white;"> Conform Booking </a></button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
<script type="text/javascript">
function pop()
{
alert("Cart has been Update")	
}</script>
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