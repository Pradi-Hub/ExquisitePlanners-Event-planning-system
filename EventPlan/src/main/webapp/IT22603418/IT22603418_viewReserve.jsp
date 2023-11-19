<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Form View</title>
<link rel="stylesheet" href="IT22603418/CSS/IT22603418_PStyles.css">
<script>
	//JavaScript function to confirm reservation deletion
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
	     	
	     	<!-- Loop through reservation details -->
	    	<c:forEach var="res" items="${resDetails}">
		
			<c:set var = "id" value = "${res.getResid()}"/>
			<c:set var = "name" value = "${res.getFullname()}"/>
			<c:set var = "phone" value = "${res.getPhone()}"/>
			<c:set var = "email" value = "${res.getEmail()}"/>
			<c:set var = "date" value = "${res.getDate()}"/>
			<c:set var = "time" value = "${res.getTime()}"/>
			<c:set var = "location" value = "${res.getLocation()}"/>
			<c:set var = "Package" value = "${res.getPackage()}"/>
			<c:set var = "guestcount" value = "${res.getGuestcount()}"/>
			<c:set var = "eventType" value = "${res.getEventType()}"/>
			<c:set var = "Splrequest" value = "${res.getSplrequest()}"/>
	       <table class="table1"> 
	       <thead>
	     	<tr>
	     		<th colspan="2" style="text-align: center;">Reservation Details</th>
	        </tr>
	  	   </thead>
	            <tr>
	            	<th>Reservation ID</th>
	                <td>${res.getResid()}</td>
	            </tr>
	            <tr>
	          		<th>Full Name</th>
	                <td>${res.getFullname()}</td>
	            </tr>
	            <tr>
	                <th>Phone Number</th>
	                <td>${res.getPhone()}</td>
	            </tr>
	            <tr>    
	                <th>Email Address</th>
	                <td>${res.getEmail()}</td>
	            </tr>
	            <tr>
	                <th>Event Date</th>
	                <td>${res.getDate()}</td>
	            </tr>
	            <tr>    
	                <th>Event Time</th>
	                <td>${res.getTime()}</td>
	            </tr>
	            <tr>
	                <th>Event Location</th>
	                <td>${res.getLocation()}</td>
	            </tr>
	            <tr>    
	                <th>Package</th>
	                <td>${res.getPackage()}</td>
	            </tr>
	            <tr>    
	                <th>No Of Guests</th>
	                <td>${res.getGuestcount()}</td>
	            </tr>
	            <tr>    
	                <th>Event Type</th>
	                <td>${res.getEventType()}</td>
	            </tr>
	            <tr>    
	                <th>Special Request</th>
	                <td>${res.getSplrequest()}</td>
				</tr>  
	   		</table>
	   		</c:forEach>
	    
	    
	    <table class="table2">
	     <thead>
	     	<tr>
	     		<th colspan="2" style="text-align: center;">Additional Services</th>
	     	</tr>
	     </thead>    
	    	<c:forEach var="ser" items="${serDetails}">
			<!-- Set variables for additional service details -->
			<c:set var = "sid" value = "${ser.getSid()}"/>
			<c:set var = "rid" value = "${ser.getResid()}"/>
			<c:set var = "djm" value = "${ser.getDJ_Music()}"/>
			<c:set var = "gna" value = "${ser.getGames_Activities()}"/>
			<c:set var = "pb" value = "${ser.getPhotoBooth()}"/>
			<c:set var = "p" value = "${ser.getPhotographer()}"/>
			<c:set var = "fa" value = "${ser.getFloralDeco()}"/>
			<c:set var = "cp" value = "${ser.getCenterpiecesDeco()}"/>
			<c:set var = "bd" value = "${ser.getBalloonDeco()}"/>
	       
	            <tr>
	            	<th>Service ID</th>
	                <td>${ser.getSid()}</td>
	  			</tr>
	  			<tr>
	  				<th>Reservation ID</th>
	  				<td>${ser.getResid()}</td>
	            </tr>
	            <tr>    
	            	<th>DJ Music</th>
	                <td>${ser.getDJ_Music()}</td>
	            </tr>
	            <tr>
	            	<th>Games & Activities</th>
	                <td>${ser.getGames_Activities()}</td>
	            </tr>
	            <tr>
	            	<th>Photo Booth</th>
	                <td>${ser.getPhotoBooth()}</td>
	            </tr>
	            <tr>
	            	<th>Photographer</th>
	                <td>${ser.getPhotographer()}</td>
	            </tr>
	            <tr>
	            	<th>Floral Deco</th>
	                <td>${ser.getFloralDeco()}</td>
	            </tr>
	            <tr>
	            	<th>Center Piece Deco</th>
	                <td>${ser.getCenterpiecesDeco()}</td>
	            </tr>
	            <tr>
	            	<th>Balloon Deco</th>
	                <td>${ser.getBalloonDeco()}</td>
	            </tr>
	   		</c:forEach>
	    </table>
	   </div> 
		<!-- Create a URL for updating the reservation -->
		<c:url value = "IT22603418/IT22603418_updateReserve.jsp" var = "resupdate">
		<!-- Add parameters for the update URL -->
		<c:param name = "id" value = "${id}"/>
		<c:param name = "name" value = "${name}"/>
		<c:param name = "phone" value = "${phone}"/>
		<c:param name = "email" value = "${email}"/>
		<c:param name = "date" value = "${date}"/>
		<c:param name = "time" value = "${time}"/>
		<c:param name = "location" value = "${location}"/>
		<c:param name = "Package" value = "${Package}"/>
		<c:param name = "guestcount" value = "${guestcount}"/>
		<c:param name = "eventType" value = "${eventType}"/>
		<c:param name = "fa" value = "${fa}"/>
		<c:param name = "cp" value = "${cp}"/>
		<c:param name = "bd" value = "${bd}"/>
		<c:param name = "p" value = "${p}"/>
		<c:param name = "djm" value = "${djm}"/>
		<c:param name = "gna" value = "${gna}"/>
		<c:param name = "pb" value = "${pb}"/>
		<c:param name = "Splrequest" value = "${Splrequest}"/>
			
		</c:url>
		
		<div class="containerE">
		<!-- Create a link to the update page with parameters -->
			<a href = "${resupdate}">
				<input type ="button" name = "Update" value ="Update Reservation" class="btnE">
			</a>
		</div>
		<div class="containerD">	
			<form id="deleteForm"  action="/EventPlan/deleteReserveServlet" method="post">
				<input type="hidden" name="email" value="${email}">
				<!-- Create a button to delete the reservation with confirmation -->
				<input class = "btnD" type ="button" name = "delete" value ="Delete Reservation" onclick="confirmDelete()">
			</form>	
		</div>
		<div class="containerA">
		<!-- Create a link to the home page -->
			<a href = "Home_page_IT22603418.jsp">
				<input type ="button" name = "Home" value ="Back to Home" class="btnA">
			</a>
		</div>
	</div>
</body>
</html>