
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action="/students/create" method="post">--%>
<%--    <input name="id" placeholder="enter id">--%>
<%--    <input name="name" placeholder="enter name">--%>
<%--    <button>Save</button>--%>
<%--</form>--%>
<form:form action="/students/create" method="post" modelAttribute="student">
    ID:
    <form:input path="id"/><br>
    Name:
    <form:input path="name"/><br>
    Gender:
    <form:radiobutton path="gender" value="true"/>Male
    <form:radiobutton path="gender" value="false"/>Female<br>
    Languages:
    <form:checkboxes path="languages" items="${languages}"/><br>
    Class ID:
    <form:select path="classId">
    <form:option value="1"> C03</form:option>
    <form:option value="2"> C04</form:option>
    <form:option value="3"> C05</form:option>
    </form:select><br>
    <form:button>Save</form:button>
</form:form>

</body>
</html>
