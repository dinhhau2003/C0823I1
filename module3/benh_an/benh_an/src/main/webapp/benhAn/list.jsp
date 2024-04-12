<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Bệnh Nhân</title>
    <link rel="stylesheet" href="/static/bootstrap-5.2.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/fontawesome-free-5.15.4-web/css/all.min.css">
</head>
<body>
<%@ include file="/header.jsp" %>
<br>
<div class="container">
    <div class="row">
<%--        <div class="col-sm">--%>
<%--            <form action="/benhAn" method="get">--%>
<%--                <div class="form-group">--%>
<%--                    <input hidden=hidden name="action" value="search">--%>
<%--                    <select id="tenLoaiHang" class="form-control" name="tenLoaiHang">--%>
<%--                        <option value="">Chọn ten.....</option>--%>
<%--                        <c:forEach items="${loaiHangs}" var="kh">--%>
<%--                            <option value="${kh.tenLoaiHang}">${kh.tenLoaiHang}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                    <br>--%>
<%--                    <input type="text" name="name" class="form-control">--%>
<%--                    <br>--%>
<%--                    <button class="btn btn-success" type="submit">Search</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
    </div>
    <div class="row">
        <table class="table table-striped table-hover" id="myTable">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">ID</th>
                <th scope="col">Mã Bệnh Án</th>
                <th scope="col">Mã Bệnh Nhân</th>
                <th scope="col">Tên Bệnh Nhân</th>
                <th scope="col">Ngày Nhập Viện</th>
                <th scope="col">Ngày Ra Viện</th>
                <th scope="col">Lý Do Nhập Viện</th>
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
                <th scope="col">View</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${benhAns}" var="l" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${l.id}</td>
                    <td>${l.maBenhNhan}</td>
                    <td>${l.maBenhAn}</td>
                    <td>${l.tenBenhNhan}</td>
                    <td>${l.dayNhapVien}</td>
                    <td>${l.dayXuatVien}</td>
                    <td>${l.lyDoNhapVien}</td>
                    <td>
                        <a href="/benhAn?action=update&idUpdate=${l.id}" type="button"
                           class="btn btn-primary">
                            <i class="far fa-edit fa-lg"></i>
                        </a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteModal${l.id}">
                            <i class="far fa-trash-alt fa-lg"></i>
                        </button>

                        <!-- Modal Xác nhận Xóa -->
                        <div class="modal fade" id="deleteModal${l.id}" tabindex="-1"
                             aria-labelledby="deleteModalLabel${l.id}"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteModalLabel${l.id}">Xác nhận
                                            Xóa</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Bạn có chắc chắn muốn xóa máy có mã: ${l.id} không?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Đóng
                                        </button>
                                        <a href="/benhAn?action=delete&idDelete=${l.id}"
                                           class="btn btn-danger">Xóa</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#viewModal${l.id}">
                            <i class="fas fa-info-circle"></i>
                        </button>

                        <!-- Modal view -->
                        <div class="modal fade" id="viewModal${l.id}" tabindex="-1"
                             aria-labelledby="viewModalLabel${l.id}"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="viewModalLabel${l.id}">Thông tin
                                            product</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <h6>ID: ${l.id}</h6>
<%--                                        <h6>Name: ${l.tenHangHoa}</h6>--%>
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
