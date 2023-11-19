<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/IT22603418_FStyles2.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Feedback View</title>
<script>
	function confirmDelete() {
		if (confirm("Are you sure you want to delete your reservation?")) {
			document.getElementById("deleteForm").submit();
		}
	}
</script>
</head>
<body>
	<div class="row">
		<div class="table-container">
			<div class="Addbtn">
				<a href="IT22603418/IT22603418_FeedBack.jsp"> <input type="button"
					value="New Feedback" class="btnA">
				</a>
			</div>
			<table class="table">
				<c:forEach var="feed" items="${feedDetails}">
					<c:set var="Fid" value="${feed.getFid()}" />
					<c:set var="email" value="${feed.getEmail()}" />
					<c:set var="star" value="${feed.getStar()}" />
					<c:set var="message" value="${feed.getReview()}" />

					<c:url value="IT22603418/IT22603418_updateFeedback.jsp" var="feedupdate">
						<c:param name="Fid" value="${Fid}" />
						<c:param name="email" value="${email}" />
						<c:param name="star" value="${star}" />
						<c:param name="message" value="${message}" />

					</c:url>
					<tr>
						<td>${feed.getEmail()}</td>
						<td>${feed.getStar()}</td>
						<td>${feed.getReview()}</td>
						<td>
							<div class="containerE">
								<a href="${feedupdate}"> <input type="button" name="Update"
									value="Update Feedback" class="btnE">
								</a>
							</div>
						</td>
						<td>
							<div class="containerD">
								<form id="deleteForm" action="/EventPlan/DeleteFeedbackServlet" method="post">
									<input type="hidden" name="email" value="${email}"> <input
										class="btnD" type="button" name="delete"
										value="Delete Feedback" onclick="confirmDelete()">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="containerA">
		<a href="Home_page_IT22603418.jsp"> <input type="button" name="Home"
			value="Back to Home" class="btnH">
		</a>
	</div>
		</div>
	</div>
</body>
</html>