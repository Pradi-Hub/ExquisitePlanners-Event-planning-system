<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin DashBoard</title>
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="DamniduIT22602978/css/dasboardstyle.css">
</head>
<body>


	<!-- CONTENT -->
	<section id="content">
		

		<!-- MAIN -->
		<main>
			<div class="head-title">
				<div class="left">
					<h1>Dashboard</h1>
					
				</div>
				
			</div>

			<ul class="box-info">
				<li>
					<i class='bx bx-comment'></i>
					
					<span class="text">
						<h3>1020</h3>
						<p>New Requests</p>
					</span>
				</li>
				<li>
					
					<i class='bx bx-right-indent'></i>
					<span class="text">
						<h1>Add New Reservation</h1>
						<form action="DamniduIT22602978/EventInsert.jsp">
						<input type="submit" name="submit" value="Insert" class="buttons">
						</form>
						
					</span>
			
				</li>
				<li>
					<i class='bx bxs-calendar-check' ></i>
					<span class="text">
						<h3>2543</h3>
						<p>Total Reservations</p>
					</span>
				</li>
			</ul>


			<div class="table-data">
				<div class="order">
					<div class="head">
						<h3>Approved Reservation List</h3>
						<i class='bx bx-search' ></i>
						<i class='bx bx-filter' ></i>
					</div>
					<table>
						<thead>
							<tr>
								<th>Reservation Id</th>
								<th>Full Name</th>
								<th>Phone Number</th>
								<th>Email</th>
								<th>Date & Time </th>
								<th>Event Type</th>
								<th>Package Type</th>
								<th>Special request</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="Alldetails" items="${AlleventDetails1}">
							<tr>
								<td>
									
									<p>${Alldetails.getReservationsid()}</p>
								</td>
								<td>${Alldetails.fulllname}</td>
								<td>${Alldetails.phonenum}</td>
								<td>${Alldetails.email}</td>
				                <td>${Alldetails.datetime}</td>
				               <td>${Alldetails.eventtype}</td>
				                <td>${Alldetails.packagetype}</td>
				               <td>${Alldetails.specialrqst}</td>
				               <td>
				                <div class="buttondashboard" >
				                <form action="/EventPlan/ViewEvent" method="post">
				                <input type="hidden" value="${Alldetails.getReservationsid()}" name="reserveId">
				                <input type="submit" value="view" name="submit" class="buttons">
				                </form>
				                
				                </div>
				                </td>
							</tr>
							
							</c:forEach>
						</tbody>
					</table>
				</div>
			
			</div>
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->


</body>
</html>