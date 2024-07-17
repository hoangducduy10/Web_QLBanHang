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
    <title>UpdateSanPham</title>
</head>
<body>
<h1>Update San Pham</h1>

<form action="/san-pham/update/${data.id}" method="post">
    <div>
        <label>Ma</label>
        <input type="text" name="ma" value="${data.ma}">
    </div>
    <br>
    <div>
        <label>Ten</label>
        <input type="text" name="ten" value="${data.ten}">
    </div>
    <br>
    <div>
        <label>Trang Thai</label>
        <select name="trangThai">
            <option value="1">Dang hoat dong</option>
            <option value="0">Ngung hoat dong</option>
        </select>
    </div>
    <br>
    <div>
        <button>Update</button>
    </div>
</form>
</body>
</html>