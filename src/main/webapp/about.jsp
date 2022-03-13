<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/15/2022
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <li><a href="index.jsp">main</a></li>
                    <li><a href="about.jsp" class="active">about</a></li>
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
            <li><a href="about.jsp" class="active">about</a></li>
            <li><a href="index.jsp">main</a></li>
        </ul>
    </nav>
</header><!--End of id="headerWrapper"-->
<div id = "aboutPage">
    <h3>WHAT IS SOS?</h3>
    <h1>SOCIAL BATTLE ROYAL GAME</h1>
    <div class="aboutText">
        <P class="textP">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Dolorem veritatis nulla magni asperiores inventore dicta aspernatur debitis ut hic tenetur adipisci minus iste voluptatum quod at, eveniet consequuntur rem incidunt!</P>

    </div>
    <div class="aboutImages">
        <img id="img3" src ="img/img3.png" alt="image">
        <img id="img2" src ="img/img2.png" alt="image">
        <img id="img1" src ="img/img1.png" alt="image">
    </div>
    <div id = "switchdiv">
        <img id="switch" src ="img/switch.png" alt="image">
    </div>
    <div id = "imgConteiner">
        <img id="circle0" class="active" src ="img/circle (2).png" alt="image">
        <img id="circle1" src ="img/circle (2).png" alt="image">
        <img id="circle2" src ="img/circle (2).png" alt="image">
        <img id="circle3" src ="img/circle (2).png" alt="image">
        <img id="circle4" src ="img/circle (2).png" alt="image">
    </div>
</div>

<footer>
    <p>© 2021 Arman Melqonian, Inc. All Rights Reserved</p>
    <div class="social">
        <a href="#"><img id="social1" src ="img/twitter.png" alt="image"></a>
        <a href="#"><img id="social2" src ="img/twitch.png" alt="image"></a>
        <a href="#"><img id="social3" src ="img/facebook.png" alt="image"></a>
    </div>
</footer>

<script src="js/jquery-3.6.0.min.js"></script>
<script>
    $(".showMore").click(function(){
        if ($(".textP").css('display') == 'none'){
            $(".textP").css("display", "block");
            $(".showMore").css("top", $(".textP").height()+30+"px");
            $(".showMore").text("Show less");
        }
        else {
            $(".textP").css("display", "none");
            $(".showMore").css("top", 0+"px");
            $(".showMore").text("Show more");
        }
    })

</script>
</body>
</html>