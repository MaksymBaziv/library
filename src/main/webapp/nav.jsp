<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header-dark">
    <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
        <div class="container">
            <a class="navbar-brand" href="/library">Library</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Books</a>
                        <div class="dropdown-menu" role="menu">
                            <c:if test="${!empty sessionScope.loginedUser.userRole}">
                                <a class="dropdown-item" href="<c:url value="/newBook"/>">New</a>
                                <div class="dropdown-divider"></div>
                            </c:if>
                            <a class="dropdown-item" href="/library">All</a>
                        </div>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Authors</a>
                        <div class="dropdown-menu" role="menu">
                            <c:if test="${!empty sessionScope.loginedUser.userRole}">
                                <a class="dropdown-item" href="<c:url value="/author.jsp"/>">New</a>
                                <div class="dropdown-divider"></div>
                            </c:if>
                        </div>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Publishers</a>
                        <div class="dropdown-menu" role="menu">
                            <c:if test="${!empty sessionScope.loginedUser.userRole}">
                                <a class="dropdown-item" href="<c:url value="/publisher.jsp"/>">New</a>
                                <div class="dropdown-divider"></div>
                            </c:if>
                        </div>
                    </li>
                </ul>
            </div>
                <c:choose>
                    <c:when test="${!empty sessionScope.loginedUser.userRole}">
                        <span class="navbar-text">
                            <a href="<c:url value="/profile"/>" class="login">Profile</a>
                        </span>&nbsp
                        <a class="btn btn-light action-button" role="button" href="<c:url value="/logout"/>">Logout</a></div>
                    </c:when>
                    <c:otherwise>
                        <span class="navbar-text">
                            <a href="<c:url value="/login.jsp"/>" class="login">Login</a>
                        </span>&nbsp
                        <a class="btn btn-light action-button" role="button" href="<c:url value="/registration.jsp"/>">Register</a></div>
                    </c:otherwise>
                </c:choose>
        </div>
    </nav>
</div>