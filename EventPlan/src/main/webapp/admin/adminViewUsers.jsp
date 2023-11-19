<%@page import="com.user.User"%>
<%@page import="com.admin.PackageInterfaceImplement"%>
<%@page import="java.util.List"%>
<%@page import="com.user.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER LIST</title>
<%@include file="bootstrap.jsp"%>
</head>
<body style="background-color: #AAAAAA">
	<div class="container-flued">
		<h1 class="text-center text-danger mt-5 mb-3">USER DETAILS</h1>
	</div>
	<table class="table table-striped text-white m-5" style="width: 94%">
		<thead class="thead-dark text-white">
			<tr>
				<th scope="col">USER ID</th>
				<th scope="col">FULL NAME</th>
				<th scope="col">USER NAME</th>
				<th scope="col">E-MAIL</th>
				<th scope="col">MOBILE NUMBER</th>
				<th scope="col">NIC NUMBER</th>
				<th scope="col">ADDRESS</th>
			</tr>
		</thead>
		
		<tbody class="text-white">
		<%
		PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection());// Creating an instance of PackageInterfaceImplement
		List<User> list = pi.getUsers(); // Retrieving the list of users from the database
		for(User u : list) { // Iterating through the list of users
			%>
			<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getName() %></td>
			<td><%= u.getUsername() %></td>
			<td><%= u.getEmail() %></td>
			<td><%= u.getPhone() %></td>
			<td><%= u.getNic() %></td>
			<td><%= u.getAddress() %></td>
			</tr>
			<% 
		}
		%>
		</tbody>
	</table>
</body>
</html>