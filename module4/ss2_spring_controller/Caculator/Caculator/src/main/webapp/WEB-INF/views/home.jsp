<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 19/04/2024
  Time: 6:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Caculator</h3>
<form action="/home/caculator" method="post">
    <div>
        <input type="text" name="firstNumber">
        <input type="text" name="secondNumber">
    </div>
    <br>
    <div>
        <input type="submit" name="operation" value="Addition(+)">
        <input type="submit" name="operation" value="Subtraction(-)">
        <input type="submit" name="operation" value="Multiplication(*)">
        <input type="submit" name="operation" value="Division(/)">
    </div>
</form>
<br>
<p>Result: ${result}</p>
</body>
</html>
