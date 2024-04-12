<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="static/bootstrap-5.2.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/fontawesome-free-5.15.4-web/css/all.min.css">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><i class="fas fa-home fa-lg"></i></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="http://localhost:8080">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/khach?action=list"><i class="fas fa-list"></i> Danh sách</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/khach?action=create"><i class="fas fa-plus-circle"></i> Thêm
                            mới</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>


<script src="static/jquery/jquery-3.5.1.min.js"></script>
<script src="static/jquery/popper.min.js"></script>
<script src="static/bootstrap-5.2.3-dist/js/bootstrap.min.js"></script>
<script src="static/bootstrap-5.2.3-dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>