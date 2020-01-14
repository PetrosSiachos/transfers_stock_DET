<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="STOCKOVERFLOWPackage.*, java.util.List"%>
<%@ page errorPage="error_StockOverflow.jsp"%>





<%

String notifications_routes = request.getParameter("routes");
String notifications_routes_sec = request.getParameter("routes_sec");

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

<% if (notifications_routes_sec != null ){
	count++;
	VolumeSet k1 = new VolumeSet();
		int[][] a1 = k1.sortOrders();
	String[] a4 = VolumeSet.printRoutes();
	


		%>
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: ROUTES </h1>
		</div>

		
		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				
				<%
	
	for(int wb = 0; wb < a4.length ; wb++) {
if (a4[wb].equals("Route0:") == false) {
 %>
	


				<tr>

					<td><%= a4[wb] %></td>
					

					
				</tr>
<% 	}
}
	if(a4.length == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No routes found.</b>
					</td>
				</tr>
		
<%	} %>

			</table>
		</div>
	</div>
	<!-- /container -->
<%	} %>	
	<% if (notifications_routes != null ){
		count++;
		 String[] a3 = OptimumRoute.implementTheVRP();
		%>
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>STOCK OVERFLOW: WAY </h1>
		</div>

		
		<div class="table-responsive">

			<table class="table table-condensed table-hover table-bordered">
				
				<%
	
	for(int w = 0; w < a3.length ; w++) { 
if (a3[w].equals("Route0: 1 -> 1") == false) {

%>


				<tr>
					
					<td><%= a3[w] %></td>
					
					


					
				</tr>
<% 	}
}
	if(a3.length == 0) {
%>		
				<tr>
					<td class="text-warning text-center" colspan="8">
						<b>No routes found.</b>
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