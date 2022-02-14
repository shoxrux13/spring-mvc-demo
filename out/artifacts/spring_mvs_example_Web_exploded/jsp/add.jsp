<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/10/2022
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add course</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/js/bootstrap-multiselect.min.js">
    </script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/css/bootstrap-multiselect.css"/>

</head>
<body>
<div class="container">

    <form style="width: 500px; margin: 0 auto;" action="/courses/add">
        <c:set var="cours" value="${course}"/>
        <div class="form-group" style="margin-top:30px">
            <label for="name">Name</label>
            <input type="text" id="name" class="form-control" name="name" placeholder="Enter course name">
        </div>

        <div class="form-group" style="margin-top:30px">
            <label for="price">Price</label>
            <input type="number" id="price" class="form-control" name="price" placeholder="Enter price">
        </div>

        <div class="form-group" style="margin-top:30px">
            <label class="form-label" for="description">Description</label>
            <textarea class="form-control" ty id="description" name="description" ></textarea>

        </div>

        <div class="form-check">
            <input class="form-check-input" name="active" type="checkbox" id="vehicle2">
            <c:if test="${course.active==true}"> checked </c:if>
            <label class="form-check-label" for="vehicle2">
                Active
            </label>
        </div>


        <h2>Add authors</h2>
        <select id="mltislct" name="authorId" multiple="multiple">
            <c:forEach var="user" items="${userList}">
                <option value="${user.id}"> ${user.firstName}</option>
            </c:forEach>
        </select>



<input  class="btn btn-success" type="submit">
</form>



</form>
</div>

<script>


    $(document).ready(function () {
        $('#mltislct').multiselect();
    });
</script>
</body>
</html>
