<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 18/03/2024
  Time: 9:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="../layout/navbar.jsp"></c:import>
<c:import url="../layout/head.jsp"></c:import>
<head>
    <title>Title</title>
</head>
<body>
<script>
    function displayToast(message, color) {
        document.getElementById("toastContent").innerHTML = message;
        document.getElementById("liveToast").style.background = color;
        let myAlert = document.getElementById('liveToast');//select id of toast
        let bsAlert = new bootstrap.Toast(myAlert);//inizialize it
        bsAlert.show();//show it
    }

</script>
<h3>${param.mess}</h3>
<h1>Danh sách khach hang</h1>
<a class="btn btn-success" href="/customer?action=add">Thêm mới</a>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>email</th>
        <th>address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>

            <td>
                <button onclick="deleteInfo('${customer.id}','${customer.name}')" type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>

</table>
<%--Hiển thị message lên toast --%>

<%--toast--%>
<div class="position-fixed top-0 end-5 p-3" style="z-index: 11;margin-left: 500px">
    <div id="liveToast" style="width: 230px; color: white; background:lightgreen ;border-radius:0%/0%;" class="toast"
         role="dialog" aria-live="assertive" aria-atomic="true">
        <div class="toast-body">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="30px" height="30px">
                <g id="surface1_4_">
                    <path style="fill:#4CAF50;"
                          d="M44,24c0,11.045-8.955,20-20,20S4,35.045,4,24S12.955,4,24,4S44,12.955,44,24z"/>
                    <path style="fill:#CCFF90;"
                          d="M34.602,14.602L21,28.199l-5.602-5.598l-2.797,2.797L21,33.801l16.398-16.402L34.602,14.602z"/>
                </g>
            </svg>
            <span id="toastContent">Nội dung hiển thị</span>
        </div>
    </div>
</div>
<script>
    <c:if test="${param.mess!=null}">
    displayToast("Thêm mới thành công", "orange")
    document.getElementById("new").style.display = "inline";
    </c:if>
</script>
</body>
</html>
