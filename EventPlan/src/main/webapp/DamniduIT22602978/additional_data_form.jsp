<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inform page</title>
    <link rel="stylesheet" href="DamniduIT22602978/css/additional_data.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <div id="slide">
            <div class="item" style="background-image: url(DamniduIT22602978/img/1.jpg);">
                <div class="content">
                <!-- form for insert the hotel details -->
                    <div class="name"><h2>Hotel Details</h2>Reservation ID:${eventDetails} </div>
                    <div class="des">
                    <form action="HotelinfoInsert" method="post">
                    <input type="hidden" id="reserveid" name="reserveId" value="${eventDetails}">
                    <label for="hotel id">Hotel Id:</label><br>
  					<select id="hotel_id" name="hotel_id">
					  <option value="H001">H001</option>
					  <option value="H002">H002</option>
					  <option value="H003">H003</option>
					  <option value="H004">H004</option>
					  <option value="H005">H005</option>
						</select><br>
                    <label for="attendees">No of attendees:</label><br>
  					<input type="text" id="attendees" name="attendees"><br>
  					<label for="halltype">Hall Type:</label><br>
  					<select id="halltype" name="halltype">
					  <option value="ballroom">Ballroom</option>
					  <option value="Conference">Conference Room</option>
					  <option value="Meeting">Meeting Room</option>
					  <option value="Banquet-Hall">Banquet Hall</option>
					  <option value="Outdoor">Outdoor Trace OR Garden</option>
					  <option value="Bar">Lounge Or Cocktail Bar</option>
					  <option value="Auditorium">Auditorium</option>
					  <option value="Pool">Pool Area</option>
						</select><br>
					<label for="specialrqst">Any Further Details:</label><textarea id="specilarqst" name="Specialrqst"  rows="3" cols="20" placeholder="Further Details"></textarea><br>
                    <input class="buttonT"type="submit" value="Submit">
                    </form>
                    </div>
                    
                    
                </div>
            </div>
            <div class="item" style="background-image: url(DamniduIT22602978/img/2.jpg);">
                <div class="content">
                <!-- form for insert the decoration details -->
                    <div class="name"><h2>Decorations Details</h2>Reservation ID:${eventDetails}</div>
                    <div class="des">
                    <form action="DecorationinfoInsert" method="post">
                    <input type="hidden" id="reserveid" name="reserveId" value="${eventDetails}">
                    <label for="Decorator id">Event Decorator Id:</label><br>
  					<select id="Decorator_id" name="Decorator_id">
					  <option value="D001">D001</option>
					  <option value="D002">D002</option>
					  <option value="D003">D003</option>
					  <option value="D004">D004</option>
					  <option value="D005">D005</option>
						</select><br>
                    <label for="attendees">No of attendees:</label><br>
  					<input type="text" id="attendees" name="attendees"><br>
  					<label for="eventtype">Event Type:</label><br>
  					<select id="eventtype" name="eventtype">
					  <option value="birthday">Birthday</option>
					  <option value="wedding">Wedding</option>
					  <option value="Cooperate">Cooperate Event</option>
						</select><br>
						<label for="eventtheme">Event Theme:</label><br>
  					<input type="text" id="eventtheme" name="eventtheme"><br>
						<label for="decorationstyle">Decoration Style:</label><br>
  					<select id="decorationstyle" name="decorationstyle">
					  <option value="rustic">Rustic</option>
					  <option value="modern">Modern</option>
					  <option value="vintage">Vintage</option>
						</select><br>
					<label for="specialrqst">Any Further Details:</label><textarea id="specilarqst" name="Specialrqst"  rows="3" cols="20" placeholder="Further Details"></textarea><br>
                    <input class="buttonT"type="submit" value="Submit">
                    </form>
                    </div>
                    
                </div>
            </div>
            <div class="item" style="background-image: url(DamniduIT22602978/img/3.jpg);">
                <div class="content">
                <!-- form for insert the Catering details -->
                    <div class="name"><h2>Catering</h2>Reservation ID:${eventDetails}</div>
                    <div class="des">
                    <form action="CateringInfo" method="post">
                    <input type="hidden" id="reserveid" name="reserveId" value="${eventDetails}">
                    <label for="catering id">Catering Service  Id:</label><br>
  					<select id="catering_id" name="catering_id">
					  <option value="C001">C001</option>
					  <option value="C002">C002</option>
					  <option value="C003">C003</option>
					  <option value="C004">C004</option>
					  <option value="C005">C005</option>
						</select><br>
                    <label for="attendees">No of attendees:</label><br>
  					<input type="text" id="attendees" name="attendees"><br>
  					<label for="eventtype">Event Type:</label><br>
  					<select id="eventtype" name="eventtype">
					  <option value="birthday">Birthday</option>
					  <option value="wedding">Wedding</option>
					  <option value="Cooperate">Cooperate Event</option>
						</select><br>
						<label for="eventtheme">Event Theme:</label><br>
  					<input type="text" id="eventtheme" name="eventtheme"><br>
  					<label for="fooditem">Food items:</label><br><textarea id="fooditem" name="fooditem"  rows="1" cols="20" placeholder="Enter Food Items"></textarea><br>
						<label for="platetype">Plate type:</label><br>
  					<select id="platetype" name="platetype">
					  <option value="premium">Premium</option>
					  <option value="luxury">Luxury</option>
					  <option value="normal">Normal</option>
						</select><br>
					<label for="specialrqst">Any Further Details:</label><textarea id="specilarqst" name="Specialrqst"  rows="3" cols="20" placeholder="Further Details"></textarea><br>
                    <input class="buttonT"type="submit" value="Submit">
                    </form>
                    </div>
                   
                </div>
            </div>
            <div class="item" style="background-image: url(DamniduIT22602978/img/4.jpg);">
                <div class="content">
                <!-- form for insert the photography details -->
                    <div class="name"><h2>Photography</h2>Reservation ID:${eventDetails}</div>
                    <div class="des">
                   <form action="Photographinfo" method="post">
                    <input type="hidden" id="reserveid" name="reserveId" value="${eventDetails}">
                    <label for="Photographer id">Photographer Id:</label><br>
  					<select id="Photographer_id" name="Photographer_id">
					  <option value="P001">P001</option>
					  <option value="P002">P002</option>
					  <option value="P003">P003</option>
					  <option value="P004">P004</option>
					  <option value="P005">P005</option>
						</select><br>
                    <label for="attendees">No of attendees:</label><br>
  					<input type="text" id="attendees" name="attendees"><br>
  					<label for="Packagetype">Package Type:</label><br>
  					<select id="packagetype" name="packagetype">
					  <option value="golden">Golden</option>
					  <option value="premium">Premium</option>
					  <option value="silver">Silver</option>
						</select><br>
						<label for="eventtheme">Event Theme:</label><br>
  					<input type="text" id="eventtheme" name="eventtheme"><br>
  					<label for="vidoegrapher">Videographer:</label><br>
  					<input type="radio" id="videographerY" name="videographer" value="yes">
					  <label for="vidoegrapherY">Need</label>
					  <input type="radio" id="videographerN" name="videographer" value="no">
					  <label for="vidoegrapherN">No Need</label><br>
					<label for="specialrqst">Any Further Details:</label><textarea id="specilarqst" name="Specialrqst"  rows="3" cols="20" placeholder="Further Details"></textarea><br>
                    <input class="buttonT"type="submit" value="Submit">
                    </form>
                    </div>
                    
                </div>
            </div>
            
            
        </div>
        <div class="buttons">
            <button id="prev"><i class="fa-solid fa-angle-left"></i></button>
            <button id="next"><i class="fa-solid fa-angle-right"></i></button>
            <form action="ViewEvent" method="post">
             <input type="hidden" id="reserveid" name="reserveId" value="${eventDetails}">
            <input type="submit" value="View Final" id="Done">
            </form>
        </div>
        
    </div>

    <script src="DamniduIT22602978/Js/additional_data.js"></script>
</body> 



</html>

