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
    <title>Thêm mới hoá đơn</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="col-8 offset-2 mt-3">
    <form name="myForm"
          method="POST"
          action="/demo_war_exploded/hoa-don/store"
          onsubmit="return validateForm()">
        <div class="row">
            <div class="col-6">
                <label for="ma">Mã</label>
                <input type="text" id="ma" name="ma" class="form-control"/>
                <span class="error-message" id="username-error"></span>
            </div>
            <div class="col-6">
                <label for="tenNguoiNhan">Tên người nhận</label>
                <input type="text" id="tenNguoiNhan" name="tenNguoiNhan" class="form-control"/>
                <span class="error-message" id="username-error1"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" id="diaChi" name="diaChi" class="form-control"/>
                <span class="error-message" id="username-error2"></span>
            </div>
            <div class="col-6">
                <label for="ngayTao">Ngày tạo</label>
                <input type="text" id="ngayTao" name="ngayTao" class="form-control"/>
                <span class="error-message" id="username-error3"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="ngayThanhToan">Ngày thanh toán</label>
                <input type="text" id="ngayThanhToan" name="ngayThanhToan" class="form-control"/>
                <span class="error-message" id="username-error4"></span>
            </div>
            <div class="col-6">
                <label for="ngayShip">Ngày ship</label>
                <input type="text" id="ngayShip" name="ngayShip" class="form-control"/>
                <span class="error-message" id="username-error5"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label for="ngayNhan">Ngày nhận</label>
                <input type="text" id="ngayNhan" name="ngayNhan" class="form-control"/>
                <span class="error-message" id="username-error6"></span>
            </div>
            <div class="col-12">
                <label for="sdt">SĐT</label>
                <input type="text" id="sdt" name="sdt" class="form-control"/>
                <span class="error-message" id="username-error7"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label>Tình trạng</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="tinhTrang" id="tinhTrang"
                           value="Chờ"/>
                    <label class="form-check-label" for="tinhTrang">Chờ</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="tinhTrang" id="tinhTrang1"
                           value="Đã thanh toán"/>
                    <label class="form-check-label" for="tinhTrang1">Đã thanh toán</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="tinhTrang" id="tinhTrang2"
                           value="Huỷ"/>
                    <label class="form-check-label" for="tinhTrang2">Huỷ</label>
                </div>
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
        var ma = document.forms["myForm"]["ma"].value;
        var ngayThanhToan = document.forms["myForm"]["ngayThanhToan"].value;
        var ngayTao = document.forms["myForm"]["ngayTao"].value;
        var ngayShip = document.forms["myForm"]["ngayShip"].value;
        var ngayNhan = document.forms["myForm"]["ngayNhan"].value;
        var tenNguoiNhan = document.forms["myForm"]["tenNguoiNhan"].value;
        var diaChi = document.forms["myForm"]["diaChi"].value;
        var sdt = document.forms["myForm"]["sdt"].value;
        if (ma == "") {
            document.getElementById("username-error").innerHTML = "Vui lòng nhập mã";
            flag = false;
        }
        if (tenNguoiNhan == "") {
            document.getElementById("username-error1").innerHTML = "Vui lòng nhập tên người nhận";
            flag = false;
        }
        if (diaChi == "") {
            document.getElementById("username-error2").innerHTML = "Vui lòng nhập địa chỉ";
            flag = false;
        }
        if (ngayTao == "") {
            document.getElementById("username-error3").innerHTML = "Vui lòng nhập ngày tạo";
            flag = false;
        }
        if (ngayThanhToan == "") {
            document.getElementById("username-error4").innerHTML = "Vui lòng nhập ngày thanh toán";
            flag = false;
        }
        if (ngayShip == "") {
            document.getElementById("username-error5").innerHTML = "Vui lòng nhập ngày ship ";
            flag = false;
        }
        if (ngayNhan == "") {
            document.getElementById("username-error6").innerHTML = "Vui lòng nhập ngày nhận";
            flag = false;
        }
        if (sdt == "") {
            document.getElementById("username-error7").innerHTML = "Vui lòng nhập SĐT";
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
