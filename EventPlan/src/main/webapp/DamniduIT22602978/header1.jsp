<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--boxicons-->
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <!--css-->
<link rel="stylesheet" href="css/stylesheetT.css">



    <title>Home page</title>
</head>
<body>
    <!--NAV-->
    <nav class="navT" id="navT">
        <div class="navTmenu container" id="navT-menu">
            <div class="navTshape"></div>
            <div class="navTclose" id="navT-close">
                <i class='bx bxs-left-arrow' ></i>
            </div>
            <div class="navTdata">
                
                <span class="navTgreeting">Hi,</span>
                <h1 class="navTname"><%=session.getAttribute("username") %></h1>
            </div>
        
                <ul class="navTlist">
                    <li class="navTitem">
                        <a href="#home" class="navTlink active-link">
                            <i class='bx bxs-home-heart' ></i>Home
                        </a>
                    </li>
                    <li class="navTitem">
                        <a href="Profile.jsp" class="navTlink ">
                            <i class='bx bxs-user' ></i>Profile 
                        </a>
                    </li>
                    <li class="navTitem">
                        <a href="#packages" class="navTlink active-link">
                            <i class='bx bxs-briefcase-alt-2'></i>Packages   
                        </a>
                    </li>
                    <li class="navTitem">
                        <a href="#About" class="navTlink active-link">
                            <i class='bx bx-bookmark-heart' ></i>About Us
                        </a>
                    </li>
                    <li class="navTitem">
                        <a href="#gallery" class="navTlink active-link">
                            <i class='bx bx-folder'></i>Gallery
                        </a>
                    </li>
                    <li class="navTitem">
                        <a href="#team" class="navTlink active-link">
                            <i class='bx bx-group'></i> Team 
                        </a>
                    </li>
                    <li class="navTitem">
                        <a href="#reviews" class="navTlink active-link">
                            <i class='bx bxs-message-square-dots'></i>Reviews
                        </a>
                    </li>
                    <li class="navTitem">
                        <a href="#contact" class="navTlink active-link">
                            <i class='bx bxs-contact'></i>Contact Us
                        </a>
                    </li>

                </ul>
                <div class="navTsignin " id="navT-signin">
                <a href="login.jsp">
	
                    <button >Log Out<i class='bx bxs-log-out-circle' ></i></button></a>
                </div>
            
        </div>

        

    </nav>



    <!--main-->
    <main class="mainT" id="mainT">
        <!--header-->
        <header class="headerT" id="headerT">
           <nav class="headerTnav container">
            <a href="#" class="headerTlogo">
               EXquisite Planners
            </a>
            <div class="headerTtoggle" id="headerT-toggle">
                <i class='bx bxs-right-arrow' ></i>
            </div>
           </nav> 
        </header>
        <section class="sectionT container sectionTheight" id="home">