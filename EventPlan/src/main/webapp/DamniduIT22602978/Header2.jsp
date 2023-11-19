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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"/>
<link rel="stylesheet" href="DamniduIT22602978/css/stylesheetT1.css">



    <title>Event Aliens</title>
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
                        <a href="DamniduIT22602978/Profile.jsp" class="navTlink ">
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
                ExquisiteEvent
            </a>
            <div class="headerTtoggle" id="headerT-toggle">
                <i class='bx bxs-right-arrow' ></i>
            </div>
           </nav> 
        </header>
        <section class="sectionT container " id="home">
            <div class="swiper mySwiper1">
                <div class="swiper-wrapper">
                <div class="swiper-slide"><img src="DamniduIT22602978/img/event1.jpg" alt="img1">
                <div class="inputone" >
                    <h1>Wedding Occasions</h1>
                    <p>
                        You can Recieve the Hotels For Your Specail day 
                        So,Come and Do your specail day memorable.!
                    </p>
                </div> </div>
                <div class="swiper-slide"><img src="DamniduIT22602978/img/event 2.jpg" alt="img2">
                    <div class="inputone" >
                        <h1>Socials</h1>
                        <p>
                            You can Recieve us For Your Specail Social Events 
                            So,Come and Do your specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide"><img src="DamniduIT22602978/img/event3.jpg" alt="img3">
                    <div class="inputone" >
                        <h1>Conference Meetings</h1>
                        <p>
                            You can Recieve Us For Your Specail Conference Meetings 
                            So,Come and Succes Your day.!
                        </p>
                    </div></div>
                <div class="swiper-slide"><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                    <div class="inputone" >
                        <h1>Birthday celebrations </h1>
                        <p>
                            You can Recieve Us For Your Birthday celebrations 
                            So,Come and happy your Loving Ones.!
                        </p>
                    </div></div>
                <div class="swiper-slide"><img src="DamniduIT22602978/img/event5.jpg" alt="img5">
                    <div class="inputone" >
                        <h1>Musical Festivals</h1>
                        <p>
                            You can Recieve Us And Success Your Event
                            So,Come and Do your specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide"><img src="DamniduIT22602978/img/event6.jpg" alt="img6">
                    <div class="inputone" >
                        <h1>Dinner Dance</h1>
                        <p>
                            You can Recieve the Hotels For Your Specail day 
                            So,Come and Do your specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide"><img src="DamniduIT22602978/img/event7.jpg" alt="img7">
                    <div class="inputone" >
                        <h1>Special Occasions</h1>
                        <p>
                            You can Recieve the Hotels For Your Specail day 
                            So,Come and Do your specail day memorable.!
                        </p>
                    </div></div>
            </div>
            </div>
        </section>
        
        <section class="sectionT container sectionTheight" id="packages">
            <h1>Packages</h1>
            <div class="swiper mySwiper2">
                <div class="swiper-wrapper">
                <div class="swiper-slide">
                <div class="inputone1" ><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                    <h1>Wedding Packages</h1>
                    <p>
                        You can Recieve the <br>Hotels For Your Specail day 
                        So,Come and Do your <br>specail day memorable.!
                    </p>
                </div> </div>
                <div class="swiper-slide">
                    <div class="inputone1" ><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                        <h1>Socials Package</h1>
                        <p>
                            You can Recieve the <br>Hotels For Your Specail day 
                            So,Come and Do your <br>specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide">
                    <div class="inputone1" ><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                        <h1>Photography Packages</h1>
                        <p>
                            You can Recieve the <br>Hotels For Your Specail day 
                            So,Come and Do your <br>specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide">
                    <div class="inputone1" ><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                        <h1>Birthday celebrations Packages </h1>
                        <p>
                            You can Recieve the <br>Hotels For Your Specail day 
                            So,Come and Do your <br>specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide">
                    <div class="inputone1" ><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                        <h1>Catering Packages</h1>
                        <p>
                            You can Recieve the <br>Hotels For Your Specail day 
                            So,Come and Do your <br>specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide">
                    <div class="inputone1" ><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                        <h1>Dinner Dance Packages</h1>
                        <p>
                            You can Recieve the <br>Hotels For Your Specail day 
                            So,Come and Do your <br>specail day memorable.!
                        </p>
                    </div></div>
                <div class="swiper-slide">
                    <div class="inputone1" ><img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                        <h1>Special Occasions Packages</h1>
                        <p>
                            You can Recieve the <br>Hotels For Your Specail day 
                        So,Come and Do your <br>specail day memorable.!
                        </p>
                    </div></div>
            </div>
            </div>
        </section>
        <section class="sectionT container " id="About">
            <h1>ABOUT</h1>
            <div class="swiper">
                <div class="about-containt">
                   <div class="about-img">
                    <img src="DamniduIT22602978/img/event4.jpg" alt="img4">
                    <form action="" method="post">
                        <input type="submit" value="Contact Us">
                    </form>
                   </div>
                   <div class="containt">
                    <h1>We Will Make Your Special Day Memorable!</h1>
                    <p>gdjdkdkdnnd shsjkkdndbsjdkdkdddlklsldddk jhsksdnsdkdksdds 
                        ghjsdksdksdlkdsldllds sjsdksdkdsldslldlsd sksdkklsdldsldsl
                        gdjdkdkdnnd shsjkkdndbsjdkdkdddlklsldddk jhsksdnsdkdksdds 
                        ghjsdksdksdlkdsldllds sjsdksdkdsldslldlsd sksdkklsdldsldsl
                        gdjdkdkdnnd shsjkkdndbsjdkdkdddlklsldddk jhsksdnsdkdksdds 
                        ghjsdksdksdlkdsldllds sjsdksdkdsldslldlsd sksdkklsdldsldsl
                        gdjdkdkdnnd shsjkkdndbsjdkdkdddlklsldddk jhsksdnsdkdksdds 
                        ghjsdksdksdlkdsldllds sjsdksdkdsldslldlsd sksdkklsdldsldsl
                        gdjdkdkdnnd shsjkkdndbsjdkdkdddlklsldddk jhsksdnsdkdksdds 
                        ghjsdksdksdlkdsldllds sjsdksdkdsldslldlsd sksdkklsdldsldsl

                    </p>
                </div>
                </div>
            </div>
        </section>
        <section class="sectionT container sectionTheight" id="gallery">
            <h1>GALLERY</h1>
            <div class="swiper mySwiper3">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                    <img src="DamniduIT22602978/img/event5.jpg" alt="img5">
                </div>
                <div class="swiper-slide">
                    <img src="DamniduIT22602978/img/event5.jpg" alt="img5">
                </div>
                <div class="swiper-slide">
                    <img src="DamniduIT22602978/img/event5.jpg" alt="img5">
                </div>
                <div class="swiper-slide">
                    <img src="DamniduIT22602978/img/event5.jpg" alt="img5">
                </div>
                <div class="swiper-slide">
                    <img src="DamniduIT22602978/img/event5.jpg" alt="img5">
                </div>
                <div class="swiper-slide">
                    <img src="DamniduIT22602978/img/event5.jpg" alt="img5">
                </div>
                
            </div>
        </div>
        </section>
        <section class="sectionT container sectionTheight" id="team">
            <h1>TEAM</h1>
        </section>
        <section class="sectionT container sectionTheight" id="reviews">
            <h1>REVIEWS</h1>
        </section>
        
        


    </main>
    <!--main js-->
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <script src="DamniduIT22602978/Js/Main2.js"></script>
    
</body>
</html>