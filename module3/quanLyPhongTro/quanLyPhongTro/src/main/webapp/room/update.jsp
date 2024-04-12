<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap-5.2.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/fontawesome-free-5.15.4-web/css/all.min.css">
</head>
<body>
<%@ include file="/header.jsp" %>
<br>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <h1 style="text-align: center;">Chỉnh sửa </h1>
        </div>
        <form action="/room" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${room.id}"/>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="name">Ten <span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="name" id="name" value="${room.name}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="phone">Phone<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="phone" id="phone" value="${room.phone}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="day">Day<span style="color: red">*</span></label>
                        <input type="date" class="form-control" name="day" id="day" value="${room.day}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="idThanhToan">Tên category</label>
                        <select id="idThanhToan" class="form-control" name="idThanhToan">
                            <c:forEach var="c" items="${pays}">
                                <c:choose>
                                    <c:when test="${c.id == room.idThanhToan}">
                                        <option value="${c.id}" selected> ${c.tenThanhToan}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${c.id}">${c.tenThanhToan}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <button type="submit" class="btn btn-primary">Update</button>
                    <a type="button" class="btn btn-primary" href="/room?action=list">Quay lại</a>
                </div>
            </div>

        </form>
    </div>
</div>
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/jquery/popper.min.js"></script>
<script src="/static/bootstrap-5.2.3-dist/js/bootstrap.min.js"></script>
<script src="/static/bootstrap-5.2.3-dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
