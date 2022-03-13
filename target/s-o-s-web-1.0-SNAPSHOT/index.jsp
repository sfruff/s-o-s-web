<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/style.css">

    <title>Document</title>
</head>
<body>
<header id="header" > <!--id="headerWrapper" style="background:pink;"-->
    <h1><a href="index.jsp">logo</a></h1>
    <!-- <p><img src="images/a.png" alt="image description" /></p> -->

    <div class="mobile-menu">
        <div class="dropdown">
            <img src="img/mobile-menu.png" alt="manu">
            <div class="dropdown-content">
                <ul id="mobile-menu-iu">
                    <li><a href="index.jsp" class="active">main</a></li>
                    <li><a href="about.jsp">about</a></li>
                    <%
                        if (session.getAttribute("userId") != null && session.getAttribute("username") != null){%>
                    <li><a href='logout'>Log out</a></li>
                    <%
                    }else {
                    %>
                    <li><a href='login.jsp'>Log in</a></li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>

    <nav class="mainNav">
        <ul id="meniu">
    <%
        if (session.getAttribute("userId") != null && session.getAttribute("username") != null){%>
        <li><a href='logout'>Log out</a></li>
    <%
        }else {
    %>
        <li><a href='login.jsp'>Log in</a></li>
    <%
        }
    %>
        <li><a href="about.jsp">about</a></li>
        <li><a href="index.jsp" class="active">main</a></li>
        </ul>
    </nav>
</header><!--End of id="headerWrapper"-->
<div id = "mainPage">
    <h1>SURVIVE AT ALL COSTS</h1>
    <h3>EXPERIENCE NEW SOCIAL BATTLE ROYALE GAME</h3>
    <a href="#" id="online"><h5>PLAY ONLINE</h5></a>
    <a href="subscribe.jsp" id="subscribe"><h5>NEWSLETTER SUBSCRIBE</h5></a>
</div>


<footer>
    <p>© 2021 Arman Melqonian, Inc. All Rights Reserved</p>
    <div class="social">
        <a href="#"><img id="social1" src ="img/twitter.png" alt="image"></a>
        <a href="#"><img id="social2" src ="img/twitch.png" alt="image"></a>
        <a href="#"><img id="social3" src ="img/facebook.png" alt="image"></a>
    </div>
</footer>


</body>
</html>