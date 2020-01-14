<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="STOCKOVERFLOWPackage.*, java.util.List"%>
<%@ page errorPage="error_StockOverflow.jsp"%>




<%
String notifications_stocks = request.getParameter("stocks");
String notifications_blacklist = request.getParameter("blacklist");
String notifications_GoodOrders = request.getParameter("GoodOrders");
String notifications_Orders = request.getParameter("Orders");

int count = 0;
%>


<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-theme.min.css">

	<!-- Custom styles for this template -->
	<link href="<%=request.getContextPath() %>/css/theme_8XXXXXX.css" rel="stylesheet">	
	<link rel="icon" href="img/erp.png">		
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
	<meta name="description" content="Stock Overflow: Dashboard page">
	
	<title>Stock Overflow: Dashboard page</title>
</head>

<body>
		
		<div class="jumbotron">
		<h2><a class="btn btn-info btn-xl text-uppercase js-scroll-trigger col-md-12" href="index.html">Go back to home page</a></h2>
		</div>
		

		<% if (notifications_stocks != null ){
			count++;
			Stock stservice = new Stock();

List<Stock> stocks = stservice.getStocks();
		%>

	


	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: STOCKS</h1>
		</div>

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total STOCKS:	<span class="text-info"><%=stocks.size() %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>id</th>
					<th>name</th>
					<th>description</th>
					<th>volume</th>
					<th>minQuantity</th>
					<th>stock</th>
					<th>price</th>
					
				</tr>
				<%
	int counter = 0;
	for(Stock stockpro: stocks) { %>

				<tr>
					<td><%=++counter %></td>
					<td><%=stockpro.getId() %></td>
					<td><%=stockpro.getName() %></td>
					<td><%=stockpro.getDescription() %></td>
					<td><%=stockpro.getVolume() %></td>
					<td><%=stockpro.getMinQuantity() %></td>
					<td><%=stockpro.getStock() %></td>
					<td><%=stockpro.getPrice() %></td>
					
					
				</tr>
<% 	} 

	if(stocks.size() == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No stocks found.</b>
					</td>
				</tr>
		
<%	} %>
	

			</table>
		</div>
	</div>
<% } %>
	<!-- /container -->
<% if (notifications_blacklist != null ){
	count++;
	Order stservicea = new Order();

List<Order> BlackList = stservicea.getBlackList();
		%>	
<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: BlackList</h1>
		</div>

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total ORDERS:	<span class="text-info"><%=BlackList.size() %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>idorder</th>
					 <th>idcustomer</th>
					 <th>namecustomer</th>
					 <th>date_of_order</th>
					 <th>idproduct1</th>
					 <th>nameproduct1</th>
					 <th>quantity1</th>
					 <th>price1</th>
					<th>idproduct2</th>
					 <th>nameproduct2</th>
					 <th>quantity2</th>
					 <th>price2</th>
					 <th>idproduct3</th>
					 <th>nameproduct3</th>
					 <th>quantity3</th>
					 <th>price3</th>
					 <th>idproduct4</th>
					 <th>nameproduct4</th>
					<th>quantity4</th>
					 <th>price4</th>
					<th>idproduct5</th>
					<th>nameproduct5</th>
					 <th>quantity5</th>
					 <th>price5</th>
				</tr>
				<%
	int counter = 0;
	for(Order orderpro: BlackList) { %>

				<tr>
					<td><%=++counter %></td>
					<td><%=orderpro.getIdorder() %></td>
					<td><%=orderpro.getIdcustomer() %></td>
					<td><%=orderpro.getNamecustomer() %></td>
					<td><%=orderpro.getDate_of_order() %></td>
					<td><%=orderpro.getIdproduct1() %></td>
					<td><%=orderpro.getNameproduct1() %></td>
					<td><%=orderpro.getQuantity1() %></td>
					<td><%=orderpro.getPrice1() %></td>
					<td><%=orderpro.getIdproduct2() %></td>
					<td><%=orderpro.getNameproduct2() %></td>
					<td><%=orderpro.getQuantity2() %></td>
					<td><%=orderpro.getPrice2() %></td>
					<td><%=orderpro.getIdproduct3() %></td>
					<td><%=orderpro.getNameproduct3() %></td>
					<td><%=orderpro.getQuantity3() %></td>
					<td><%=orderpro.getPrice3() %></td>
					<td><%=orderpro.getIdproduct4() %></td>
					<td><%=orderpro.getNameproduct4() %></td>
					<td><%=orderpro.getQuantity4() %></td>
					<td><%=orderpro.getPrice4() %></td>
					<td><%=orderpro.getIdproduct5() %></td>
					<td><%=orderpro.getNameproduct5() %></td>
					<td><%=orderpro.getQuantity5() %></td>
					<td><%=orderpro.getPrice5() %></td>			
				</tr>
<% 	} 

	if(BlackList.size() == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No BlackList orders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
<%	} %>
<!-- /container -->


<% if (notifications_GoodOrders != null ){
	count++;
	Order stserviceb = new Order();

List<Order> GoodOrders = stserviceb.getGoodOrders();
		%>	
<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: GOOD_ORDERS</h1>
		</div>

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total ORDERS:	<span class="text-info"><%=GoodOrders.size() %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>idorder</th>
					 <th>idcustomer</th>
					 <th>namecustomer</th>
					 <th>date_of_order</th>
					 <th>idproduct1</th>
					 <th>nameproduct1</th>
					 <th>quantity1</th>
					 <th>price1</th>
					<th>idproduct2</th>
					 <th>nameproduct2</th>
					 <th>quantity2</th>
					 <th>price2</th>
					 <th>idproduct3</th>
					 <th>nameproduct3</th>
					 <th>quantity3</th>
					 <th>price3</th>
					 <th>idproduct4</th>
					 <th>nameproduct4</th>
					<th>quantity4</th>
					 <th>price4</th>
					<th>idproduct5</th>
					<th>nameproduct5</th>
					 <th>quantity5</th>
					 <th>price5</th>
				</tr>
				<%
	int counter = 0;
	for(Order orderpro: GoodOrders) { %>

				<tr>
					<td><%=++counter %></td>
					<td><%=orderpro.getIdorder() %></td>
					<td><%=orderpro.getIdcustomer() %></td>
					<td><%=orderpro.getNamecustomer() %></td>
					<td><%=orderpro.getDate_of_order() %></td>
					<td><%=orderpro.getIdproduct1() %></td>
					<td><%=orderpro.getNameproduct1() %></td>
					<td><%=orderpro.getQuantity1() %></td>
					<td><%=orderpro.getPrice1() %></td>
					<td><%=orderpro.getIdproduct2() %></td>
					<td><%=orderpro.getNameproduct2() %></td>
					<td><%=orderpro.getQuantity2() %></td>
					<td><%=orderpro.getPrice2() %></td>
					<td><%=orderpro.getIdproduct3() %></td>
					<td><%=orderpro.getNameproduct3() %></td>
					<td><%=orderpro.getQuantity3() %></td>
					<td><%=orderpro.getPrice3() %></td>
					<td><%=orderpro.getIdproduct4() %></td>
					<td><%=orderpro.getNameproduct4() %></td>
					<td><%=orderpro.getQuantity4() %></td>
					<td><%=orderpro.getPrice4() %></td>
					<td><%=orderpro.getIdproduct5() %></td>
					<td><%=orderpro.getNameproduct5() %></td>
					<td><%=orderpro.getQuantity5() %></td>
					<td><%=orderpro.getPrice5() %></td>			
				</tr>
<% 	} 

	if(GoodOrders.size() == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No orders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
<%	} %>
	<!-- /container -->
	<% if (notifications_Orders != null ){
		count++;
		Order stservicec = new Order();

List<Order> orders = stservicec.getOrders();
		%>	
	
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: ORDERS</h1>
		</div>

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total ORDERS:	<span class="text-info"><%=orders.size() %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>idorder</th>
					 <th>idcustomer</th>
					 <th>namecustomer</th>
					 <th>date_of_order</th>
					 <th>idproduct1</th>
					 <th>nameproduct1</th>
					 <th>quantity1</th>
					 <th>price1</th>
					<th>idproduct2</th>
					 <th>nameproduct2</th>
					 <th>quantity2</th>
					 <th>price2</th>
					 <th>idproduct3</th>
					 <th>nameproduct3</th>
					 <th>quantity3</th>
					 <th>price3</th>
					 <th>idproduct4</th>
					 <th>nameproduct4</th>
					<th>quantity4</th>
					 <th>price4</th>
					<th>idproduct5</th>
					<th>nameproduct5</th>
					 <th>quantity5</th>
					 <th>price5</th>
				</tr>
				<%
	int counter = 0;
	for(Order orderpro: orders) { %>

				<tr>
					<td><%=++counter %></td>
					<td><%=orderpro.getIdorder() %></td>
					<td><%=orderpro.getIdcustomer() %></td>
					<td><%=orderpro.getNamecustomer() %></td>
					<td><%=orderpro.getDate_of_order() %></td>
					<td><%=orderpro.getIdproduct1() %></td>
					<td><%=orderpro.getNameproduct1() %></td>
					<td><%=orderpro.getQuantity1() %></td>
					<td><%=orderpro.getPrice1() %></td>
					<td><%=orderpro.getIdproduct2() %></td>
					<td><%=orderpro.getNameproduct2() %></td>
					<td><%=orderpro.getQuantity2() %></td>
					<td><%=orderpro.getPrice2() %></td>
					<td><%=orderpro.getIdproduct3() %></td>
					<td><%=orderpro.getNameproduct3() %></td>
					<td><%=orderpro.getQuantity3() %></td>
					<td><%=orderpro.getPrice3() %></td>
					<td><%=orderpro.getIdproduct4() %></td>
					<td><%=orderpro.getNameproduct4() %></td>
					<td><%=orderpro.getQuantity4() %></td>
					<td><%=orderpro.getPrice4() %></td>
					<td><%=orderpro.getIdproduct5() %></td>
					<td><%=orderpro.getNameproduct5() %></td>
					<td><%=orderpro.getQuantity5() %></td>
					<td><%=orderpro.getPrice5() %></td>			
				</tr>
<% 	} 

	if(orders.size() == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No orders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
<%	} %>
	<!-- /container -->

	
	<% if (count == 0 ){
		%>
		<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: Δεν επέλεξες κάποια υπηρεσία. Επέλεξε κάποια για να δείς αποτελέσματα.</h1>
		</div>
		</div>
<%	} %>	
<!-- footer -->
<footer class="navbar-inverse">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<p class="text-center">&copy; Copyright 2019 - Stock Overflow team</p>
			</div>
		</div>
	</div>
</footer>
<!-- End footer -->	

	
	
	<!-- 
		Custom js for only this page.
	    Initialize Popover & tooltip, 
	    see: https://getbootstrap.com/docs/3.4/javascript/#popovers
	    and https://getbootstrap.com/docs/3.4/javascript/#tooltips	    
	-->
	<script>
		$( document ).ready(function() {
			$('[data-toggle="popover"]').popover();			
		});		
	</script>

</body>
</html>