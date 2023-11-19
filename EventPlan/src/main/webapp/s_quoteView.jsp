<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="s_supplier.s_quote, s_supplier.s_supplierDBModel, java.util.List, java.util.ArrayList, java.util.Date"%>
<%@page import="s_supplier.s_quote"%>
<%@page import="s_supplier.s_DBConfig"%>
<%@page import="s_supplier.s_supplierDBModel"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Inserted Quotation</title>

<script>
	$(document).ready(function() {
		// Initialize Bootstrap JavaScript components
		$('[data-toggle="collapse"]').collapse();
	});

	function callServlet(quoteId) {
		if (confirm("Are you sure you want to delete this item?")) {
			var contextPath = "${pageContext.request.contextPath}";
			var xhr = new XMLHttpRequest();
			xhr.open("POST", contextPath + "/delete1", true);
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr.send("paramName=" + quoteId);

			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4 && xhr.status === 200) {
					// Reload the page after the servlet operation is complete
					location.reload();
				}
			};
		}
	}
</script>


</head>
<body>
	<center>
		<h2>View All the quotations</h2>
	</center>
	<div class="order-container">


		<c:forEach var="quote" items="${s_quoteLists}" varStatus="loop">
			<c:set var="qid" value="${quote.quoteId}" />


			<c:if test="${loop.index % 3 == 0}">
				<div class="order">
					<div class="d-flex justify-content-center align-items-center"
						style="height: 55px;">


						<input name="qid" class="btn btn-info ml-5 mt-5 py-2"
							type="button" data-toggle="collapse"
							data-target="#order-${quote.quoteId}" style="width: 800px;"
							value="Quote ID: ${quote.quoteId}" id="qid">


					</div>
					<div id="order-${quote.quoteId}" class="collapse">

						<%
						String Qid = request.getParameter("qid");
						s_supplierDBModel supModel = new s_supplierDBModel();
						List<s_quote> s_quoteList = supModel.viewEditform(Qid);
						%>


						<button class="btn btn-sm btn-danger mb-2" onclick="callServlet('${quote.quoteId}')">Delete </button>

						
						<a href="s_updateQuote.jsp?qid=${quote.quoteId}"
							class="btn btn-sm btn-warning mb-2"><i class="fas fa-edit"></i>Edit</a>
							
							<a href="s_singleQuote.jsp?qid=${quote.quoteId}"
							class="btn btn-sm btn-primary mb-2"><i class="fas fa-edit"></i>view More</a>


						<table class="table">
							<thead>
								<tr>
									<th>Item Name</th>
									<th>Quantity</th>
									<th>Unit Price</th>
									<th>Item Price</th>
								</tr>
							</thead>
							<tbody>
								</c:if>
								<tr>
									<td>${quote.itemName}</td>
									<td>${quote.quantity}</td>
									<td>${quote.unitPrice}</td>
									<td>${quote.itemPrice}</td>
								</tr>
								<c:if test="${loop.index % 3 == 2 or loop.last}">
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</c:forEach>

	</div>


</body>
</html>