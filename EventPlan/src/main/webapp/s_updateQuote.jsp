<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="s_supplier.s_quote"%>
<%@page import="s_supplier.s_DBConfig"%>
<%@ page
	import="s_supplier.s_quote, s_supplier.s_supplierDBModel, java.util.List, java.util.ArrayList, java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
	  <link rel="stylesheet" type = "text/css" href="s_css/s_form.css">
<title>Quotation update</title>
</head>
<body>

	<%
	String qid = request.getParameter("qid");
	s_supplierDBModel supModel = new s_supplierDBModel();
	List<s_quote> s_quoteList = supModel.viewEditform(qid);

	int i = 1;
	s_quote qobj1 = new s_quote();
	s_quote qobj2 = new s_quote();
	s_quote qobj3 = new s_quote();
	for (s_quote quote : s_quoteList) {

		if (i == 1) {
			qobj1.setItemName(quote.getItemName());
			qobj1.setQuantity(quote.getQuantity());
			qobj1.setUnitPrice(quote.getUnitPrice());
			qobj1.setQuoteId(quote.getQuoteId());
		} else if (i == 2) {
			qobj2.setItemName(quote.getItemName());
			qobj2.setQuantity(quote.getQuantity());
			qobj2.setUnitPrice(quote.getUnitPrice());
		} else if (i == 3) {
			qobj3.setItemName(quote.getItemName());
			qobj3.setQuantity(quote.getQuantity());
			qobj3.setUnitPrice(quote.getUnitPrice());
		}
		i++;
	}
	%>


	<br>
	<br>
	<form  class = "s_form"  action="update1" method="POST" class="border mr-5 ml-5 rounded" >
			<center>
	<h2>Quotation Update</h2>
	</center>
	
		<div class="col-1 mt-3">
			Quote ID:<input type="text" name="qid" class="form-control mr-4"
				placeholder="QuoteID" value="<%=qobj1.getQuoteId()%>" readonly>
		</div>
		<div class="form-row">
			<div class="col-4 ml-5 mt-5">
				<input type="text" name="Iname1" class="form-control mr-5"
					placeholder="Item" value="<%=qobj1.getItemName()%>" readonly>
			</div>
			<div class="col-2 mt-5">
				<input type="text" name="qty1" class="form-control m1-5"
					placeholder="Quantity" value="<%=qobj1.getQuantity()%>">
			</div>
			<div class="col-2 mt-5">
				<input type="text" name="Uprice1" class="form-control mr-4"
					placeholder="Unit price" value="<%=qobj1.getUnitPrice()%>">
			</div>
		</div>

		<div class="form-row">
			<div class="col-4 ml-5 mt-5">
				<input type="text" name="Iname2" class="form-control mr-5"
					placeholder="Item" value="<%=qobj2.getItemName()%>" readonly>
			</div>
			<div class="col-2 mt-5">
				<input type="text" name="qty2" class="form-control m1-5"
					placeholder="Quantity" value="<%=qobj2.getQuantity()%>">
			</div>
			<div class="col-2 mt-5">
				<input type="text" name="Uprice2" class="form-control mr-4"
					placeholder="Unit price" value="<%=qobj1.getUnitPrice()%>">
			</div>
		</div>


		<div class="form-row">
			<div class="col-4 ml-5 mt-5">
				<input type="text" name="Iname3" class="form-control mr-5"
					placeholder="Item" value="<%=qobj3.getItemName()%>" readonly>
			</div>
			<div class="col-2 mt-5">
				<input type="text" name="qty3" class="form-control m1-5"
					placeholder="Quantity" value="<%=qobj3.getQuantity()%>">
			</div>
			<div class="col-2 mt-5">
				<input type="text" name="Uprice3" class="form-control mr-4"
					placeholder="Unit price" value="<%=qobj3.getUnitPrice()%>">
			</div>
		</div>

		<br>
		<center>
			<input type="submit" name="submit" value="Update Quote details" class="btn btn-warning">
		</center>
	</form>

</body>
</html>