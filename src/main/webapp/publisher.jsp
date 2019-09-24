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
            <form action="savePublisher" method="post">
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="name" id="name" placeholder="Name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="city" class="col-sm-2 col-form-label">City</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="city" id="city" placeholder="City">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="phoneNumber" class="col-sm-2 col-form-label">Phone number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"
                               placeholder="Phone number">
                    </div>
                </div>
                <input type="submit" class="btn btn-success" value="Save"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
