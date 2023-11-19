 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
<link rel="stylesheet" href="CSS/IT22603418_PStyles.css">
<script>
// Function to disable previous dates
function validateCalendar() {
    var today = new Date().toISOString().slice(0, 10);
    document.getElementsByName("edateu")[0].min = today;
}

window.onload = function() {
    validateCalendar();
}

function validateForm() {
    var Name = document.forms["myForm"]["fnameu"].value;
    var Pnumber = document.forms["myForm"]["phoneu"].value;
    var Email = document.forms["myForm"]["emailu"].value;

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
            
            	<%
					String name = request.getParameter("name");
					String phone = request.getParameter("phone");
					String email = request.getParameter("email");
					String date = request.getParameter("date");
					String time = request.getParameter("time");
					String location = request.getParameter("location");
					String Package = request.getParameter("Package");
					String guestcount = request.getParameter("guestcount");
					String eventType = request.getParameter("eventType");
					String fa = request.getParameter("fa");
					String cp = request.getParameter("cp");
					String bd = request.getParameter("bd");
					String p = request.getParameter("p");
					String djm = request.getParameter("djm");
					String gna = request.getParameter("gna");
					String pb = request.getParameter("pb");
					String Splrequest = request.getParameter("Splrequest");
				%>
				<form action="/EventPlan/updateReserveServlet" method="post" id="myForm" onsubmit = "return validateForm()">
					<fieldset>
                        <legend><span class="number">1</span> Personal Information</legend>
                        <input type="text" name="fnameu" value="<%=name%>" required autocomplete="off">
                        <input type="tel" name="phoneu" value="<%=phone%>" required autocomplete="off">
                        <input type="email" name="emailu" value="<%=email%>" required autocomplete="off" readonly>
                        
                        <label for="CheckInDate">Event Date</label>
                            <input type="date" name="edateu" value="<%=date%>" required>
                            
                        <label for="CheckInDate">Event Time</label>
                            <input type="time" name="etimeu" value="<%=time%>" required>
                      	
                      	<input type="text" name="locationu" value="<%=location%>" required autocomplete="off">
                        
                        <legend>Package</legend>
	                        <select name="Packageu">
								<option value="pkg1" <%=(Package.equals("pkg1")) ? "selected='selected'" : ""%>>Package1</option>
								<option value="pkg2" <%=(Package.equals("pkg2")) ? "selected='selected'" : ""%>>Package2</option>
								<option value="pkg3" <%=(Package.equals("pkg3")) ? "selected='selected'" : ""%>>Package3</option>
								<option value="pkg4" <%=(Package.equals("pkg4")) ? "selected='selected'" : ""%>>Package4</option>
								<option value="pkg5" <%=(Package.equals("pkg5")) ? "selected='selected'" : ""%>>Package5</option>
	                        </select>
                        
                        <label for="count">Number of Guests</label>
                            <input type="number" name="countu" min="1" value="<%=guestcount%>" required>
                        
                        
                        <label for="guest">Event Type</label>
                        	<select name="typeu">
						    	<option value="Wedding" <%=(eventType.equals("Wedding")) ? "selected='selected'" : ""%>>Wedding</option>
						        <option value="Engagement" <%=(eventType.equals("Engagement")) ? "selected='selected'" : ""%>>Engagement</option>
						        <option value="Anniversary" <%=(eventType.equals("Anniversary")) ? "selected='selected'" : ""%>>Anniversary</option>
						        <option value="Birthday" <%=(eventType.equals("Birthday")) ? "selected='selected'" : ""%>>Birthday</option>
					        </select>
					</fieldset>
					<legend><span class="number">2</span> Additional Services</legend>
					<fieldset>
						<legend>Decorations</legend>
								<h4 class="tab">Floral Arrangement</h4>
			                	<input type="radio" name="decoration1u" value="Yes" <%=(fa.equals("Yes")) ? "checked" : ""%>>Yes
			                    <input type="radio" name="decoration1u" value="No" <%=(fa.equals("No")) ? "checked" : ""%>>No
			                    
			                    <h4 class="tab">Table Centerpieces</h4>
			                	<input type="radio" name="decoration2u" value="Yes" <%=(cp.equals("Yes")) ? "checked" : ""%>>Yes
			                    <input type="radio" name="decoration2u" value="No" <%=(cp.equals("No")) ? "checked" : ""%>>No
			                    
			                    <h4 class="tab">Balloon Decorations</h4>
			                	<input type="radio" name="decoration3u" value="Yes" <%=(bd.equals("Yes")) ? "checked" : ""%>>Yes
			                    <input type="radio" name="decoration3u" value="No" <%=(bd.equals("No")) ? "checked" : ""%>>No
                        <legend>Photographers</legend>
	                        <select name="Photographersu">
								<option value="pg1" <%=(p.equals("pg1")) ? "selected='selected'" : ""%>>P1</option>
								<option value="pg2" <%=(p.equals("pg2")) ? "selected='selected'" : ""%>>P2</option>
								<option value="pg3" <%=(p.equals("pg3")) ? "selected='selected'" : ""%>>P3</option>
								<option value="pg4" <%=(p.equals("pg4")) ? "selected='selected'" : ""%>>P4</option>
								<option value="pg5" <%=(p.equals("pg5")) ? "selected='selected'" : ""%>>P5</option>
	                        </select>
	                    <legend>Entertainments</legend>   
		                    <input type="checkbox" name="Entertainments1u" value="want" <%=(djm != null && djm.equals("want")) ? "checked" : ""%>> DJ Music
						    <input type="checkbox" name="Entertainments2u" value="want" <%=(gna != null && gna.equals("want")) ? "checked" : ""%>> Games & Activities
						    <input type="checkbox" name="Entertainments3u" value="want" <%=(pb != null && pb.equals("want")) ? "checked" : ""%>> Photo Booth
                    </fieldset>  
					<br>
                    <legend><span class="number">3</span> Special Request</legend>
                    <fieldset>
                        <textarea name="Splrequestu" autocomplete="off"><%=Splrequest%></textarea>
                    </fieldset>
                    <a href="#">
				      <input type="submit" name = "submit" value="Edit">
				    </a>
			    </form>
    		</div>
    	</div>
    </div>
</body>
</html>