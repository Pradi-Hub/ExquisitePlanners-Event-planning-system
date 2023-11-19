<%@page import="com.admin.PackageInterfaceImplement"%>
<%@page import="java.util.List"%>
<%@page import="com.user.DBConnect"%>
<%@page import="com.admin.PackageDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ALL Packages</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<h3 class="text-center p-2">HELLO ADMIN</h3>

	<c:if test="${not empty succMsg } ">
		<h5 class="text-center text-success">${succMsg}</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg } ">
		<h5 class="text-center text-danger">${failedMsg}</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>

	<table class="table table-striped">
		<thead class="thead-dark text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">IMAGE</th>
				<th scope="col">PACKAGE NAME</th>
				<th scope="col">VENUE</th>
				<th scope="col">PACKAGE PRICE</th>
				<th scope="col">FOOD PER PERSON PRICE</th>
				<th scope="col">FOOD DESCRIPTION</th>
				<th scope="col">DECORATION PACKAGE</th>
				<th scope="col">DECORATION DESCRIPTION</th>
				<th scope="col">ENTERTAINMENT</th>
				<th scope="col">PHOTOGRAPHER</th>
				<th scope="col">STATUS</th>
				<th scope="col">ACTION</th>
			</tr>
		</thead>
		<tbody>

			<% 
			PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection());// Creating an instance of PackageInterfaceImplement
			List<PackageDetails> list = pi.getPackages();// Retrieving the list of packages
			for(PackageDetails p : list) {// Iterating through the list of packages
				%>
			<tr>
				<td><%= p.getPackageID() %></td>
				<td><img src="../packageImage/<%= p.getImage() %>"
					style="width: 50px; height: 50px;"></td>
				<td><%= p.getPackageName() %></td>
				<td><%= p.getVenue() %></td>
				<td><%= p.getPackagePrice() %></td>
				<td><%= p.getFoodPerPersonPrice() %></td>
				<td><%= p.getFoodDescription() %></td>
				<td><%= p.getDecorationPackage() %></td>
				<td><%= p.getDecorationDescription() %></td>
				<td><%= p.getEntertainment() %></td>
				<td><%= p.getPhotographers() %></td>
				<td><%= p.getStatus() %></td>
				<td><a href="editPackage.jsp?pid=<%= p.getPackageID() %>"
					class="btn btn-sm btn-primary mb-2"><i class="fas fa-edit"></i>EDIT</a>
					<a href="../delete?pid=<%= p.getPackageID() %>"
					class="btn btn-sm btn-danger" onclick= "return confirmDelete();"><i class="fas fa-trash-alt"></i>
						Delete</a></td>
			</tr>
			<% 
			}
			%>
		</tbody>
	</table>

	<script type="text/javascript">
          function confirmDelete() {
            var text = confirm("Are you sure you want to delete your Package ?");// Display delete confirmation prompt
            if(!text) {
                return false;
            }
        }
    </script>
</body>
</html>