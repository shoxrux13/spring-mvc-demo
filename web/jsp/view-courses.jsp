<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/9/2022
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Courses</title>

</head>
<body class="container">
<br>
<a  href="<c:url value="/user/adduser"/>" class="btn btn-primary m4">+ Add course</a>
<br>
<br>
<table class="table table-hover">
    <tr>
        <th>name</th>
        <th>
            <a style="color: black" href="/user/show">
                author
            </a>
        </th>
        <th>price</th>
        <th>status</th>
        <th>edit</th>
        <th>delete</th>
    </tr>

    <c:forEach var="course" items="${courseList}">
        <tr>
            <td>
                <a href="<c:url value="/courses/showCurseById/${course.id}"/>" > ${course.name}</a>
            </td>

            <td >
                <c:if test="${course.author!=null}">
                    <c:forEach var="author" items="${course.author}">
                        <a href="<c:url value="/user/show/${author.id}"/>" >
                            <span>${author.firstName} ${author.lastName}  </span>
                        </a>


                    </c:forEach>
                </c:if>
            </td>

            <c:if test="${course.author==null}">
            <td>

                <span>   </span>

                </c:if>
            </td>
            <td>${course.price}</td>
            <td>${course.active}</td>
            <td>
                <a class="btn btn-primary" href="<c:url value="/courses/edit/${course.id}"/>">
                    edit </a>
            </td>
            <td><a class="btn btn-danger" href="<c:url value="/courses/delete/${course.id}"/>">
                delete
            </a></td>
        </tr>
    </c:forEach>

</table>

<br>
<br>
<br>


</body>
</html>