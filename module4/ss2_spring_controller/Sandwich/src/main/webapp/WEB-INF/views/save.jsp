<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 17/04/2024
  Time: 7:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Save Page</title>
</head>
<body>
<h1>Selected Condiments</h1>
<c:forEach items="${condiment}" var="condimentItem">
    <p>${condimentItem}</p>
</c:forEach>
</body>
</html>

