<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/18/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%
    if (session.getAttribute("userId") != null && session.getAttribute("username") != null){
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>


<c:set var="userIdErrorMessage" value="${errorMessages.userId}"/>
<c:set var="passwordErrorMessage" value="${errorMessages.password}"/>
<c:set var="generalErrorMessage" value="${errorMessages.general}"/>
<%--<%--%>
<%--    Map<String,String> errorMassages = (Map<String, String>) request.getAttribute("errorMessages");--%>
<%--    String userIDErrorMassage = null;--%>
<%--    String passwordErrorMassage = null;--%>
<%--    String generalErrorMassage = null;--%>
<%--    if (errorMassages != null){--%>
<%--        userIDErrorMassage = errorMassages.get("userId");--%>
<%--        passwordErrorMassage = errorMassages.get("password");--%>
<%--        generalErrorMassage = errorMassages.get("general");--%>
<%--    }--%>
<%--%>--%>
<header id="header" > <!--id="headerWrapper" style="background:pink;"-->
    <h1><a href="index.jsp">logo</a></h1>
    <!-- <p><img src="images/a.png" alt="image description" /></p> -->

    <div class="mobile-menu">
        <div class="dropdown">
            <img src="img/mobile-menu.png" alt="manu">
            <div class="dropdown-content">
                <ul id="mobile-menu-iu">
                    <li><a href="index.jsp">main</a></li>
                    <li><a href="about.jsp">about</a></li>
                    <li><a href="login.jsp" class="active">Log in</a></li>
                </ul>
            </div>
        </div>
    </div>

    <nav class="mainNav">
        <ul id="meniu">
            <li><a href="login.jsp" class="active">Log in</a></li>
            <li><a href="about.jsp">about</a></li>
            <li><a href="index.jsp">main</a></li>
        </ul>
    </nav>
</header><!--End of id="headerWrapper"-->
<div class="sign">
    <form action="login-servlet" method="post">
        <ul>
            <c:if test="${generalErrorMessage != null}">
                <div class="alert alert-danger mt-2" role="alert" style="color: #ffa9a8">
                    <c:out value="${generalErrorMessage}" />
                </div>
            </c:if>
            <li><input type="number" name="userid" placeholder="your ID" min="0" max="10000000000"></li>
                <c:if test="${userIdErrorMessage != null}">
                    <li style="height: 20px"><p class="form-text text-danger" style="color: #ffa9a8"><c:out value="${userIdErrorMessage}" /></p></li>
                </c:if>
            <li><input type="password" name="password" placeholder="Password"></li>
                <c:if test="${passwordErrorMessage != null}">
                    <li style="height: 20px"><p class="form-text text-danger" style="color: #ffa9a8"><c:out value="${passwordErrorMessage}" /></p></li>
                </c:if>
            <li><input type="submit" name="submit" value="Log in"></li>
            <li><h3>Don't have an account? <a href="registration.jsp">Sign up</a></h3></li>
        </ul>
    </form>
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
<?php
}
?>
