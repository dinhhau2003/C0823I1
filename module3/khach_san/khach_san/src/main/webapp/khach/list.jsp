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
            <form action="/khach"  method="get">
                <div class="form-group">
                    <input hidden=hidden name="action" value="search">
                    <select id="tenLoaiKhach" class="form-control" name="tenLoaiKhach">
                        <option value="">Chọn ten.....</option>
                        <c:forEach items="${loaiKhachs}" var="kh">
                            <option value="${kh.getTenLoaiKhach()}">${kh.getTenLoaiKhach()}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <input type="text" name="name"  class="form-control">
                    <br>
                    <button class="btn btn-success" type="submit">Search</button>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped table-hover" id="myTable">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã</th>
                <th scope="col">Name</th>

                <th scope="col">gender</th>
                <th scope="col">CMND</th>
                <th scope="col">tên loại khách</th>
                <th scope="col">Day</th>

                <th scope="col">Update</th>
                <th scope="col">Delete</th>
                <th scope="col">View</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${khachHangs}" var="l" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${l.maKhachHang}</td>
                    <td>${l.hoTen}</td>

                    <c:if test="${l.isGioiTinh()}">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${!l.isGioiTinh()}">
                        <td>Nữ</td>
                    </c:if>
                    <td>${l.soCMND}</td>
                    <td>${l.tenLoaiKhach}</td>
                    <td>${l.day}</td>
                    <td>
                        <a href="/khach?action=update&idUpdate=${l.maKhachHang}" type="button"
                           class="btn btn-primary">
                            <i class="far fa-edit fa-lg"></i>
                        </a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteModal${l.maKhachHang}">
                            <i class="far fa-trash-alt fa-lg"></i>
                        </button>

                        <!-- Modal Xác nhận Xóa -->
                        <div class="modal fade" id="deleteModal${l.maKhachHang}" tabindex="-1"
                             aria-labelledby="deleteModalLabel${l.maKhachHang}"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteModalLabel${l.maKhachHang}">Xác nhận
                                            Xóa</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Bạn có chắc chắn muốn xóa máy có mã: ${l.maKhachHang} không?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Đóng
                                        </button>
                                        <a href="/khach?action=delete&idDelete=${l.maKhachHang}"
                                           class="btn btn-danger">Xóa</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#viewModal${l.maKhachHang}">
                            <i class="fas fa-info-circle"></i>
                        </button>

                        <!-- Modal view -->
                        <div class="modal fade" id="viewModal${l.maKhachHang}" tabindex="-1"
                             aria-labelledby="viewModalLabel${l.maKhachHang}"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="viewModalLabel${l.maKhachHang}">Thông tin
                                            product</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <h6>ID: ${l.maKhachHang}</h6>
                                        <h6>Name: ${l.hoTen}</h6>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/jquery/popper.min.js"></script>
<script src="/static/bootstrap-5.2.3-dist/js/bootstrap.min.js"></script>
<script src="/static/bootstrap-5.2.3-dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
