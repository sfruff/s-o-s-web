<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/15/2022
  Time: 3:48 PM
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
<div id = "subscribe">
    <div class="subscribeInfo">
        <h3>Want to stay in touch?</h3>
        <h1>newsletter SUBSCRIBE</h1>
        <P>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Dolorem veritatis nulla magni asperiores inventore dicta aspernatur debitis ut hic tenetur adipisci minus iste voluptatum quod at, eveniet consequuntur rem incidunt!</P>
        <div class="form-conteiner">
            <form action="" method ="GET">
                <ul>
                    <li><input type="email" placeholder="email"> <br><br></li>
                    <li><input type="button" value="SUBMIT"> <br><br></li>
                </ul>
            </form>
        </div>
    </div>
    <img id="img" src ="img/sub-img.png" alt="image">
    <!-- <img id="img" src ="img/sub-img-re.png" alt="image"> -->
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
