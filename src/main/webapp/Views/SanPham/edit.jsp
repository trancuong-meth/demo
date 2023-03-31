<%--
  Created by IntelliJ IDEA.
  User: Tran Tuan Cuong
  Date: 14/3/2023
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa sản phẩm</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="col-8 offset-2 mt-3">
    <form method="POST"
          name="myForm"
          onsubmit="return validateForm()"
          action="/demo_war_exploded/san-pham/update?ma=${ sp.ma }">

        <div class="row">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value=" ${ sp.ma }" disabled/>
            </div>
            <div class="col-6">
                <label for="ten">Tên</label>
                <input type="text" id="ten" name="ten" class="form-control" value="${ sp.ten }"/>
                <span class="error-message" id="username-error"></span>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <input type="submit" class="btn btn-primary" value="Sửa sản phẩm"/>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>

<script src="/demo_war_exploded/js/bootstrap.min.js"></script>
<script>
    function validateForm() {
        var flag = true;
        var ten = document.forms["myForm"]["ten"].value;
        if (ten == "") {
            document.getElementById("username-error").innerHTML = "Vui lòng nhập tên sản phẩm";
            flag = false;
        }
        return flag;
    }
</script>
<style>
    .error-message {
        color: red;
        font-size: 12px;
        margin-left: 5px;
    }
</style>
</body>
</html>
