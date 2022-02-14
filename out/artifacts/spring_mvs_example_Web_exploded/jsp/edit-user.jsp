<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/10/2022
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/courses/update">
    <c:set var="cours" value="${course}"/>
    <input hidden value="${course.id}" id="name" name="id">
    <label for="name">name:</label>
    <input value="${cours.name}" type="text" id="name" name="name"><br><br>
    <label for="price">price:</label>
    <input value="${cours.price}" type="number" id="price" name="price"><br><br>
    <input type="checkbox" id="vehicle2" name="active" <c:if test="${course.active==true}">checked</c:if>>
    <label for="vehicle2"> is completed</label><br>
    <input type="submit">
</form>







</body>
</html>
