<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/11/2022
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>show-course</title>
</head>
<body>

<div class="card text-center">
    <c:set var="cours" value="${course}"/>
    <div class="card-header">
       Selected
    </div>
    <div class="card-body">
        <h5 class="card-title">${cours.name}</h5>
        <p class="card-text">${cours.description}</p>
        <p class="card-text">active: ${cours.active}</p>
        <p class="card-text">author:
            <c:forEach var="author" items="${cours.author}">

                <span>${author.lastName} ${author.firstName}</span>
            </c:forEach>
        </p>
        <a href="/courses/show" class="btn btn-primary">MAIN</a>
    </div>

</div>

</body>
</html>