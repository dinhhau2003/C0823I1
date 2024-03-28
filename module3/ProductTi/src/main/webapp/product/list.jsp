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
                                <a href="/product?action=delete&id=${l.id}"  type="button"
                                   class="btn btn-danger">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
