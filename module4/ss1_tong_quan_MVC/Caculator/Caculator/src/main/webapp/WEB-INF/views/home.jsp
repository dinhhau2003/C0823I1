<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 15/04/2024
  Time: 6:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="caculator/result" method="post" >
    <table>
        <tr>
            <td>Tỉ giá: </td>
            <td><input type="text" name="rate" placeholder="tỉ giá"></td>
        </tr>
        <tr>
            <td>USD: </td>
            <td><input type="text" name="usd" placeholder="USD"></td>
        </tr>

    </table>
    <input type="submit" value="Chuyển đổi">
</form>
</body>
</html>
