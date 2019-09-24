<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="head.jsp" %>
    <%--<link rel="stylesheet" href="<c:url value="/assets/css/Bitter-font.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/assets/css/Header-Dark.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/assets/css/lightbox.min.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/assets/css/Lightbox-Gallery.css"/>">--%>
    <link rel="stylesheet" href="<c:url value="/assets/css/Registration-Form-with-Photo.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/styles.css"/>">
</head>
<body>

<%@include file="nav.jsp" %>

<div class="container">
    <%--<div class="row">--%>
    <div class="register-photo">
        <div class="form-container">
            <div class="image-holder"></div>
            <form action="register" method="post">
                <h2 class="text-center">
                    <strong>Create</strong> an account.
                </h2>
                <c:if test="${param.error eq 'email'}">
                    <div class="alert alert-danger" role="alert">
                        Email already registered
                    </div>
                </c:if>
                <c:if test="${param.error eq 'password'}">
                    <div class="alert alert-danger" role="alert">
                        Passwords does not match
                    </div>
                </c:if>
                <div class="form-group">
                    <input required type="email"
                           class="form-control" id="Email" name="Email" placeholder="Email">
                </div>
                <div class="form-group">
                    <input required type="password" pattern=".{3,}" title="3 characters minimum"
                           class="form-control" id="Password" name="Password" placeholder="Password">
                </div>
                <div class="form-group">
                    <input required type="password" pattern=".{3,}" title="3 characters minimum"
                           class="form-control" id="RepeatPassword" name="RepeatPassword" placeholder="Password (repeat)">
                </div>
                <div class="form-group">
                    <input class="form-control" id="zipCode" name="zipCode" type="text" placeholder="Zip Code">
                </div>
                <button class="btn btn-primary btn-block" type="submit">Sign Up</button>
            </form>
        </div>
    </div>

    <%--</div>--%>
</div>
<script src="<c:url value="/assets/js/jquery.min.js"/>"></script>
<%--<script src="<c:url value="/assets/js/lightbox.min.js"/>"></script>--%>
</body>
</html>