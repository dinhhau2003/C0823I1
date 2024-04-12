<%--
  Created by IntelliJ IDEA.
  User: DINH PHUC
  Date: 22/03/2024
  Time: 6:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<p>
    <a href="/phone?action=create">Add new user</a>
</p>


<table class="table table-dark table-strip">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>id_danh_muc</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="phone" items="${phoneList}" varStatus="loop">
        <tr>
            <td>${phone.id}</td>
            <td>${phone.name}</td>
            <td>${phone.price}</td>
            <td>${phone.id_danh_muc}</td>
<%--            <td>${phone.ten_danh_muc}</td>--%>
            <td><a href="/phone?action=update&id=${phone.id}">Edit</a></td>
            <td><a href="/phone?action=delete&id=${phone.id}">delete</a></td>
                <%--            <td><a href="#" onclick="mess(${phone.id})">Delete</a></td>--%>

                <%--            <td>--%>
                <%--                <button class="delete"  data-toggle="modal" data-target="#exampleModalCenter">--%>
                <%--                    delete<i class="far fa-trash-alt"></i>--%>
                <%--                </button>--%>
                <%--            </td>--%>
                <%--            <td>--%>
                <%--                <button type="button" onclick="showInfo('${student.id}'")--%>
                <%--                        class="btn btn-outline-danger btn-sm" data-toggle="modal"--%>
                <%--                        data-target="#staticBackdrop">--%>
                <%--                    Delete--%>
                <%--                </button>--%>
                <%--            </td>--%>
                <%--            <td><input type="checkbox" href="${phone.id}" class="deleten-checkbox" name="delete_id">Delete</td>--%>

        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<%--<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        &lt;%&ndash;        thêm thẻ form&ndash;%&gt;--%>
<%--        <form action="/phone?action=delete" method="get">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <input  hidden type="text" id="id" name="idDelete">--%>
<%--                    <span>Bạn có muốn xóa sinh viên </span>--%>
<%--                    <span class="text-danger" id="name"></span> không?<span/>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap4/js/bootstrap.bundle.js"></script>
<script src="/static/bootstrap4/js/bootstrap.min.js"></script>
<script src="/static/bootstrap4/js/bootstrap.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function () {
        $('#list').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })
    // function _delete(id) {
    //     document.getElementById("x").value = id
    //     let str = document.getElementById("message").textContent
    //     document.getElementById("message").innerHTML = str +" "+ id
    // }
    // function mess(id){
    //     var option = confirm("Bạn có muốn xóa không ?");
    //     if (option===true){
    //         window.location.href = "phone?action=delete&id="+id;
    //     }
    // }

</script>
</body>
</html>
