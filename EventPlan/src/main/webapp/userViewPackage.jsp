<%@page import="com.admin.PackageInterfaceImplement"%>
<%@page import="java.util.List"%>
<%@page import="com.user.DBConnect"%>
<%@page import="com.admin.PackageDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User View Package</title>
<%@include file="bootstrap.jsp"%>
</head>
<body style="background-color: #363949">

	<%
	int id = Integer.parseInt(request.getParameter("pid"));// Getting package ID from request parameter
	PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection());// Creating an instance of PackageInterfaceImplement
	PackageDetails p = pi.getPackageID(id);// Getting package details by ID
	%>
	
	<div class="container-flued">
		<h1 class="text-center text-danger mt-5 mb-5">PACKAGES DETAILS</h1>
	</div>
	
	<div class="container p-3">
		<div class="row ">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img alt="" src="packageImage/<%= p.getImage() %>" style="height: 200px; width: 180px;"><br>
				<h4 class="mt-3">
					PACKAGE NAME: <span class="text-success"><%=p.getPackageName()%></span>
				</h4>
				<h4 class="mt-3">
					VENUE: <span class="text-success"><%=p.getVenue()%></span>
				</h4>
				<h4 class="mt-3">
					PACKAGE PRICE: <span class="text-success"><%=p.getPackagePrice()%></span>
				</h4>
				<h4 class="mt-3">
					FOOD ONE PERSON PRICE: <span class="text-success"><%=p.getFoodPerPersonPrice()%></span>
				</h4>
				<h4 class="mt-3">
					FOOD DETAILS: <span class="text-success"><%=p.getFoodDescription()%></span>
				</h4>
				<h4 class="mt-3">
					DECORATION PACKAGE: <span class="text-success"><%=p.getDecorationPackage() %></span>
				</h4>
				<h4 class="mt-3">
					DECORATION DETAILS: <span class="text-success"><%= p.getDecorationDescription() %></span>
				</h4>
				<h4 class="mt-3">
					ENTERTAINMENT: <span class="text-success"><%= p.getEntertainment() %></span>
				</h4>
				<h4 class="mt-3">
					PHOTOGRAPHER: <span class="text-success"><%=p.getPhotographers() %></span>
				</h4>
			</div>

			<div class="col-md-6 text-center p-5 border bg-white">
				<h2 class="mt-5" style="color: #363949"><%=p.getPackageName()%></h2>

				<div class="row mt-5 mb-5">
					<div class="col-md-4 text-danger text-center p-2 ">
						<i class="fas fa-money-bill-wave fa-2x"></i>
						<p>Cash On Delivery</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2 ">
						<i class="fas fa-undo-alt fa-2x"></i>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2 ">
						<i class="fas fa-truck-moving fa-2x"></i>
						<p>Free Shipping</p>
					</div>
					<div class="text-center p-3">
						<a href="#" class="btn btn-primary btn-sm ml-3 p-3">SELECT PACKAGE</a> <a
							href="#" class="btn btn-success btn-sm ml-4 p-3"><i
							class="fas fa-cart-plus"></i> ADD CART</a> <a href="#"
							class="btn btn-danger btn-sm ml-4 p-3"><i
							class="fas fa-rupee-sign"></i> <%=p.getPackagePrice()%></a>
							<a href="photographers.jsp" class="btn btn-primary btn-sm mt-5 ml-4 p-3">PHOTOGRAPHERS</a>
							<a href="decorationPackage.jsp" class="btn btn-danger btn-sm mt-5 ml-4 p-3">DECORATION</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>