<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>DanhSachSanPhamCT</title>
</head>
<body>
<h1>Danh Sach San Pham CT</h1>

<c:if test="${not empty error}">
    <div style="color: red">${error}</div>
</c:if>

<form action="/san-pham-chi-tiet/store" method="post">
    <div>
        <label>So Luong</label>
        <input type="text" name="soLuong" value="${data.soLuong}">
        <c:if test="${not empty errors['soLuong']}">
            <small style="color: red">${errors['soLuong']}</small>
        </c:if>
    </div>
    <br>
    <div>
        <label>Don Gia</label>
        <input type="text" name="donGia" value="${data.donGia}">
        <c:if test="${not empty errors['donGia']}">
            <small style="color: red">${errors['donGia']}</small>
        </c:if>
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
<form action="/san-pham-chi-tiet/index" method="get">
    <label>San Pham</label>
    <select name="spId">
        <c:forEach items="${sanPhamList}" var="sp">
            <option value="${sp.id}">${sp.ten}</option>
        </c:forEach>
    </select>
    <button>Search</button>
</form>
<br>
<table class="table table-striped">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma SPCT</th>
        <th>ID KT</th>
        <th>ID MS</th>
        <th>ID SP</th>
        <th>So Luong</th>
        <th>Don Gia</th>
        <th>Trang Thai</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.maSPCT}</td>
            <td>${sp.idKT}</td>
            <td>${sp.idMS}</td>
            <td>${sp.idSP}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.donGia}</td>
            <td>${sp.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td>
                <a href="/san-pham-chi-tiet/edit/${sp.id}">Update</a>
                <a href="/san-pham-chi-tiet/delete/${sp.id}">Delete</a>
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
