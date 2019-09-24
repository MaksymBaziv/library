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
    <form action="saveBook" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" placeholder="Name">
            </div>
        </div>
        <div class="form-group row">
            <label for="pages" class="col-sm-2 col-form-label">Pages</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="pages" id="pages"
                       placeholder="Pages">
            </div>
        </div>
        <div class="form-group row">
            <label for="yearOfPublication" class="col-sm-2 col-form-label">Year of publication</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="yearOfPublication"
                       id="yearOfPublication"
                       placeholder="Year of publication">
            </div>
        </div>
        <div class="form-group row">
            <label for="price" class="col-sm-2 col-form-label">Price</label>
            <div class="col-sm-10">
                <input value="${book.price}" type="text" class="form-control" name="price"
                       id="price"
                       placeholder="Price">
            </div>
        </div>
        <div class="form-group row">
            <label for="authorId" class="col-sm-2 col-form-label">Select Author</label>
            <div class="col-sm-10">
                <select class="custom-select" name="authorId" id="authorId">
                    <c:forEach var="item" items="${authors}">
                        <option value="${item.id}">${item.firstName} ${item.lastName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="publisherId" class="col-sm-2 col-form-label">Select Publisher</label>
            <div class="col-sm-10">
                <select class="custom-select" name="publisherId" id="publisherId">
                    <c:forEach var="item" items="${publishers}">
                        <option value="${item.id}" >${item.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="description" name="description"
                          rows="3"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="selectImage">Select image</label>
            <input type="file" class="form-control-file" name="selectImage" id="selectImage">
        </div>
        <input type="submit" class="btn btn-success" value="Save"/>
    </form>
</div>
</body>
</html>
