<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>

    <c:if test="${error}">
        <small style="color: red;">Invalid username or password</small>
    </c:if>
    <form action="/login" method="post">
        <div>
            <label>Username:</label>
            <input type="text" name="tenDangNhap" value="${data.tenDangNhap}"/>
        </div>
        <div>
            <label>Password:</label>
            <input type="password" name="matKhau" value="${data.matKhau}"/>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
</body>
</html>