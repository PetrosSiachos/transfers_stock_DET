<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="STOCKOVERFLOWPackage.*, java.util.List"%>
<%@ page errorPage="error_StockOverflow.jsp"%>




<%
String notifications_Averages = request.getParameter("Averages");
String notifications_General = request.getParameter("General");
String notifications_info_cust= request.getParameter("info_cust");
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
		

<% if (notifications_General != null || notifications_Averages != null ){%>
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: STATISTICS </h1>
		</div>
			</div>
<%	} %>			

	
	<% if (notifications_Averages != null ){
			count++;
			%>
			<h3>
				Average Creditworthiness: <div class="progress">
  <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar"
  aria-valuenow="<%=Statistics.AverageCreditworthiness() %>%" aria-valuemin="0" aria-valuemax="100" style="width:<%=Statistics.AverageCreditworthiness() %>%">
    <%=Statistics.AverageCreditworthiness() %>%
  </div>
</div></h3>

<h3>
				AverageYears_of_cooperation of Customers : <div class="progress">
  <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar"
  aria-valuenow="<%=Statistics.AverageYears_of_cooperation() %>" aria-valuemin="0" aria-valuemax="100" style="width:<%=Statistics.AverageYears_of_cooperation() %>%">
    <%=Statistics.AverageYears_of_cooperation() %>
  </div>
</div></h3>	
<h3>
				AveragePercent_of_stock of Customers : <div class="progress">
  <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
  aria-valuenow="<%=Statistics.AveragePercent_of_stock() %>" aria-valuemin="0" aria-valuemax="100" style="width:<%=Statistics.AveragePercent_of_stock() %>%">
    <%=Statistics.AveragePercent_of_stock() %>%
  </div>
</div></h3>


<%	} %>	

<% if (notifications_General != null ){
			count++;
			%>
<h1>
				Healthy Doing Business <span class="glyphicon glyphicon-heart"></span>: <h3>if 60% of customers have creditworthiness above 60 then we are ok/else not :</h3> <h1><span class="text-warning"> <%=Statistics.HealthyDoingBusiness() %> </span></h1></h1>




<h3>	The  idcustomer with most Orders <span class="glyphicon glyphicon-user"></span> <span class="glyphicon glyphicon-star"></span>:	<span class="text-success"><%=Statistics.popcustomer() %></span></h3>

			
				
			<h3>	Highest quantity of all products <span class="glyphicon glyphicon-triangle-top"></span>:	<span class="text-info"><%=Statistics.Higheststock() %></span></h3>

			<h3>
				
				Lowest quantity of all products <span class="glyphicon glyphicon-triangle-bottom"></span>:	<span class="text-danger"><%=Statistics.Loweststock() %></span></h3>

			
			<h3>
				
				Minimum price of all products <span class="glyphicon glyphicon-triangle-bottom"></span> :	<span class="text-danger"><%=Statistics.minprice() %></span></h3>

			
			<h3>
				
				Maximum price of all products <span class="glyphicon glyphicon-triangle-top"></span>:	<span class="text-info"><%=Statistics.maxprice() %></span></h3>

<h3>
				
				Percentage of good orders <span class="glyphicon glyphicon-ok"></span>:	<span class="text-info"><%=Statistics.rateofgoodorders() %></span></h3>
				
				
			<h3>
				
				Percentage of failed orders <span class="glyphicon glyphicon-remove"></span>:	<span class="text-info"><%=Statistics.rateofblackorders() %></span></h3>


<%	} %>	

<% if (notifications_info_cust != null ){
			count++;
String[] a = Statistics.CustomerMinYears_of_cooperation();
int counter2=0;
String[] b = Statistics.CustomerLessValuable();
int counter3=0;
String[] c = Statistics.CustomerMaxCreaditworthiness();
int counter4=0;
String[] d = Statistics.CustomerMaxOrders();
int counter5=0;
String[] e = Statistics.CustomerMostValuable();
int counter6=0;
int[] f = Statistics.CustomerSumOrders();
String[] g = Statistics.CustomerMinOrders();
String[] i = Statistics.CustomerMaxYears_of_cooperation();
String[] j = Statistics.CustomerMinPercent_of_stock();
int counter7=0;
String[] k = Statistics.CustomerMaxPercent_of_stock();
int counter8=0;
		%>
		
		<% 		
    for(int w = 0; w < a.length ; w++) {			
	if(a[w] != null) {
	counter2++; }
	}
%>		
	

	

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMinYears_of_cooperation

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= counter2 %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter11 = 0;
	for(int w = 0; w < counter2 ; w++) { %>


				<tr>
					<td><%=++counter11 %></td>
					<% 					
	if(a[w] != null) {
%>		
					<td><%= a[w] %></td>
<%	} %>
										
					
				</tr>
<% 	} 
				
	if(counter2 == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	
	<% 		
    for(int wb = 0; wb < b.length ; wb++) {			
	if(b[wb] != null) {
	counter3++; }
	}
%>	

	

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerLessValuable

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= counter3 %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter12 = 0;
	for(int wb = 0; wb < counter3 ; wb++) { %>


				<tr>
					<td><%=++counter12 %></td>
					<td><%= b[wb] %></td>

										
					
				</tr>
<% 	} 
				
	if(counter3 == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>Not found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	
	
	<% 		
    for(int wc = 0; wc < c.length ; wc++) {			
	if(c[wc] != null) {
	counter4++; }
	}
%>	

	

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMaxCreaditworthiness

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= counter4 %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter13 = 0;
	for(int wc = 0; wc < counter4 ; wc++) { %>


				<tr>
					<td><%=++counter13 %></td>
					<td><%= c[wc] %></td>

										
					
				</tr>
<% 	} 
				
	if(counter4 == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	<% 		
    for(int wd = 0; wd < d.length ; wd++) {			
	if(d[wd] != null) {
	counter5++; }
	}
%>	
	

	

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMaxOrders

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= counter5 %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter14 = 0;
	for(int wd = 0; wd < counter5 ; wd++) { %>


				<tr>
					<td><%=++counter14 %></td>
					<td><%= d[wd] %></td>

										
					
				</tr>
<% 	} 
				
	if(counter5 == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	<% 		
    for(int we = 0; we < e.length ; we++) {			
	if(e[we] != null) {
	counter6++; }
	}
%>	
	

	

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMostValuable

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= counter6 %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter15 = 0;
	for(int we = 0; we< counter6 ; we++) { %>


				<tr>
					<td><%=++counter15 %></td>
					<td><%= e[we] %></td>

										
					
				</tr>
<% 	} 
				
	if(counter6 == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	
		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerSumOrders

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= f.length %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>IdCustomer</th>
					<th>sumOrders</th>
					
						
				</tr>
				<%
								
				
	int counter16 = 0;
	for(int w = 0; w < f.length ; w++) { %>


				<tr>
					<td><%=++counter16 %></td>
					<td><%= f[w] %></td>

										
					
				</tr>
<% 	} 
				
	if(f.length == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	
		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMinOrders

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= g.length %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter17 = 0;
	for(int w = 0; w < g.length ; w++) { %>


				<tr>
					<td><%=++counter17 %></td>
					<td><%= g[w] %></td>

										
					
				</tr>
<% 	} 
				
	if(g.length == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMaxYears_of_cooperation

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= i.length %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter18 = 0;
	for(int w = 0; w < i.length ; w++) { %>


				<tr>
					<td><%=++counter18 %></td>
					<td><%= i[w] %></td>

										
					
				</tr>
<% 	} 
				
	if(i.length == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	<% 		
    for(int wj = 0; wj < j.length ; wj++) {			
	if(j[wj] != null) {
	counter7++; }
	}
%>	
	

	
		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMinPercent_of_stock

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= counter7 %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter19 = 0;
	for(int wj = 0; wj < counter7 ; wj++) { %>


				<tr>
					<td><%=++counter19 %></td>
					<td><%= j[wj] %></td>

										
					
				</tr>
<% 	} 
				
	if(counter7 == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
	<% 		
    for(int wk = 0; wk < k.length ; wk++) {			
	if(k[wk] != null) {
	counter8++; }
	}
%>	

	

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: CustomerMaxPercent_of_stock

		<!-- Page Title -->
		<div class="page-header">
			<h1>
				Total :	<span class="text-info"><%= counter8 %></span></h1>
		</div>

		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				<tr class="warning">
					<th>A/A</th>
					<th>Customer</th>
					
						
				</tr>
				<%
								
				
	int counter20 = 0;
	for(int wk = 0; wk < counter8 ; wk++) { %>


				<tr>
					<td><%=++counter20 %></td>
					<td><%= k[wk] %></td>

										
					
				</tr>
<% 	} 
				
	if(counter8 == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No sumorders found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
			
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