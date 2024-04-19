<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 17/04/2024
  Time: 6:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<table>
<tr>
  <th>STT</th>
  <th>ID</th>
  <th>Name</th>
</tr>
<c:forEach items="${students}" var="student" varStatus="status">
  <tr>
    <td>${status.count}</td>
    <td>${student.id}</td>
    <td>${student.name}</td>
    <td><a href="/student/detail?id=${student.id}">Detail</a></td>
    <td><a href="/student/detail/${student.id}">Detail</a></td>

  </tr>
</c:forEach>
</table>
</body>
</html>
