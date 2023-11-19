
<%
	if(session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User View Page</title>
<link rel="stylesheet" href="CSS/userView.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="index2.jsp">HOME</a>
	</nav>
	<h1>USER ACCOUNT</h1>
	<div class="logo"><img src="image/pro.jpg"></div>
	<table border="1">
		<c:forEach var="use" items="${userDetails}">

			<c:set var="id" value="${use.id}" />
			<c:set var="name" value="${use.name}" />
			<c:set var="username" value="${use.username}" />
			<c:set var="email" value="${use.email}" />
			<c:set var="phone" value="${use.phone}" />
			<c:set var="nic" value="${use.nic}" />
			<c:set var="address" value="${use.address}" />
			<c:set var="password" value="${use.password}" />

			<tr>
				<td>User ID</td>
				<td>${use.id}</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td>${use.name}</td>
			</tr>
			<tr>
				<td>User User Name</td>
				<td>${use.username}</td>
			</tr>
			<tr>
				<td>User E-mail</td>
				<td>${use.email}</td>
			</tr>
			<tr>
				<td>User phone</td>
				<td>${use.phone}</td>
			</tr>
			<tr>
				<td>User Nic</td>
				<td>${use.nic}</td>
			</tr>
			<tr>
				<td>User Address</td>
				<td>${use.address}</td>
			</tr>
			<tr>
				<td>User Password</td>
				<td>${use.password}</td>
			</tr>

		</c:forEach>
	</table>

	<c:url value="updateUser.jsp" var="userupdate">
		<c:param name="id" value="${id}"></c:param>
		<c:param name="name" value="${name}"></c:param>
		<c:param name="username" value="${username}"></c:param>
		<c:param name="email" value="${email}"></c:param>
		<c:param name="phone" value="${phone}"></c:param>
		<c:param name="nic" value="${nic}"></c:param>
		<c:param name="address" value="${address}"></c:param>
		<c:param name="password" value="${password}"></c:param>
	</c:url>

	<a href="${userupdate}"> <input type="button" name="update"
		value="UPDATE MY DATA" class = "col-md-12">
	</a>

	<c:url value="deleteUser.jsp" var="userdelete">
		<c:param name="id" value="${id}"></c:param>
		<c:param name="name" value="${name}"></c:param>
		<c:param name="username" value="${username}"></c:param>
		<c:param name="email" value="${email}"></c:param>
		<c:param name="phone" value="${phone}"></c:param>
		<c:param name="nic" value="${nic}"></c:param>
		<c:param name="address" value="${address}"></c:param>
		<c:param name="password" value="${password}"></c:param>
	</c:url>

	<!--  <a href="${userdelete}"> <input type="button" name="delete"
		value="DELETE MY ACCOUNT">
	</a>-->

	<!--  <a href="#"><%=session.getAttribute("username") %></a>
	<a href="index2.jsp">HOME</a> -->
</body>
</html>