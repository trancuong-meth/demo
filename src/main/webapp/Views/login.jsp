<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 4/3/23
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="alert alert-danger">
    ${ error_message }
</div>
<div class="col-8 offset-2 mt-3">
    <form action="/demo_war_exploded/login" method="post">
        <div class="row">
            <div class="col">
                <label for="ma">Mã</label>
                <input type="text" id="ma" name="ma" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="matKhau">Mật khẩu</label>
                <input type="password" id="matKhau" name="matKhau" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <input type="submit" class="btn btn-primary" value="Đăng nhập"/>
            </div>
        </div>
    </form>
</div>

<script src="/demo_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
