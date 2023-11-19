<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
<link rel="stylesheet" href="CSS/deleteUser.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String nic = request.getParameter("nic");
	String address = request.getParameter("address");
	String password = request.getParameter("password");
	%>

	
	
	<div class="update">
		<h1>Customer Account Delete</h1>
		<form action="delete" method="post" name="deleteForm">

			<div class="box">
				<i class="fa-solid fa-hashtag"></i><input type="text" name="uid" value="<%=id%>" readonly>
			</div>
			
			<div class="box">
				<i class="fas fa-user"></i><input type="text" name="name" value="<%= name %>" readonly>
			</div>

			<div class="box">
				<i class="fas fa-user"></i><input type="text" name="uname" value="<%= username %>" readonly>
			</div>

			<div class="box">
				<i class="fa-solid fa-envelope"></i><input type="email" name="email" value="<%= email %>" readonly>
			</div>

			<div class="box">
				<i class="fa-solid fa-phone"></i><input type="text" name="phone" value="<%= phone %>" readonly>
			</div>

			<div class="box">
				<i class="fa-solid fa-id-card"></i><input type="text" name="nic" value="<%= nic %>" readonly>
			</div>

			<div class="box">
				<i class="fa-solid fa-location-pin"></i><input type="text" name="address" value="<%= address %>" readonly>
			</div>

			<input type="submit" name="submit" class="sbtn" value="Delete My Account" onclick="confirmDelete(); return false;">
		</form>
	</div>

	<script type="text/javascript">
		function confirmDelete() {
			var result = confirm("Are you sure you want to delete your account?");
			if (result) {
				// User clicked OK, proceed with form submission
				document.forms["deleteForm"].submit();
			} else {
				// User clicked Cancel, do nothing
			}
		}
	</script>
</body>
</html>