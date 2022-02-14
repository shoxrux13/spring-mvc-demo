<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/12/2022
  Time: 12:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<c:set var="user" value="${user}"/>
<c:set var="courses" value="${courses}"/>
<div class="d-flex justify-content-around">
    <div class="col-md-4 mt-4">
        <div class="card">
            <h5 class="card-title">${user.firstName} ${user.lastName}</h5>
            <p style="text-align: center" class="card-text">BIO</p>
            <p style="text-align: center" class="card-text">${user.bio}</p>
            <p class="card-text">courses</p>
            <c:forEach var="course" items="${courses}">
                <p>
                    <a href="<c:url value="/courses/showCurseById/${course.id}"/>">
                            ${course.name}
                    </a>
                </p>
            </c:forEach>

            <a href="<c:url value="/courses/show"/> " class="btn btn-primary">main</a>
        </div>
    </div>
</div>
</body>
</html>
