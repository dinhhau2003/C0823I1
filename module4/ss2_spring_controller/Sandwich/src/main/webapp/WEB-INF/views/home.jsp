<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 17/04/2024
  Time: 7:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/spices/save" method="post">
  <input type="checkbox" name="condiment" value="Lettuce">Lettuce
  <input type="checkbox" name="condiment" value="Tomato">Tomato
  <input type="checkbox" name="condiment" value="Mustard">Mustard
  <input type="checkbox" name="condiment" value="Sprout">Sprout
  <input type="submit" value="Save">
</form>

</body>
</html>
