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
<title>PACKAGE VIEW</title>
<%@include file="bootstrap.jsp"%>
</head>
<body style="background-color: #363949">
	<div class="container-flued">
		<h1 class="text-center text-danger mt-5 mb-5">SELECT PACKAGES</h1>
	</div>

	<div class="container">
		<div class="row">
			<%
				PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection()); // Creating an instance of PackageInterfaceImplement
				List<PackageDetails> list = pi.displayPackages();// Fetching the list of packages
				for(PackageDetails p : list) {// Iterating through the list of packages
					%>
					<div class="col-md-3 mb-5">
					<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="packageImage/<%= p.getImage() %>" style="width: 180px; height: 200px;">
						<p><%=p.getPackageName() %></p>
						<div class="row text-center">
						<a href="#" class="btn btn-danger btn-sm ml-3">ADD</a>
						<a href="userViewPackage.jsp?pid=<%= p.getPackageID() %>" class="btn btn-success btn-sm ml-4">VIEW</a>
						<a href="#" class="btn btn-danger btn-sm ml-4"><i class="fas fa-rupee-sign"></i> <%= p.getPackagePrice() %></a>
						</div>
					</div>
					</div>
					</div>
					<% 
				}
			%>
		</div>
	</div>

</body>
</html>