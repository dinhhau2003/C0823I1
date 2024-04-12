<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 22/03/2024
  Time: 6:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/phone" >
  <input type="hidden" name="action" value="create">
  <input type="hidden" placeholder="id" name="id">
  <p>Name</p>
  <input type="text" placeholder="name" name="name">
  <p>Price</p>
  <input type="text" placeholder="price" name="price">
  <p>Type</p>
  <input type="text" placeholder="id_danh_muc" name="id_danh_muc">
  <input type="submit" value="Thêm Mới">
</form>
</body>
</html>
