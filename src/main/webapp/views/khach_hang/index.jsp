<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>DanhSachKH</title>
</head>
<body>
    <h1>Danh Sach Khach Hang</h1>

    <form action="/khach-hang/store" method="post">
        <div>
            <label>Ma</label>
            <input type="text" name="maKH" value="${data.maKH}">
            <c:if test="${not empty errors['maKH']}">
                <small style="color: red">${errors['maKH']}</small>
            </c:if>
        </div>
        <br>
        <div>
            <label>Ten</label>
            <input type="text" name="ten" value="${data.ten}">
            <c:if test="${not empty errors['ten']}">
                <small style="color: red">${errors['ten']}</small>
            </c:if>
        </div>
        <br><div>
            <label>SDT</label>
            <input type="text" name="sdt" value="${data.sdt}">
            <c:if test="${not empty errors['sdt']}">
                <small style="color: red">${errors['sdt']}</small>
            </c:if>
        </div>
        <br>
        <div>
            <label>Trang Thai</label>
            <select name="trangThai">
                <option value="1">Khach Quen</option>
                <option value="0">Khach Vang Lai</option>
            </select>
            <c:if test="${not empty errors['trangThai']}">
                <small style="color: red">${errors['trangThai']}</small>
            </c:if>
        </div>
        <br>
        <div>
            <button>Save</button>
        </div>
    </form>
    <br>
    <br>
    <br>
    <form action="/khach-hang/index" method="get">
        <label>Ten Khach Hang</label>
        <input type="text" name="keyword">
        <button>Search</button>
    </form>
    <br>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>STT</th>
                <th>Ma KH</th>
                <th>Ten</th>
                <th>SDT</th>
                <th>Trang Thai</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lists.content}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.maKH}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.sdt}</td>
                    <td>${sp.trangThai==1?"Khach quen":"Khach vang lai"}</td>
                    <td>
                        <a href="/khach-hang/edit/${sp.id}">Update</a>
                        <a href="/khach-hang/delete/${sp.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item ${lists.number == 0 ? 'disabled' : ''}">
                <a class="page-link" href="/khach-hang/index?page=${lists.number - 1}">Previous</a>
            </li>
            <c:forEach begin="0" end="${lists.totalPages - 1}" var="page">
                <c:choose>
                    <c:when test="${page == 0 || page == lists.totalPages - 1 || (page >= lists.number - 1 && page <= lists.number + 1)}">
                        <li class="page-item ${page == lists.number ? 'active' : ''}">
                            <a class="page-link" href="/khach-hang/index?page=${page}">${page + 1}</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${page == 1 && lists.number > 2}">
                            <li class="page-item disabled"><a class="page-link">...</a></li>
                        </c:if>
                        <c:if test="${page == lists.totalPages - 2 && lists.number < lists.totalPages - 3}">
                            <li class="page-item disabled"><a class="page-link">...</a></li>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <li class="page-item ${lists.number == lists.totalPages - 1 ? 'disabled' : ''}">
                <a class="page-link" href="/khach-hang/index?page=${lists.number + 1}">Next</a>
            </li>
        </ul>
    </nav>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>