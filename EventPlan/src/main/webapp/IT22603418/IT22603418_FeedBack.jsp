<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reviews</title>
<link rel="stylesheet" href="CSS/IT22603418_Fstyles1.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="cont">
		<div class="stars">
			<form action="/EventPlan/FeedbackServlet" method = "post" class="Fform">
				<h1 class="supaview__title">Add a new review</h1>
				<input type="email" name="remail" placeholder="Email Address" required autocomplete="off" class="mail"><br>
				<input class="star star-5" id="star-5-2" type="radio" name="star" value = "5" />
					<label class="star star-5" for="star-5-2"></label> 
				<input class="star star-4" id="star-4-2" type="radio" name="star" value = "4" /> 
					<label class="star star-4" for="star-4-2"></label> 
				<input class="star star-3" id="star-3-2" type="radio" name="star" value = "3" /> 
					<label class="star star-3" for="star-3-2"></label> 
				<input class="star star-2" id="star-2-2" type="radio" name="star" value = "2" /> 
					<label class="star star-2" for="star-2-2"></label> 
				<input class="star star-1" id="star-1-2" type="radio" name="star" value = "1" /> 
					<label class="star star-1" for="star-1-2"></label>
				<div class="rev-box">
					<textarea class="review" col="30" name="review"></textarea>
					<div class="submit-button">
						<input type="submit" value="Send Feedback">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>