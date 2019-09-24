<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="head.jsp" %>
    <link rel="stylesheet" href="<c:url value="/assets/css/login.css"/>">
</head>
<body>

<%@include file="nav.jsp" %>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form action="<c:url value="/login"/>" method="post">
            <input type="text" class="fadeIn first" id="Email" name="Email" placeholder="Enter email">
            <input type="password" class="fadeIn second" id="Password" name="Password" placeholder="Enter password">
            <c:if test="${!empty param.error}">
                <div class="alert alert-danger" role="alert">
                    Invalid email or password!
                </div>
            </c:if>
            <input type="submit" class="fadeIn third" value="Log In">
        </form>
    </div>
</div>
</body>
</html>