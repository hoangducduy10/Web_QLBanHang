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
    <title>DanhSachHoaDonCT</title>
</head>
<body>
<h1>Danh Sach Hoa Don CT</h1>
<br>
<br>
<form action="/hoa-don-chi-tiet/index" method="get">
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
        <th>ID HD</th>
        <th>ID SPCT</th>
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
            <td>${sp.idHD}</td>
            <td>${sp.idSPCT}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.donGia}</td>
            <td>${sp.trangThai==1?"Da thanh toan":"Da huy"}</td>
            <td>
                <a href="/hoa-don-chi-tiet/edit/${sp.id}">Update</a>
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