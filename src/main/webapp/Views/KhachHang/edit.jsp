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
    <title>Sửa khách hàng</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2 mt-3">
    <form method="POST"
          name="myForm"
          onsubmit="return validateForm()"
          action="/demo_war_exploded/khach-hang/update?ma=${ qlkh.ma }">
        <div class="row">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ qlkh.ma }" disabled/>
            </div>
            <div class="col-6">
                <label for="ten">Tên</label>
                <input type="text" id="ten" name="ten" class="form-control" value="${ qlkh.ten }"/>
                <span class="error-message" id="username-error1"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="tenDem">Tên đệm</label>
                <input type="text" id="tenDem" name="tenDem" class="form-control" value="${ qlkh.tenDem }"/>
                <span class="error-message" id="username-error2"></span>
            </div>
            <div class="col-6">
                <label for="ho">Họ</label>
                <input type="text" id="ho" name="ho" class="form-control" value="${ qlkh.ho }"/>
                <span class="error-message" id="username-error3"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="ngaySinh">Họ</label>
                <input type="text" id="ngaySinh" name="ngaySinh" class="form-control" value="${ qlkh.ngaySinh }"/>
                <span class="error-message" id="username-error4"></span>
            </div>
            <div class="col-6">
                <label for="sdt">Họ</label>
                <input type="text" id="sdt" name="sdt" class="form-control" value="${ qlkh.sdt }"/>
                <span class="error-message" id="username-error5"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" id="diaChi" name="diaChi" class="form-control" value="${ qlkh.diaChi }"/>
                <span class="error-message" id="username-error6"></span>
            </div>
            <div class="col-6">
                <label for="matKhau">Mật khẩu</label>
                <input type="text" id="matKhau" name="matKhau" class="form-control" value="${ qlkh.matKhau }"/>
                <span class="error-message" id="username-error7"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="Việt Nam" ${ qlkh.quocGia == "Việt Nam" ? "selected" : "" }>Việt Nam</option>
                    <option value="Lào" ${ qlkh.quocGia == "Lào" ? "selected" : "" }>Lào</option>
                    <option value="Campuchia" ${ qlkh.quocGia == "Campuchia" ? "selected" : "" }>Campuchia</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="Hà Nội" ${ qlkh.thanhPho == "Hà Nội" ? "selected" : "" }>Hà Nội</option>
                    <option value="Đà Nẵng" ${ qlkh.thanhPho == "Đà Nẵng" ? "selected" : "" }>Đà Nẵng</option>
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
            ten_dem = document.forms["myForm"]["ten_dem"].value,
            ho = document.forms["myForm"]["ho"].value,
            dia_chi = document.forms["myForm"]["dia_chi"].value,
            ngay_sinh = document.forms["myForm"]["ngay_sinh"].value,
            mat_khau = document.forms["myForm"]["mat_khau"].value,
            sdt = document.forms["myForm"]["sdt"].value;
        if (ten == "") {
            document.getElementById("username-error1").innerHTML = "Vui lòng nhập tên khách hàng";
            flag = false;
        } else {
            document.getElementById("username-error1").innerHTML = ""
        }

        if (ngay_sinh == "") {
            document.getElementById("username-error4").innerHTML = "Vui lòng nhập ngày sinh khách hàng";
            flag = false;
        } else {
            document.getElementById("username-error4").innerHTML = ""
        }

        if (ten_dem == "") {
            document.getElementById("username-error2").innerHTML = "Vui lòng nhập tên đệm khách hàng";
            flag = false;
        } else {
            document.getElementById("username-error2").innerHTML = ""
        }

        if (ho == "") {
            document.getElementById("username-error3").innerHTML = "Vui lòng nhập họ khách hàng";
            flag = false;
        } else {
            document.getElementById("username-error3").innerHTML = ""
        }

        if (mat_khau == "") {
            document.getElementById("username-error7").innerHTML = "Vui lòng nhập mật khẩu khách hàng";
            flag = false;
        } else {
            document.getElementById("username-error7").innerHTML = ""
        }

        if (dia_chi == "") {
            document.getElementById("username-error6").innerHTML = "Vui lòng nhập địa chi khách hàng";
            flag = false;
        } else {
            document.getElementById("username-error6").innerHTML = ""
        }

        if (sdt == "") {
            document.getElementById("username-error5").innerHTML = "Vui lòng nhập SDT khách hàng";
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
