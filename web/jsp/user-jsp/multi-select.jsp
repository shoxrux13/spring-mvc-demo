<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/js/bootstrap-multiselect.min.js">
    </script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/css/bootstrap-multiselect.css"/>
</head>
<body>
<form action="/courses/add">
    <div class="container">
        <h2>Bootstrap Multiselect</h2>
        <select id="mltislct" multiple="multiple">
            <option value="Bootstrap" name="first"> Bootstrap</option>
            <option value="Angular" name="second"> Angular</option>
            <option value="JavaScript" name="third"> JavaScript</option>
            <option value="jquery" name="fourth"> jquery</option>
        </select>
        <input type="submit">
    </div>
</form>
<script>
    $(document).ready(function () {
        $('#mltislct').multiselect();
    });
</script>
</body>
</html>