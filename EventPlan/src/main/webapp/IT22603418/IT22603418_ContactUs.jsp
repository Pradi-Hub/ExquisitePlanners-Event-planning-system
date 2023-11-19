<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<link rel="stylesheet" href="CSS/IT22603418_CStyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div>
		<div class="contact-form-wrapper d-flex justify-content-center">
			<form action="/EventPlan/contactUsServlet" method="post" class="contact-form">
				<h5 class="title">Contact us</h5>
				<p class="description">Feel free to contact us if you need any
					assistance, any help or another question.</p>
				<div>
					<input type="text" name="name" id="name"
						class="form-control rounded border-white mb-3 form-input"
						placeholder="Name" required autocomplete="off">
				</div>
				<div>
					<input type="email" name="email" id="email"
						class="form-control rounded border-white mb-3 form-input"
						placeholder="Email" required autocomplete="off">
				</div>
				<div>
					<textarea id="message" name="message"
						class="form-control rounded border-white mb-3 form-text-area"
						rows="5" cols="30" placeholder="Message" required
						autocomplete="off"></textarea>
				</div>
				<div class="submit-button-wrapper">
					<input type="submit" value="Send">
				</div>
			</form>
		</div>
	</div>
</body>
</html>