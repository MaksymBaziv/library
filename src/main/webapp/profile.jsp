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

<div class="container">
    <form>
        <div class="well col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
            <div class="row user-row">
                <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".cyruxx">
                    <i class="glyphicon glyphicon-chevron-down text-muted"></i>
                </div>
            </div>
            <div class="row user-infos cyruxx">
                <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">User information</h3>
                        </div>
                        <div class="row">
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <dt>Registered email:</dt>
                                <input type="text" name="email"
                                       id="email" value="${user.email}"/>
                                <dt>User level:</dt>
                                <input type="text" name="userRole"
                                       id="userRole" value="${user.userRole}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>