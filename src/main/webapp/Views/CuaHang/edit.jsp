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
    <title>Sửa cửa hàng</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<div class="col-8 offset-2 mt-3">
    <form method="POST"
          name="myForm"
          onsubmit="return validateForm()"
          action="/demo_war_exploded/cua-hang/update?ma=${ ch.ma }">
        <div class="row">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ ch.ma }" disabled/>
            </div>
            <div class="col-6">
                <label for="ten">Tên</label>
                <input type="text" id="ten" name="ten" class="form-control" value="${ ch.ten }"/>
                <span class="error-message" id="username-error1"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" id="diaChi" name="diaChi" class="form-control" value="${ ch.diaChi }"/>
                <span class="error-message" id="username-error6"></span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="Việt Nam" ${ ch.quocGia == "Việt Nam" ? "selected" : "" }>Việt Nam</option>
                    <option value="Lào" ${ ch.quocGia == "Lào" ? "selected" : "" }>Lào</option>
                    <option value="Campuchia" ${ ch.quocGia == "Campuchia" ? "selected" : "" }>Campuchia</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="Hà Nội" ${ ch.thanhPho == "Hà Nội" ? "selected" : "" }>Hà Nội</option>
                    <option value="Đà Nẵng" ${ ch.thanhPho == "Đà Nẵng" ? "selected" : "" }>Đà Nẵng</option>
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
            dia_chi = document.forms["myForm"]["diaChi"].value;
        if (ten == "") {
            document.getElementById("username-error1").innerHTML = "Vui lòng nhập tên khách hàng";
            flag = false;
        } else {
            document.getElementById("username-error1").innerHTML = ""
        }

        if (dia_chi == "") {
            document.getElementById("username-error6").innerHTML = "Vui lòng nhập địa chi khách hàng";
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
