<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/10/2024
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<p>${mess}</p>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Detail-RequestParam</th>
        <th>Detail-PathVariable</th>
    </tr>
    <c:forEach items="${studentList}" var="student"  varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td><a href="/students/detail?id=${student.id}">Detail</a></td>
            <td><a href="/students/detail/${student.id}">Detail</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
