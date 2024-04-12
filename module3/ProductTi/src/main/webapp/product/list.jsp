<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"></head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <a href="/product?action=create">Thêm mới</a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <c:if test="${!empty products}">
                <form class="d-flex col-4"  method="get">
                    <input hidden name="action" value="search" placeholder="Nhập tên">
                    <input type="text" style="border-radius: 6px" name="name" placeholder="Nhập tên">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <table class="table table-hover" id="myTable">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Mã</th>
                        <th scope="col">Name</th>
                        <th scope="col">Day</th>
                        <th scope="col">Category name</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="l" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index + 1}</th>
                            <td>${l.id}</td>
                            <td>${l.name}</td>
                            <td>${l.day}</td>
                            <td>${l.nameCategory}</td>
                            <td>
                                <a href="/product?action=update&id=${l.id}"  type="button"
                                   class="btn btn-primary">
                                    <i class="far fa-edit fa-lg"></i>
                                </a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal" data-id="${l.id}">
                                    <i class="fas fa-trash" style="color: white;"></i>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Xác nhận xóa </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn chắc chắn muốn xóa?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-danger" id="confirmDeleteBtn">Xác nhận</button>
            </div>
        </div>
    </div>
</div>
<script>
    var deleteModal = document.getElementById('deleteModal');
    deleteModal.addEventListener('show.bs.modal', function (event) {
        var button = event.relatedTarget;
        var id = button.getAttribute('data-id');
        var confirmButton = document.getElementById('confirmDeleteBtn');
        confirmButton.setAttribute('onclick', 'location.href="/product?action=delete&id=' + id + '"');
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
