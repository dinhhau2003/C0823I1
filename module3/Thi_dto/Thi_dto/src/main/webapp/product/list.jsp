<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap-5.2.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/fontawesome-free-5.15.4-web/css/all.min.css">
</head>
<body>
<%--id="id_category"--%>
<%@ include file="/header.jsp" %>
<br>

<div class="container">
    <div class="row">
        <div class="col-sm">
            <form method="get">
                <div class="form-group">
                    <input hidden=hidden name="action" value="search">
                    <select class="form-control" name="tenDanhMuc">
                        <option value="">Chọn category.....</option>
                        <c:forEach items="${categories}" var="kh">
                            <option value="${kh.getTen_danh_muc()}">${kh.getTen_danh_muc()}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <input type="text" name="name" class="form-control" placeholder="Search">
                    <br>
                    <button class="btn btn-success" type="submit">Search</button>
                </div>
            </form>
        </div>
    </div>
    <div class="row">

        <table class="table table-hover" id="myTable">
            <thead>
            <h3>Product List</h3>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Mã</th>
                <th scope="col">Product Name</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Color</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Category</th>
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="l" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td>${l.id_product}</td>
                    <td>${l.name}</td>
                    <td>${l.gia}</td>
                    <td>${l.soLuong}</td>
                    <td>${l.color}</td>
                    <td>${l.moTa}</td>
                    <td>${l.ten_danh_muc}</td>
                    <td>
                        <a href="/product?action=update&id=${l.id_product}" type="button"
                           class="btn btn-primary">
                            <i class="far fa-edit fa-lg"></i>
                        </a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteModal${l.id_product}">
                            <i class="far fa-trash-alt fa-lg"></i>
                        </button>

                        <!-- Modal Xác nhận Xóa -->
                        <div class="modal fade" id="deleteModal${l.id_product}" tabindex="-1"
                             aria-labelledby="deleteModalLabel${l.id_product}"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="deleteModalLabel${l.id_product}">Xác nhận
                                            Xóa</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Bạn có chắc chắn muốn xóa máy có mã: ${l.id_product} không?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Đóng
                                        </button>
                                        <a href="/product?action=delete&id=${l.id_product}"
                                           class="btn btn-danger">Xóa</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>

                        <%--                    <td>--%>
                        <%--                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"--%>
                        <%--                                data-bs-target="#viewModal${l.id_product}">--%>
                        <%--                            <i class="fas fa-info-circle"></i>--%>
                        <%--                        </button>--%>

                        <%--                        <!-- Modal view -->--%>
                        <%--                        <div class="modal fade" id="viewModal${l.id_product}" tabindex="-1"--%>
                        <%--                             aria-labelledby="viewModalLabel${l.id_product}"--%>
                        <%--                             aria-hidden="true">--%>
                        <%--                            <div class="modal-dialog modal-dialog-centered" role="document">--%>
                        <%--                                <div class="modal-content">--%>
                        <%--                                    <div class="modal-header">--%>
                        <%--                                        <h5 class="modal-title" id="viewModalLabel${l.id_product}">Thông tin--%>
                        <%--                                            product</h5>--%>
                        <%--                                        <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
                        <%--                                                aria-label="Close"></button>--%>
                        <%--                                    </div>--%>
                        <%--                                    <div class="modal-body">--%>
                        <%--                                        <h6>ID: ${l.id_product}</h6>--%>
                        <%--                                        <h6>Name: ${l.name}</h6>--%>
                        <%--                                    </div>--%>

                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                        <%--                    </td>--%>
                </tr>
            </c:forEach>
            <c:if test="${products.isEmpty()}">
                <tr>
                    <td colspan="9"><h4 style="color: red">Không có dữ liệu</h4></td>
                </tr>
            </c:if>
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
