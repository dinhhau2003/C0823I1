<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 26/04/2024
  Time: 7:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<h3 style="margin-bottom: 20px">Setting</h3>
<f:form modelAttribute="emailBox" method="post" action="/email/update">
    <table>
        <tr>
            <td><f:label path="language">Languages </f:label></td>
            <td>
                <f:select path="language">
                    <f:options items="${languages}"/>
                </f:select>
            </td>
        </tr>
        <tr>
            <td><br></td>
        </tr>
        <tr>
            <td><f:label path="pageSize">Page Size: </f:label></td>
            <td>Show <f:select path="pageSize">
                <f:options items="${size}"/>
            </f:select> emails per page
            </td>
        </tr>
        <tr>
            <td><br></td>
        </tr>
        <tr>
            <td><f:label path="spamFilter">Spams filter: </f:label></td>
            <td>
                <f:checkbox path="spamFilter" value="false"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <td><br></td>
        </tr>
        <tr>
            <td><f:label path="signature">Signature: </f:label></td>
            <td><f:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><br></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update" class="btn btn-warning"></td>
            <td><a href="/email" class="btn btn-primary">Cancel</a></td>
        </tr>
    </table>
</f:form>
</body>
</html>
