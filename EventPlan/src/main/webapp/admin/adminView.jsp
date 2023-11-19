<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="CSS/adminView.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	
	<!-- <a href="index2.jsp">main</a>
	
	<!--   <a href="#"><%=session.getAttribute("username") %></a> -->

	<!-- Sidebar -->
	<div class="sidebar">
	<!-- <i class='bx bx-code-alt'></i> -->
	
		
			<div class="logo-name">
				<span>EXQUISITE</span>PLANNERS
			</div>
		
		<ul class="side-menu">
			<li><a href="#"><i class='bx bxs-dashboard'></i>Dashboard</a></li>
			<li><a href="index2.jsp" target="_blank"><i class='bx bx-store-alt'></i>Home</a></li>
			<li><a href="admin/adminViewUsers.jsp"><i class='bx bx-group'></i>Users</a></li>
			<li><a href="#"><i class='bx bx-store-alt'></i>Suppliers</a></li>
		</ul><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<ul class="side-menu">
			<li><a href="#" class="logout"> <i
					class='bx bx-log-out-circle'></i> Logout
			</a></li>
		</ul>
	</div>
	<!-- End of Sidebar -->

	<!-- Main Content -->
	<div class="content">
		<!-- Navbar -->
		<nav>
		<i class='bx bx-menu'></i>
			<form action="#">
				<div class="form-input">
					<input type="search" placeholder="Search...">
					<button class="search-btn" type="submit">
						<i class='bx bx-search'></i>
					</button>
				</div>
			</form>
			<a href="#" class = "session"><%=session.getAttribute("username") %></a>
			<a href="#" class="notif"> <i class='bx bx-bell'></i> <span
				class="count">12</span>
			</a> <a href="#" class="profile"> <img src="image/logo.jpg">
			</a>
		</nav>
		<!-- End of Navbar -->

		<main>
			<div class="header">

				<h1>Dashboard</h1>

			</div>

			<!-- Insights -->
			<ul class="insights">
				<a href="admin/addPackages.jsp" target="_blank"><li><i class="fas fa-plus-square fa-3x text-primary"></i> <span class="info">
						<h3>Add Packages</h3>
				</span></li></a>
				<a href="admin/allPackages.jsp" target="_blank"><li><i class="fas fa-gift fa-3x text-danger"></i> <span class="info">
						<h3>All Packages</h3>
				</span></li></a>
			</ul>
			<!-- End of Insights -->
			
			<div class="bottom-data">
                <div class="orders">
                    <div class="header">
                        <i class='bx bx-receipt'></i>
                        <h3>Recent Orders</h3>
                        <i class='bx bx-filter'></i>
                        <i class='bx bx-search'></i>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>User</th>
                                <th>Order Date</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <img src="image/admin.jpg">
                                    <p>John Doe</p>
                                </td>
                                <td>14-08-2023</td>
                                <td><span class="status completed">Completed</span></td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="image/admin.jpg">
                                    <p>John Doe</p>
                                </td>
                                <td>14-08-2023</td>
                                <td><span class="status pending">Pending</span></td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="image/admin.jpg">
                                    <p>John Doe</p>
                                </td>
                                <td>14-08-2023</td>
                                <td><span class="status process">Processing</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <!-- Reminders -->
                <div class="reminders">
                    <div class="header">
                        <i class='bx bx-note'></i>
                        <h3>Remiders</h3>
                        <i class='bx bx-filter'></i>
                        <i class='bx bx-plus'></i>
                    </div>
                    <ul class="task-list">
                        <li class="completed">
                            <div class="task-title">
                                <i class='bx bx-check-circle'></i>
                                <p>Start Our Meeting</p>
                            </div>
                            <i class='bx bx-dots-vertical-rounded'></i>
                        </li>
                        <li class="completed">
                            <div class="task-title">
                                <i class='bx bx-check-circle'></i>
                                <p>Analyse Our Site</p>
                            </div>
                            <i class='bx bx-dots-vertical-rounded'></i>
                        </li>
                        <li class="not-completed">
                            <div class="task-title">
                                <i class='bx bx-x-circle'></i>
                                <p>Play Footbal</p>
                            </div>
                            <i class='bx bx-dots-vertical-rounded'></i>
                        </li>
                    </ul>
                </div>

                <!-- End of Reminders-->

            </div>
	</div>

	</main>
	</div>


</body>
</html>