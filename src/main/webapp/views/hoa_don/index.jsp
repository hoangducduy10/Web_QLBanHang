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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>DanhSachHoaDon</title>
</head>
<body>
<h1>Danh Sach Hoa Don</h1>

<form action="/hoa-don/store" method="post">
    <div>
        <label>Ngay Mua Hang</label>
        <input type="text" name="ngayMuaHang" value="${data.ngayMuaHang}">
    </div>
    <br>
    <div>
        <label>Trang Thai</label>
        <select name="trangThai">
            <option value="1">Da thanh toan</option>
            <option value="0">Da huy</option>
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
<form action="/hoa-don/index" method="get">
<label>Trang Thai</label>
<select name="filter">
    <option value="1">Da thanh toan</option>
    <option value="0">Da huy</option>
</select>
<button>Search</button>
</form>
<br>
<table class="table table-striped">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID NV</th>
        <th>ID KH</th>
        <th>Ngay Mua Hang</th>
        <th>Trang Thai</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.idNV}</td>
            <td>${sp.idKH}</td>
            <td>${sp.ngayMuaHang}</td>
            <td>${sp.trangThai==1?"Da thanh toan":"Da huy"}</td>
            <td>
                <a href="/hoa-don/edit/${sp.id}">Update</a>
                <a href="/hoa-don/delete/${sp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>