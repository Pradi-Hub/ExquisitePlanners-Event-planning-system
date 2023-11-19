<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supplier Dashboard </title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="s_css/dashboard.css">

</head>
<body>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="index2.jsp">HOME </a><%=session.getAttribute("username")%>
	</nav>
  	
	</nav>
<nav class="navbar">
    <div class="container">
        <h1>Supplier Dashboard </h1>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-title">
                    <form action ="view" method = "POST">
                        <input type="submit" name = "view" value="view All Quotations" class="btn btn-sm btn-primary mb-2"style="width:300px">
                         </form>
                         
                         <a href ="s_quoteInsert.jsp" class="btn btn-sm btn-primary mb-2" style="width:300px">Create Quotations
                         </a>
                         
                </div>
          </div>
           <img src="s_images/s11.jpg" alt="s& s Suppliers Logo" width="600" height=500>
        </div>

        <div class="col-md-6">
            <div class="card">
                <div class="card-title">
                    <h2>order Number #</h2>
                    <form action = "order" method = "POST">
                    Order Id: <input type="text" id="Oname" name="Oname" placeholder="Enter OrderID"><br><br>
                    
                      <input type="submit" name = "Create" value="Search" class="btn btn-sm btn-primary mb-2" style="width:100px">
                    
                    </form>
                </div>
            </div>
              <img src="s_images/s22.jpg" alt="s& s Suppliers Logo" width="600" height=400>
        </div>
        
       
      
    </div>
</div>


</body>
</html>
