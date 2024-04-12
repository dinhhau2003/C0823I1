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
        <form action="/khach" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${khachHang.maKhachHang}"/>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="ma">Tên thanh toán</label>
                        <select id="ma" class="form-control" name="ma">
                            <option>Chọn.....</option>
                            <c:forEach var="kh" items="${loaiKhachs}">
                                <c:choose>
                                    <c:when test="${kh.maLoaiKhach == khachHang.maLoaiKhach}">
                                        <option value="${kh.maLoaiKhach}" selected> ${kh.tenLoaiKhach}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${kh.maLoaiKhach}">${kh.tenLoaiKhach}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="name">Ten <span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="name" id="name" value="${khachHang.hoTen}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="day">Phone<span style="color: red">*</span></label>
                        <input type="date" class="form-control" name="day" id="day" value="${khachHang.day}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <input  type="radio" name="gender" value="true" ${khachHang.gioiTinh == true ? 'checked' : ''}>Nam
                        <input  type="radio" name="gender" value="false" ${khachHang.gioiTinh == false ? 'checked' : ''}>Nữ<br>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="cmnd">CMND<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="cmnd" id="cmnd" value="${khachHang.soCMND}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <button type="submit" class="btn btn-primary">Update</button>
                    <a type="button" class="btn btn-primary" href="/khach?action=list">Quay lại</a>
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
