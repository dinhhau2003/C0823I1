<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 20/03/2024
  Time: 6:22 CH
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="../layout/head.jsp"></c:import>
<head>
    <title>Title</title>
</head>
<body>

<h1>Danh sách khách hàng</h1>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>email</th>
        <th>address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td>
                <button class="btn btn-sm btn-danger">Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
