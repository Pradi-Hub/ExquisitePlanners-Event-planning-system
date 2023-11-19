<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

	<title>Booking Form HTML Template</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">

	
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script>
// Function to disable previous dates
function validateCalendar() {
    var today = new Date().toISOString().slice(0, 16);
    document.getElementsByName("eventdateTime")[0].min = today;
}

window.onload = function() {
    validateCalendar();
}


</script>

	

</head>

<body>
<%


String id=request.getParameter("CxId");
String fullname=request.getParameter("Cxname");
String phonenum=request.getParameter("Cxpnumber");
String email=request.getParameter("Cxemail");
String datetime=request.getParameter("eventdateTime");
String eventtype=request.getParameter("eventtype");
String packagetype=request.getParameter("package");
String specialrqst=request.getParameter("SpecialRqst");

%>


  <div class="login-root">
    
      <div class="loginbackground box-background--white padding-top--64">
        
      </div>
      <div class="box-root padding-top--24 flex-flex flex-direction--column" style="flex-grow: 1; z-index: 9;">
        <div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
          <h1><a href="http://blog.stackfindover.com/" rel="dofollow">Reservation Update Form Customer Id:<%=id %></a></h1>
        </div>
        <div class="formbg-outer">
          <div class="formbg">
            <div class="formbg-inner padding-horizontal--48">
              <span class="padding-bottom--15">Enter the Reservation Details </span>
              <form action="/EventPlan/UpdateEventDetails"  method="post" id="stripe-login" >
                <div class="field padding-bottom--24">
                	<input type="hidden" name="cusid" value="<%=id %>">
                  <label for="cx Name">Full Name</label>
                  <input type="text" name="Cxname" value="<%=fullname%>">
                  <label for="cx pnumber">Phone Number</label>
                  <input type="Tel" name="Cxpnumber" value="<%=phonenum%>"  >
                  <label for="cx email">Email-Address</label>
                  <input type="email" name="Cxemail" value="<%=email%>">
                  <label for="event date-time">Event Datetime</label>
                  <input type="datetime-local" name="eventdateTime" value="<%=datetime%>">
              
					                  
                </div>
                
                
                <div class="field padding-bottom--24">
                  <input type="submit" name="submit" value="Next">
                </div>
               
              </form>
            </div>
          </div>
          
        </div>
      </div>
    </div>

</body>

</html>