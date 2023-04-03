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
    <title>Thêm mới chức vụ</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="col-8 offset-2 mt-3">
    <form name="myForm"
          method="POST"
          action="/demo_war_exploded/chuc-vu/store"
          onsubmit="return validateForm()">

        <div class="row">
            <div class="col-6">
                <label for="ma">Mã</label>
                <input type="text" id="ma" name="ma" class="form-control"/>
                <span class="error-message" id="username-error"></span>
            </div>
            <div class="col-6">
                <label for="ten">Tên</label>
                <input type="text" id="ten" name="ten" class="form-control"/>
                <span class="error-message" id="username-error1"></span>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <input type="submit" class="btn btn-primary" value="Thêm mới"/>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>

<script src="/demo_war_exploded/js/bootstrap.min.js"></script>
<script>
    function validateForm() {
        var flag = true;
        var ten = document.forms["myForm"]["ten"].value, ma = document.forms["myForm"]["ma"].value;
        if (ten == "") {
            document.getElementById("username-error1").innerHTML = "Vui lòng nhập tên chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error1").innerHTML = ""
        }

        if (ma == "") {
            document.getElementById("username-error").innerHTML = "Vui lòng nhập mã chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error").innerHTML = ""
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
