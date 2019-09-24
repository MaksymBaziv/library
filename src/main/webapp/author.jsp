<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="nav.jsp" %>
<div class="container">
    <div class="register-photo">
        <div class="form-container">
            <form action="saveAuthor" method="post">
                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="firstName" id="firstName"
                               placeholder="First Name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last Name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="about" class="col-sm-2 col-form-label">About</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" id="about" name="about" rows="3"></textarea>
                    </div>
                </div>
                <input type="submit" class="btn btn-success" value="Save"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
