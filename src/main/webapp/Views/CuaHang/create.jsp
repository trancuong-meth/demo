<%--
  Created by IntelliJ IDEA.
  User: Tran Tuan Cuong
  Date: 14/3/2023
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới cửa hàng</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="col-8 offset-2 mt-3">
    <form name="myForm"
          method="POST"
          action="/demo_war_exploded/cua-hang/store"
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
            <div class="col-12">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" id="diaChi" name="diaChi" class="form-control"/>
                <span class="error-message" id="username-error6"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option>Việt Nam</option>
                    <option>Lào</option>
                    <option>Campuchia</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option>Hà Nội</option>
                    <option>Đà Nẵng</option>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <input type="submit" class="btn btn-primary" value="Thêm mới"/>
            </div>
        </div>
    </form>
</div>

<script src="/demo_war_exploded/js/bootstrap.min.js"></script>
<script>
    function validateForm() {
        var flag = true;
        var ten = document.forms["myForm"]["ten"].value,
            ma = document.forms["myForm"]["ma"].value,
            dia_chi = document.forms["myForm"]["diaChi"].value;
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

        if (ngay_sinh == "") {
            document.getElementById("username-error4").innerHTML = "Vui lòng nhập mã chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error4").innerHTML = ""
        }

        if (ten_dem == "") {
            document.getElementById("username-error2").innerHTML = "Vui lòng nhập mã chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error2").innerHTML = ""
        }

        if (ho == "") {
            document.getElementById("username-error3").innerHTML = "Vui lòng nhập mã chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error3").innerHTML = ""
        }

        if (mat_khau == "") {
            document.getElementById("username-error7").innerHTML = "Vui lòng nhập mã chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error7").innerHTML = ""
        }

        if (dia_chi == "") {
            document.getElementById("username-error6").innerHTML = "Vui lòng nhập mã chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error6").innerHTML = ""
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
