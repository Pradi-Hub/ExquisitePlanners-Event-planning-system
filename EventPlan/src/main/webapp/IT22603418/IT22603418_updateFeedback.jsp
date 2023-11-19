<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Feedback</title>
<link rel="stylesheet" href="CSS/IT22603418_Fstyles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="cont">
		<div class="stars">
			<%
				String email = request.getParameter("email");
				String star = request.getParameter("star");
				String message = request.getParameter("message");
			%>
			<form action="/EventPlan/UpdateFeedbackServlet" method = "post">
				<input type="email" name="remailu" value="<%=email%>" readonly autocomplete="off"><br>
				<input class="star star-5" id="star-5-2" type="radio" name="staru" value = "5" <%=(star.equals("5")) ? "checked" : ""%>/>
					<label class="star star-5" for="star-5-2"></label> 
				<input class="star star-4" id="star-4-2" type="radio" name="staru" value = "4" <%=(star.equals("4")) ? "checked" : ""%>/> 
					<label class="star star-4" for="star-4-2"></label> 
				<input class="star star-3" id="star-3-2" type="radio" name="staru" value = "3" <%=(star.equals("3")) ? "checked" : ""%>/> 
					<label class="star star-3" for="star-3-2"></label> 
				<input class="star star-2" id="star-2-2" type="radio" name="staru" value = "2" <%=(star.equals("2")) ? "checked" : ""%>/> 
					<label class="star star-2" for="star-2-2"></label> 
				<input class="star star-1" id="star-1-2" type="radio" name="staru" value = "1" <%=(star.equals("1")) ? "checked" : ""%>/> 
					<label class="star star-1" for="star-1-2"></label>
				<div class="rev-box">
					<textarea class="review" col="30" name="reviewu"><%=message%></textarea>
					<div class="submit-button">
						<input type="submit" value="Update Feedback">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>