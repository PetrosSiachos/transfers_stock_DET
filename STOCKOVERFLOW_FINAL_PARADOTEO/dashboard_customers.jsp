<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="STOCKOVERFLOWPackage.*, java.util.List"%>
<%@ page errorPage="error_StockOverflow.jsp"%>




<%

String notifications_customers = request.getParameter("customers");
String notifications_NeedProduct = request.getParameter("NeedProduct");

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

<% if (notifications_customers != null ){
	count++;
	Customer stserviced = new Customer();

List<Customer> customers = stserviced.getCustomers();
		%>
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CUSTOMERS</h1>
		</div>

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total CUSTOMERS:	<span class="text-info"><%=customers.size() %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>idcustomer</th>
					<th>namecustomer</th>
					<th>phone</th>
					<th>address</th>
					<th>years_of_cooperation</th>
					<th>percent_of_stock</th>
					<th>creaditworthiness</th>
					
				</tr>
				<%
	int counter = 0;
	for(Customer custpro: customers) { %>

				<tr>
					<td><%=++counter %></td>
					<td><%=custpro.getIdcustomer() %></td>
					<td><%=custpro.getNamecustomer() %></td>
					<td><%=custpro.getPhone() %></td>
					<td><%=custpro.getAddress() %></td>
					<td><%=custpro.getYears_of_cooperation() %></td>
					<td><%=custpro.getPercent_of_stock() %></td>
					<td><%=custpro.getCreditworthiness() %></td>
					
					
				</tr>
<% 	} 

	if(customers.size() == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No customers found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
<%	} %>
	<!-- /container -->
	
	<% if (notifications_NeedProduct != null ){
		count++;
		Order stservicee = new Order();

List<Stock> NeedProduct = stservicee.getNeedProduct(stservicee.getA());
		%>
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: NEED_PRODUCT</h1>
		</div>

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total PRODUCTS:	<span class="text-info"><%=NeedProduct.size() %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>id</th>
					 <th>name</th>
					 <th>need</th>
					 
				</tr>
				<%
	int counter = 0;
	for(Stock orderpro: NeedProduct) { %>

				<tr>
					<td><%=++counter %></td>
					<td><%=orderpro.getId() %></td>
					<td><%=orderpro.getName() %></td>
					<td><%=orderpro.getNeed() %></td>
							
				</tr>
<% 	} 

	if(NeedProduct.size() == 0) {
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