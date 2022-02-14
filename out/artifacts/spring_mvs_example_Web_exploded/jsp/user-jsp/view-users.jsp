<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/10/2022
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USERS</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body class="container">
<a class="btn btn-primary m4"
   href="<c:url value="/jsp/user-jsp/add.jsp"/>">
    ADD
</a>

<br>
<br>
<br>

<table class="mt-4 table table-striped">
    <tr>
        <th>full name</th>
        <th>edit</th>
        <th>delete</th>

    </tr>

    <c:forEach var="user" items="${userList}">

        <tr>
            <td>
                <a href="/user/show/${user.id}">
                    <span>${user.firstName} ${user.lastName}</span>
                </a>
            </td>

            <td>
                <a
                        href="<c:url value="/user/edit/${user.id}"/>">
                    edit
                </a>
            </td>
            <td>
                <a href="<c:url value="/user/delete/${user.id}"/>">
                    delete
                </a>
            </td>
        </tr>

    </c:forEach>

</table>

<br>
<br>
<br>

</body>
</html>
