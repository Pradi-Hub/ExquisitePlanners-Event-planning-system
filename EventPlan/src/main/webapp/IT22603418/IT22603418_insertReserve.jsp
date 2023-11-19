<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Form</title>
<link rel="stylesheet" href="CSS/IT22603418_PStyles.css">
<script>
// Function to disable previous dates
function validateCalendar() {
    var today = new Date().toISOString().slice(0, 10);
    document.getElementsByName("edate")[0].min = today;
}

window.onload = function() {
    validateCalendar();
}

function validateForm() {
    var Name = document.forms["myForm"]["fname"].value;
    var Pnumber = document.forms["myForm"]["phone"].value;
    var Email = document.forms["myForm"]["email"].value;

    // Check if Full Name is not empty
    if (Name == "") {
        alert("Full Name must be filled out");
        return false;
    }

    // Check if Phone Number is valid
    var phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(Pnumber)) {
        alert("Phone Number must be 10 digits");
        return false;
    }

    // Check if Email is valid
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(Email)) {
        alert("Invalid Email Address");
        return false;
    }

    return true; // Form is valid and can be submitted
}
</script>
</head>
<body>
	<div class="background">
    	<div class="transbox">
            <!--reservation form-->
            <div class="form">
				<form action="/EventPlan/viewReserveServlet" method="post" id="myForm" onsubmit = "return validateForm()">
					<fieldset>
                        <legend><span class="number">1</span> Personal Information</legend>
                        <input type="text" name="fname" placeholder="Full Name" required autocomplete="off">
                        <input type="tel" name="phone" placeholder="Phone Number" required autocomplete="off">
                        <input type="email" name="email" placeholder="Email Address" required autocomplete="off">
                        
                        <label for="CheckInDate">Event Date</label>
                            <input type="date" name="edate" required>
                            
                        <label for="CheckInDate">Event Time</label>
                            <input type="time" name="etime" required>
                      	
                      	<input type="text" name="location" placeholder="Location" required autocomplete="off">
                        
                        <legend>Package</legend>
	                        <select name="Package">
								<option value="pkg1">Package1</option>
								<option value="pkg2">Package2</option>
								<option value="pkg3">Package3</option>
								<option value="pkg4">Package4</option>
								<option value="pkg5">Package5</option>
	                        </select>
                        
                        <label for="count">Number of Guests</label>
                            <input type="number" name="count" min="1" placeholder="Guest Count" required>
                        
                        
                        <label for="guest">Event Type</label>
                        	<select name="type">
						    	<option value="Wedding">Wedding</option>
						        <option value="Engagement">Engagement</option>
						        <option value="Anniversary">Anniversary</option>
						        <option value="Birthday">Birthday</option>
					        </select>
					</fieldset>
					<legend><span class="number">2</span> Additional Services</legend>
					<fieldset>
						<legend>Decorations</legend>
								<h4 class="tab">Floral Arrangement</h4>
			                	<input type="radio" name="decoration1" value="Yes">Yes
			                    <input type="radio" name="decoration1" value="No">No
			                    
			                    <h4 class="tab">Table Centerpieces</h4>
			                	<input type="radio" name="decoration2" value="Yes">Yes
			                    <input type="radio" name="decoration2" value="No">No
			                    
			                    <h4 class="tab">Balloon Decorations</h4>
			                	<input type="radio" name="decoration3" value="Yes">Yes
			                    <input type="radio" name="decoration3" value="No">No
                        <legend>Photographers</legend>
	                        <select name="Photographers">
								<option value="pg1">P1</option>
								<option value="pg2">P2</option>
								<option value="pg3">P3</option>
								<option value="pg4">P4</option>
								<option value="pg5">P5</option>
	                        </select>
	                    <legend>Entertainments</legend>   
		                    <input type="checkbox" name="Entertainments1" value="want"> DJ Music
						    <input type="checkbox" name="Entertainments2" value="want"> Games & Activities
						    <input type="checkbox" name="Entertainments3" value="want"> Photo Booth
                    </fieldset>  
					<br>
                    <legend><span class="number">3</span> Special Request</legend>
                    <fieldset>
                        <textarea name="Splrequest" placeholder = "You can type here..." autocomplete="off"></textarea>
                    </fieldset>
                    <a href="#">
				      <input type="submit" name = "submit" value="Reserve">
				    </a>
			    </form>
    		</div>
    	</div>
    </div>
</body>
</html>