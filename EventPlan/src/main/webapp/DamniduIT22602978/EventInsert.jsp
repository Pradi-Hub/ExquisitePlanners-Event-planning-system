<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

	<title>Reservation From</title>

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



  <div class="login-root">
    
      <div class="loginbackground box-background--white ">
        
      </div>
      <div class="box-root padding-top--24 flex-flex flex-direction--column" style="flex-grow: 1; z-index: 9;">
        <div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
          <h1>Reservation Approval Form</h1>
        </div>
        
          <div class="formbg">
            <div class="formbg-inner padding-horizontal--48">
              <span class="padding-bottom--15">Enter the Reservation Details </span>
              <form action="/EventPlan/EventsInsert"  method="post" id="stripe-login" onsubmit="return validateForm()">
                <div class="field padding-bottom--24">
                  <label for="cx Name">Full Name</label>
                  <input type="text" name="Cxname" >
                  <label for="cx pnumber">Phone Number</label>
                  <input type="Tel" name="Cxpnumber" >
                  <label for="cx email">Email-Address</label>
                  <input type="email" name="Cxemail">
                  <label for="event date-time">Event Datetime</label>
                  <input type="datetime-local" name="eventdateTime">
                  <label for="eventtype">Event type</label>
                  <select id ="eventtype" name="eventtype" >
                  		<option value="weddings"> Weddings</option>
                  		<option value="Engagement"> Engagement</option>
                  		<option value="Anniversary"> Anniversary</option>
                  		<option value="Birthday"> Birthday</option>
                  		</select>
                  <label for="package"> Package</label>
                  <select id ="package" name="package" >
                  		<option value="Package 01"> Package 01</option>
                  		<option value="Package 02"> Package 02</option>
                  		<option value="Package 03"> Package 03</option>
                  		<option value="Package 04"> Package 04</option>
                  		</select>
                  <label for="specialrqst">Special Request:</label>

					<textarea id="specilarqst" name="SpecialRqst"  rows="4" cols="50" placeholder="If any special requests"></textarea>
					                  
                </div>
                
                
                <div class="field padding-bottom--24">
                  <input type="submit" name="submit" value="Next">
                </div>
               
              </form>
            </div>
          </div>
          
        
      </div>
    
  </div>
  <script src="Js/additional_data.js"></script>
</body>

</html>