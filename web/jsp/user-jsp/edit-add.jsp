<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/10/2022
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/update">
    <c:set var="user" value="${user}"/>
    <input hidden value="${user.id}" id="name" name="id">
    <label for="name">first name:</label>
    <input value="${user.firstName}" type="text" id="name" name="firstName"><br><br>
    <label for="price">last name:</label>
    <input value="${user.lastName}" type="text" id="price" name="lastName"><br><br>
    <br>
    <input type="submit">


</form>




</body>
</html>
