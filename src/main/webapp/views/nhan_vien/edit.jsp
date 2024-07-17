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
    <title>EditNhanVien</title>
</head>
<body>
    <h1>Edit Nhan Vien</h1>

    <form action="/nhan-vien/update/${data.id}" method="post">
        <div>
            <label>Ma</label>
            <input type="text" name="maNV" value="${data.maNV}">
        </div>
        <br>
        <div>
            <label>Ten</label>
            <input type="text" name="ten" value="${data.ten}">
        </div>
        <br>
        <div>
            <label>Ten Dang Nhap</label>
            <input type="text" name="tenDangNhap" value="${data.tenDangNhap}">
        </div>
        <br>
        <div>
            <label>Mat Khau</label>
            <input type="text" name="matKhau" value="${data.matKhau}">
        </div>
        <br>
        <div>
            <label>Trang Thai</label>
            <select name="trangThai">
                <option value="1" ${data.trangThai==1?"selected":""}>Dang Lam Viec</option>
                <option value="0" ${data.trangThai==0?"selected":""}>Chua Co Ca Lam</option>
            </select>
        </div>
        <br>
        <div>
            <button>Update</button>
        </div>
    </form>
    <br>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Ma NV</th>
                <th>Ten</th>
                <th>Ten Dang Nhap</th>
                <th>Mat Khau</th>
                <th>Trang Thai</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lists}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.maNV}</td>
                    <td>${sp.ten}</td>
                    <td>${sp.tenDangNhap}</td>
                    <td>${sp.matKhau}</td>
                    <td>${sp.trangThai==1?"Dang lam viec":"Chua co ca lam"}</td>
                    <td>
                        <a href="/nhan-vien/edit/${sp.id}">Update</a>
                        <a href="/nhan-vien/delete/${sp.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>