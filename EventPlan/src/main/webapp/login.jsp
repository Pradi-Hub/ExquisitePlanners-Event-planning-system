<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Form</title>
<link rel="stylesheet" href="CSS/login.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<!-- Check Box -->
	<input type="checkbox" id="showhide">
	<!-- Show Buttons -->
	<div class="showbtn">
		<a href="#"><label for="showhide"><i class="fas fa-eye"></i></label></a>
		<a href="#"><label for="showhide"><i
				class="fas fa-eye-slash"></i></label></a>
	</div>

	<div class="signin">
		<div class="logo"></div>
      	<div class="title">EXQUISITE PLANNERS</div>
		<form action="log" method="post">
			<div class="box">
				<i class="fas fa-user"></i><input type="text" name="uname"
					placeholder="Enter Your User Name">
			</div>

			<div class="box">
				<i class="fas fa-key"></i><input type="password" name="psw"
					placeholder="Enter Your Password">
			</div>

			<div class="forgot1">
				<a href="#">Forgot Password?</a>
			</div>

			<input type="submit" name="submit" value="LOG IN" class="sbtn">

			<div class="forgot">
				Not yet a member ? <a href="registration.jsp">Sign Up</a>
			</div>
		</form>
	</div>
</body>
</html>