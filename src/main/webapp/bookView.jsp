<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="head.jsp" %>
    <style>
        .img-height {
            display: block;
            max-width:300px;
            max-height:300px;
            width: auto;
            height: auto;
        }
    </style>
</head>

<body>
<%@include file="nav.jsp" %>
<div class="container">
    <form action="bookEdit" method="post" enctype="multipart/form-data">
        <input type="hidden" value="${book.id}" name="id">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input readonly value="${book.name}" type="text" class="form-control" name="name" id="name" placeholder="Name">
            </div>
        </div>
        <div class="form-group row">
            <label for="pages" class="col-sm-2 col-form-label">Pages</label>
            <div class="col-sm-10">
                <input readonly value="${book.pages}" type="text" class="form-control" name="pages" id="pages"
                       placeholder="Pages">
            </div>
        </div>
        <div class="form-group row">
            <label for="yearOfPublication" class="col-sm-2 col-form-label">Year of publication</label>
            <div class="col-sm-10">
                <input readonly value="${book.yearOfPublication}" type="text" class="form-control" name="yearOfPublication"
                       id="yearOfPublication"
                       placeholder="Year of publication">
            </div>
        </div>
        <div class="form-group row">
            <label for="price" class="col-sm-2 col-form-label">Price</label>
            <div class="col-sm-10">
                <input readonly value="${book.price}" type="text" class="form-control" name="price"
                       id="price"
                       placeholder="Price">
            </div>
        </div>
        <div class="form-group row">
            <label for="authorId" class="col-sm-2 col-form-label">Select Author</label>
            <div class="col-sm-10">
                <select readonly class="custom-select" name="authorId" id="authorId">
                    <c:forEach var="item" items="${authors}">
                        <option value="${item.id}" ${item.id == book.authorId ? 'selected' : ''} >${item.firstName} ${item.lastName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="publisherId" class="col-sm-2 col-form-label">Select Publisher</label>
            <div class="col-sm-10">
                <select readonly class="custom-select" name="publisherId" id="publisherId">
                    <c:forEach var="item" items="${publishers}">
                        <option value="${item.id}" ${item.id == book.publisherId ? 'selected' : ''} >${item.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <textarea readonly class="form-control" id="description" name="description"
                          rows="3">${book.description}</textarea>
            </div>
        </div>
        <div class="form-group row">
            <label for="image" class="col-sm-2 col-form-label">Image</label>
            <img src="data:image/jpeg;base64,${book.imageBase64}" class="col-sm-10 img-height" alt="" id="image">
        </div>
        <a href="/library" class="btn btn-info">Back</a>
    </form>
</div>
</body>
</html>
