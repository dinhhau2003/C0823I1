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
            <h1 style="text-align: center;">Chỉnh sửa product</h1>
        </div>
        <form action="/product" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${product.id_product}"/>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="name">Ten product<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="name" id="name" value="${product.name}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="gia">giá<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="gia" id="gia" value="${product.gia}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="soLuong">số lượng<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="soLuong" id="soLuong" value="${product.soLuong}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="color">color<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="color" id="color" value="${product.color}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="moTa">mô tả<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="moTa" id="moTa" value="${product.moTa}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="category">Tên category</label>
                        <select id="category" class="form-control" name="idCategory">
                            <c:forEach var="c" items="${categories}">
                                <c:choose>
                                    <c:when test="${c.id_category == product.id_category}">
                                        <option value="${c.id_category}" selected> ${c.ten_danh_muc}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${c.id_category}">${c.ten_danh_muc}</option>
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
                    <a type="button" class="btn btn-primary" href="/product?action=list">Quay lại</a>
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
