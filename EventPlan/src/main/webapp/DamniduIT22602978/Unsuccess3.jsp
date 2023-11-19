<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Unsuccessful</title>
    <style>
        /* Styles for the popup */
        .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            z-index: 9999;
        }

        /* Styles for the overlay background */
        .overlay {
            display: absolute;
            position: relative;
            top: 0;
            left: 0;
            width: 150vh%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 9998;
        }

        /* Style for the close button */
        .popup-close {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }
        
    </style>
</head>
<body>
   

    <%-- Retrieve and display the error message if it's available --%>
    <c:if test="${not empty errorMessage}">
        <!-- Display the overlay background -->
        <div class="overlay">
         <img alt="" src="DamniduIT22602978/img/background.jpg" style="opacity:50%">
        
        </div>
        <!-- Display the popup -->
        <div class="popup">
            <span class="popup-close" onclick="closePopup()"></span>
            <p>${errorMessage}</p>
            <p>Please go back and check your input.</p>
            <!-- Add a button to redirect back to EventInsert.jsp -->
            <button onclick="redirectToEventInsert()">Back to Event Insert</button>
        </div>
        <!-- JavaScript to show the popup and overlay -->
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                document.querySelector('.overlay').style.display = 'block';
                document.querySelector('.popup').style.display = 'block';
            });

            // Function to close the popup
            function closePopup() {
                document.querySelector('.overlay').style.display = 'none';
                document.querySelector('.popup').style.display = 'none';
            }

           
            function redirectToEventInsert() {
            	window.history.back();
            }
        </script>
    </c:if>
</html>