<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Event</title>
<link rel="stylesheet" href="DamniduIT22602978/css/additionalcss1.css">

<script>


function confirmDelete() {
	if (confirm("Are you sure you want to delete your reservation?")) {
		document.getElementById("deleteForm").submit();
	}
}
</script>
</head>
<body>


  <div class="container">
        <div id="slide">
            <div class="item" style="background-image: url(DamniduIT22602978/img/logo2.png);">
                <div class="content">
                <c:forEach var="details" items="${eventDetails}">
                    <div class="name">Reservation -> ID:${details.reservationsid}</div>
                    <div class="des">
                        <table>
                        <thead>
                        <tr>
                            <th>Reservation Id</th>
                            <th>Full Name</th>
                            <th>Phone Number </th>
                            <th>Email </th>
                            <th>Date & Time  </th>
                            <th>Event Type </th>
                            <th>Package Type </th>
                            <th>Special Request </th>
                            <tr>
                           <thead>
                            <tbody>
                                <tr>
                                    <td>    ${details.reservationsid}</td>
									<td>    ${details.fulllname}</td>
									<td>    ${details.phonenum}</td>
									<td>    ${details.email}</td>
									<td>    ${details.datetime}</td>
									<td>    ${details.eventtype}</td>
									<td>    ${details.packagetype}</td>
									<td>    ${details.specialrqst}</td>
                                </tr>
                    <tr>
                    <td>
                    
                    <form action="DamniduIT22602978/UpdateEvent.jsp" method="post">
                    <input type="hidden" name="CxId" value="${details.reservationsid}" >
                  <input type="hidden" name="Cxname"  value="${details.fulllname}">
                  <input type="hidden" name="Cxpnumber" value="${details.phonenum}">
                  <input type="hidden" name="Cxemail" value="${details.email}">
                  <input type="hidden" name="eventdateTime" value="${details.datetime}">
                  <input type="hidden" name="eventtype"  value="${details.eventtype}">
                  <input type="hidden" name="package"  value="${details.packagetype}">
					<input type="hidden" name="SpecialRqst"   value="${details.specialrqst}">
                  <input type="submit" class="buttons" name="submit" value="Update">
                        
                    </form>
                    
                    
                    </td>
                    <td><form action="/EventPlan/DeleteReservation" method="post">
                    <input type="hidden" name="CxId" value="${details.reservationsid}" >
                        <input type="submit" name="submit" class="buttons" value="Delete" onclick="confirmDelete()">
                    </form></td>
                    <td>
                    <form action="/EventPlan/ViewAllEvents"method="post">
					<input type="submit" name="submit" value="Back to Dashboard" class="buttons" >
					</form>
                    </td>
                </tr>
                </tbody>
                </table>
                </div>
                
                
                </c:forEach>
                </div>
            </div>
            
            
            
            
        </div>
        
    </div>

</body>
</html>