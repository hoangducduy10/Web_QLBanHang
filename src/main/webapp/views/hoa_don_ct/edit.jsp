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
    <title>Edit</title>
</head>
<body>
<h1>Edit Hoa Don CT</h1>

<form action="/hoa-don-chi-tiet/update/${data.id}" method="post">
    <div>
        <label>So Luong</label>
        <input type="text" name="soLuong" value="${data.soLuong}">
    </div>
    <br>
    <div>
        <label>Don Gia</label>
        <input type="text" name="donGia" value="${data.donGia}">
    </div>
    <br>
    <div>
        <label>Trang Thai</label>
        <select name="trangThai">
            <option value="1" ${data.trangThai==1?"selected":""}>Da thanh toan</option>
            <option value="0" ${data.trangThai==1?"selected":""}>Da huy</option>
        </select>
        <c:if test="${not empty errors['trangThai']}">
            <small style="color: red">${errors['trangThai']}</small>
        </c:if>
    </div>
    <br>
    <div>
        <button>Update</button>
    </div>
</form>
</body>
</html>