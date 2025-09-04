<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quên mật khẩu</title>
</head>
<body>
    <h2>Quên mật khẩu</h2>
    <form method="post" action="forget-password">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <button type="submit">Đặt lại mật khẩu</button>
    </form>
    <div style="color:red;">
        ${alert}
    </div>
    <a href="login">Quay lại đăng nhập</a>
</body>
</html>
