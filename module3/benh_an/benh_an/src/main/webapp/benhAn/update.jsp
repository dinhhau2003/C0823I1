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
        <form action="/benhAn" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${benhAn.id}"/>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="maBenhAn">Mã bệnh án <span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="maBenhAn" id="maBenhAn" value="${benhAn.maBenhAn}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="maBenhNhan"></label>
                        <select id="maBenhNhan" class="form-control" name="maBenhNhan">
                            <option>Chọn mã bệnh nhân.....</option>
                            <c:forEach var="kh" items="${benhNhans}">
                                <c:choose>
                                    <c:when test="${kh.maBenhNhan == benhAn.maBenhNhan}">
                                        <option value="${kh.maBenhNhan}" selected> ${kh.tenBenhNhan}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${kh.maBenhNhan}">${kh.tenBenhNhan}</option>
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
                        <label for="dayNhap">Ngày Nhập Viện<span style="color: red">*</span></label>
                        <input type="date" class="form-control" name="dayNhap" id="dayNhap" value="${benhAn.dayNhapVien}" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="dayXuat">Ngày Xuất Viện<span style="color: red">*</span></label>
                        <input type="date" class="form-control" name="dayXuat" id="dayXuat" value="${benhAn.dayXuatVien}"  />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="lyDo">Lý Do Nhập viện <span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="lyDo" id="lyDo" value="${benhAn.lyDoNhapVien}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <button type="submit" class="btn btn-primary">Chỉnh sửa</button>
                    <a type="button" class="btn btn-primary" href="/benhAn?action=list">Quay lại</a>
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
