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
<title>EDIT Packages</title>
<%@include file="bootstrap.jsp"%>
</head>
<body style="background-color: #363949">
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center mb-5" style="color: #363949">EDIT
							PACKAGES</h4>

						<%
						int id = Integer.parseInt(request.getParameter("pid"));// Getting package ID from request parameter
						PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection());// Creating an instance of PackageInterfaceImplement
						PackageDetails p = pi.getPackageID(id);// Getting package details by ID
						%>
						<form action="../edit_Packages" method="post">
							<input type="hidden" name="id" value="<%=p.getPackageID()%>">
							<div class="form-group">
								<label>PACKAGE NAME</label> <input type="text"
									class="form-control" name="pname"
									value="<%=p.getPackageName()%>">
							</div>
							<div class="form-group">
								<label>VENUE</label> <input type="text" class="form-control"
									name="venue" value="<%=p.getVenue()%>">
							</div>
							<div class="form-group">
								<label>PACKAGE PRICE</label> <input type="number"
									class="form-control" name="packagePrice"
									value="<%=p.getPackagePrice()%>">
							</div>
							<div class="form-group">
								<label>FOOD ONE PERSON PRICE</label> <input type="number"
									class="form-control" name="onePersonFoodprice"
									value="<%=p.getFoodPerPersonPrice()%>">
							</div>
							<div class="form-group">
								<label>FOOD DESCRIPTION</label> <input type="text"
									class="form-control" name="foodDesc"
									value="<%=p.getFoodDescription()%>">
							</div>
							<div class="form-group">
								<label>DECORATION PACKAGES</label> <select class="form-control"
									name="decoPkgs">
									<%
									if ("pkg1".equals(p.getDecorationPackage())) {
									%>
									<option value="pkg1">PACKAGE 1</option>
									<option value="pkg2">PACKAGE 2</option>
									<option value="pkg3">PACKAGE 3</option>
									<option value="pkg4">PACKAGE 4</option>
									<option value="pkg5">PACKAGE 5</option>
									<%
									} else if("pkg2".equals(p.getDecorationPackage())) {
										%>
									<option value="pkg2">PACKAGE 2</option>
									<option value="pkg1">PACKAGE 1</option>
									<option value="pkg3">PACKAGE 3</option>
									<option value="pkg4">PACKAGE 4</option>
									<option value="pkg5">PACKAGE 5</option>
									<%
									} else if("pkg3".equals(p.getDecorationPackage())) {
										%>
									<option value="pkg3">PACKAGE 3</option>
									<option value="pkg1">PACKAGE 1</option>
									<option value="pkg2">PACKAGE 2</option>
									<option value="pkg4">PACKAGE 4</option>
									<option value="pkg5">PACKAGE 5</option>
									<%
									} else if("pkg4".equals(p.getDecorationPackage())) {
										%>
									<option value="pkg4">PACKAGE 4</option>
									<option value="pkg1">PACKAGE 1</option>
									<option value="pkg2">PACKAGE 2</option>
									<option value="pkg3">PACKAGE 3</option>
									<option value="pkg5">PACKAGE 5</option>
									<%
									} else {
										%>
									<option value="pkg5">PACKAGE 5</option>
									<option value="pkg1">PACKAGE 1</option>
									<option value="pkg2">PACKAGE 2</option>
									<option value="pkg3">PACKAGE 3</option>
									<option value="pkg4">PACKAGE 4</option>
									<%
									}
									%>

								</select>
							</div>
							<div class="form-group">
								<label>DECORATION DESCRIPTION</label> <input type="text"
									class="form-control" name="decoDesc"
									value="<%= p.getDecorationDescription() %>">
							</div>
							<div class="form-group">
								<label>ENTERTAINMENT ITEM</label> <input type="text"
									class="form-control" name="entertainment"
									value="<%= p.getEntertainment() %>">
							</div>
							<div class="form-group">
								<label>PHOTOGRAPHERS</label> <select class="form-control"
									name="photographer">
									<%
									if("DAVID".equals(p.getPhotographers())) {
										%>
									<option value="DAVID">DAVID</option>
									<option value="ALEXANDER">ALEXANDER</option>
									<option value="DANIEL">DANIEL</option>
									<option value="HENRY">HENRY</option>
									<option value="OLIVER">OLIVER</option>
									<option value="DAVE">DAVE</option>
									<%
									} else if("ALEXANDER".equals(p.getPhotographers())) {
										%>
									<option value="ALEXANDER">ALEXANDER</option>
									<option value="DAVID">DAVID</option>
									<option value="DANIEL">DANIEL</option>
									<option value="HENRY">HENRY</option>
									<option value="OLIVER">OLIVER</option>
									<option value="DAVE">DAVE</option>
									<%
									} else if("DANIEL".equals(p.getPhotographers())) {
										%>
									<option value="DANIEL">DANIEL</option>
									<option value="DAVID">DAVID</option>
									<option value="ALEXANDER">ALEXANDER</option>
									<option value="HENRY">HENRY</option>
									<option value="OLIVER">OLIVER</option>
									<option value="DAVE">DAVE</option>
									<%
									} else if("HENRY".equals(p.getPhotographers())) {
										%>
									<option value="HENRY">HENRY</option>
									<option value="DAVID">DAVID</option>
									<option value="ALEXANDER">ALEXANDER</option>
									<option value="DANIEL">DANIEL</option>
									<option value="OLIVER">OLIVER</option>
									<option value="DAVE">DAVE</option>
									<%
									} else if("OLIVER".equals(p.getPhotographers())) {
										%>
									<option value="OLIVER">OLIVER</option>
									<option value="DAVID">DAVID</option>
									<option value="ALEXANDER">ALEXANDER</option>
									<option value="DANIEL">DANIEL</option>
									<option value="HENRY">HENRY</option>
									<option value="DAVE">DAVE</option>
									<%
									} else {
										%>
									<option value="DAVE">DAVE</option>
									<option value="DAVID">DAVID</option>
									<option value="ALEXANDER">ALEXANDER</option>
									<option value="DANIEL">DANIEL</option>
									<option value="HENRY">HENRY</option>
									<option value="OLIVER">OLIVER</option>
									<%
									} 
									%>

								</select>
							</div>
							<div class="form-group">
								<label>STATUS</label> <select class="form-control" name="status">
									<%
									if("active".equals(p.getStatus())) {
										%>
									<option value="active">ACTIVE</option>
									<option value="inactive">INACTIVE</option>
									<% 
									} else {
										%>
									<option value="inactive">INACTIVE</option>
									<option value="active">ACTIVE</option>
									<% 
									}
									%>

								</select>
							</div>
							<button type="submit" class="btn btn-primary mt-3 p-2">EDIT
								PACKAGE</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>