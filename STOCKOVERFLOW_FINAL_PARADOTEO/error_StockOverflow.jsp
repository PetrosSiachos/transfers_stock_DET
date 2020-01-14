<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>


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
			
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
		<meta name="description" content="Error page">
		
		<title>Stock Overflow: Error Page</title>
		
	</head>

	<body>		

		<div class="container">

			<!-- Page Title -->
			<div class="page-header">
				<h1>Error</h1>				
			</div>
			
<% if(exception != null) {  %>			
			<div class="alert alert-danger" role="alert">
				<p>
					<b>Message: </b> Προσπάθησε ξανά σε λίγο. Κάτι δε πήγε καλά με την εκτέλεση τών sql ερωτημάτων στη βάση δεδομένων(MySQL)... <a href="index.html"> Go to home page</a>
				</p>
				
			</div>
			<div class="alert alert-danger" role="alert">
				<p>
					<b>Message: </b> com.mysql.jdbc.CommunicationsException: The driver was unable to create a connection due to an inability to establish the client portion of a socket. This is usually caused by a limit on the number of sockets imposed by the operating system. This limit is usually configurable. <a href="https://forums.mysql.com/read.php?39,678888,678888">MySQL Forums </a>
				</p>
				
			</div>
<% } %>		
	
		</div>
		<!-- /container -->
		
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

	
	</body>
</html>