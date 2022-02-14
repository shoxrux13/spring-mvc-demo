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
    <title>Edit course</title>
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

    <form style="width: 500px; margin: 0 auto;" action="/courses/update">


        <div class="form-group" style="margin-top:30px">
            <label for="name">Name</label>
            <input class="form-control" type="text" name="name" id="name" value="${cours.name}">
        </div>

        <div class="form-group" style="margin-top:30px">
            <label>Price</label>
            <input class="form-control" type="number" name="price" value="${cours.price}"/>
        </div>

        <div class="form-group" style="margin-top:30px">
            <label class="form-label" for="textAreaExample">Description</label>
            <textarea class="form-control" id="textAreaExample" name="description"  rows="4">
             ${cours.description}
            </textarea>

        </div>
        <c:set var="cours" value="${course}"/>
        <input type="hidden" name="id" value="${course.id}" />
        <br>
        <div class="form-check">
            <input class="form-check-input"  name="active" <c:if test="${course.active==true}">checked</c:if> type="checkbox" id="vehicle2">
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

        <button type="submit" class="btn btn-primary" value="save" style="margin-top:30px">Save</button>
        <a href="/courses/show" class="btn btn-danger" style="margin-top:30px; margin-left:15px">Back</a>
    </form>

    <script>


        $(document).ready(function () {
            $('#mltislct').multiselect();
        });
    </script>
</div>
</body>
</html>


