<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 20/03/2024
  Time: 6:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="../layout/head.jsp"></c:import>
<c:import url="../layout/navbar.jsp"></c:import>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang thêm mới</h1>
<form action="/customer?action=add" method="post">
    <input name="id" placeholder="Enter id">
    <input name="name" placeholder="Enter name">
    <input name="email" placeholder="Enter email">
    <input name="address" placeholder="Enter address">
    <button>Save</button>
</form>

</body>
</html>
