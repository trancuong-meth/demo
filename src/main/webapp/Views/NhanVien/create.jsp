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
    <title>Thêm mới nhân viên</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.css">

</head>
<body class="container">
<div class="col-8 offset-2 mt-3">
    <form method="POST"
          name="myForm"
          action="/demo_war_exploded/nhan-vien/store"
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
                <label for="tenDem">Tên đệm</label>
                <input type="text" id="tenDem" name="tenDem" class="form-control"/>
                <span class="error-message" id="username-error2"></span>
            </div>
            <div class="col-6">
                <label for="ho">Họ</label>
                <input type="text" id="ho" name="ho" class="form-control"/>
                <span class="error-message" id="username-error3"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label>Giới tính</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="nam"
                           value="Nam">
                    <label class="form-check-label" for="nam">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="nu"
                           value="Nữ">
                    <label class="form-check-label" for="nu">Nữ</label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="ngaySinh">Ngày sinh</label>
                <input type="text" id="ngaySinh" name="ngaySinh" class="form-control"/>
                <span class="error-message" id="username-error4"></span>
            </div>
            <div class="col-6">
                <label for="sdt">SDT</label>
                <input type="text" id="sdt" name="sdt" class="form-control"/>
                <span class="error-message" id="username-error5"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" id="diaChi" name="diaChi" class="form-control"/>
                <span class="error-message" id="username-error6"></span>
            </div>
            <div class="col-6">
                <label for="matKhau">Mật khẩu</label>
                <input type="text" id="matKhau" name="matKhau" class="form-control"/>
                <span class="error-message" id="username-error7"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label>Trạng thái</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="trangThai" id="dlv"
                           value="Đang làm việc">
                    <label class="form-check-label" for="dlv">Đã nghỉ việc</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="trangThai" id="dnv"
                           value="Đã nghỉ việc">
                    <label class="form-check-label" for="dnv">Đã nghỉ việc</label>
                </div>
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
            ten_dem = document.forms["myForm"]["tenDem"].value,
            ho = document.forms["myForm"]["ho"].value,
            dia_chi = document.forms["myForm"]["diaChi"].value,
            ngay_sinh = document.forms["myForm"]["ngaySinh"].value,
            mat_khau = document.forms["myForm"]["matKhau"].value,
            sdt = document.forms["myForm"]["sdt"].value;
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

        if (sdt == "") {
            document.getElementById("username-error5").innerHTML = "Vui lòng nhập mã chức vụ";
            flag = false;
        } else {
            document.getElementById("username-error5").innerHTML = ""
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
