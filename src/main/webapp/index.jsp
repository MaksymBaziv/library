<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="head.jsp" %>
    <style>
        .img-height {
            min-height: 300px;

        }

        body {
            background-color: light !important;
        }
    </style>
</head>
<body>

<%@include file="nav.jsp" %>

<div class="container">
    <div class="row">
        <c:forEach var="item" items="${books}">
            <div class="col-sm-3">
                <div class="card">
                    <img src="data:image/jpeg;base64,${item.imageBase64}" class="card-img-top img-height" alt="">
                    <div class="card-body">
                        <a href="<c:url value="/bookView?id=${item.id}"/>" class="btn btn-warning btn-block">View
                            book: ${item.name}</a>
                        <c:if test="${'admin' eq sessionScope.loginedUser.userRole || item.createdBy eq sessionScope.loginedUser.id}">
                            <a href="<c:url value="/bookEdit?id=${item.id}"/>" class="btn btn-warning btn-block">Edit
                                book: ${item.name}</a>
                        </c:if>
                        <c:if test="${'admin' eq sessionScope.loginedUser.userRole || item.createdBy eq sessionScope.loginedUser.id}">
                            <a href="<c:url value="/delete?id=${item.id}"/>" class="btn btn-danger btn-block">Delete</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>