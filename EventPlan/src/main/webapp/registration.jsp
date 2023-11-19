<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<link rel="stylesheet" href="CSS/registration.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="signup">
		<h1>REGISTER NOW</h1>
		<form action="insert" method="post">
			<div class="box">
				<i class="fas fa-user"></i><input type="text" name="name"
					placeholder="Full Name">
			</div>

			<div class="box">
				<i class="fas fa-user"></i><input type="text" name="uname"
					placeholder="User Name">
			</div>

			<div class="box">
				<i class="fa-solid fa-envelope"></i><input type="email" name="email"
					placeholder="E-mail">
			</div>

			<div class="box">
				<i class="fa-solid fa-phone"></i><input type="text" name="phone"
					placeholder="Mobile Number">
			</div>

			<div class="box">
				<i class="fa-solid fa-id-card"></i><input type="text" name="nic"
					placeholder="NIC Number">
			</div>

			<div class="box">
				<i class="fa-solid fa-location-pin"></i><input type="text"
					name="address" placeholder="Address">
			</div>

			<div class="box">
				<i class="fas fa-key"></i><input type="password" name="psw"
					placeholder="Password">
			</div>

			<input type="submit" name="submit" value="Create User" class="sbtn">

			<div class="forgot">
				Already Register ? <a href="login.jsp">Login Here</a>
			</div>
		</form>
	</div>
</body>
</html>