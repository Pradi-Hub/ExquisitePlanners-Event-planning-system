<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
   <link rel="stylesheet" type = "text/css" href="s_css/s_form.css">
<title>Quotation Creation</title>
</head>
<body>

	<br><br>
	<form class = "s_form" action="insert1" method="POST" id = "insertQuote" class="border mr-5 ml-5 rounded">
	<center>
	<h2>Quotation Creation</h2>
	</center>
  <div class="form-row">
    <div class="col-4 ml-5 mt-5"> 
      Item Name:<input type="text" name="Iname1"  class="form-control mr-5" placeholder="Item" required>
    </div>
    <div class="col-2 mt-5 ">
      Quantity:<input type="number" name="qty1" class="form-control m1-5" placeholder="Quantity" required>
    </div>
    <div class="col-2 mt-5">
      Unit Price: <input type="number" name="Uprice1" class="form-control mr-4" placeholder="Unit price" required>
    </div>
  </div>
	
	<div class="form-row">
    <div class="col-4 ml-5 mt-5">
     <input type="text" name="Iname2"  class="form-control mr-5" placeholder="Item" required>
    </div>
    <div class="col-2 mt-5">
      <input type="number" name="qty2" class="form-control m1-5" placeholder="Quantity" required>
    </div>
    <div class="col-2 mt-5">
      <input type="number" name="Uprice2" class="form-control mr-4" placeholder="Unit price"required>
    </div>
  </div>
	

	<div class="form-row">
    <div class="col-4 ml-5 mt-5">
      <input type="text" name="Iname3"  class="form-control mr-5" placeholder="Item" required>
    </div>
    <div class="col-2 mt-5">
      <input type="number" name="qty3" class="form-control m1-5" placeholder="Quantity" required>
    </div>
    <div class="col-2 mt-5">
       <input type="number" name="Uprice3" class="form-control mr-4" placeholder="Unit price" required>
    </div>
  </div><br>
  <center>
  <input type ="submit" name="submit" value="Create Quote" class="btn btn-success">
  </center>
	</form>
</body>
<script>
function resetForm() {
    document.getElementById("insertQuote").reset();
} 
</script>
</html>