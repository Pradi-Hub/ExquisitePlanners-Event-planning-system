<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD Packages</title>
<%@include file="bootstrap.jsp"%>
</head>
<body style="background-color: #363949">
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center mb-5" style="color: #363949">ADD
							PACKAGES</h4>
						<!-- Check for successful message -->
						<c:if test="${not empty succMsg } ">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<!-- Check for failed message -->
						<c:if test="${not empty failedMsg } ">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
						<!-- Form for adding packages -->
						<form action="../add_Packages" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label>PACKAGE NAME</label> <input type="text"
									class="form-control" name="pname">
							</div>
							<div class="form-group">
								<label>VENUE</label> <input type="text" class="form-control"
									name="venue">
							</div>
							<div class="form-group">
								<label>PACKAGE PRICE</label> <input type="number"
									class="form-control" name="packagePrice">
							</div>
							<div class="form-group">
								<label>FOOD ONE PERSON PRICE</label> <input type="number"
									class="form-control" name="onePersonFoodprice">
							</div>
							<div class="form-group">
								<label>FOOD DESCRIPTION</label> <input type="text"
									class="form-control" name="foodDesc">
							</div>
							<div class="form-group">
								<label>DECORATION PACKAGES</label> <select class="form-control"
									name="decoPkgs">
									<option selected>-- SELECT PACKAGE --</option>
									<option value="pkg1">PACKAGE 1</option>
									<option value="pkg2">PACKAGE 2</option>
									<option value="pkg3">PACKAGE 3</option>
									<option value="pkg4">PACKAGE 4</option>
									<option value="pkg5">PACKAGE 5</option>
								</select>
							</div>
							<div class="form-group">
								<label>DECORATION DESCRIPTION</label> <input type="text"
									class="form-control" name="decoDesc">
							</div>
							<div class="form-group">
								<label>ENTERTAINMENT ITEM</label> <input type="text"
									class="form-control" name="entertainment">
							</div>
							<div class="form-group">
								<label>PHOTOGRAPHERS</label> <select class="form-control"
									name="photographer">
									<option selected>-- SELECT PHOTOGRAPHER --</option>
									<option value="DAVID">DAVID</option>
									<option value="ALEXANDER">ALEXANDER</option>
									<option value="DANIEL">DANIEL</option>
									<option value="HENRY">HENRY</option>
									<option value="OLIVER">OLIVER</option>
									<option value="DAVE">DAVE</option>
								</select>
							</div>
							<div class="form-group">
								<label>STATUS</label> <select class="form-control"
									name="status">
									<option selected>-- SELECT STATUS --</option>
									<option value="active">ACTIVE</option>
									<option value="inactive">INACTIVE</option>
								</select>
							</div>
							<div class="form-group">
								<label>UPLOAD IMAGE</label> <input type="file"
									class="form-control" name="pimg">
							</div>

							<button type="submit" class="btn btn-primary mt-3 p-2">ADD
								PACKAGE</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>