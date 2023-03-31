<%--
  Created by IntelliJ IDEA.
  User: Tran Tuan Cuong
  Date: 13/3/2023
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.css">

</head>
<body class="container">
<section>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Họ và Tên</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">SĐT</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Khác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${f:length(listKH) == 0}">
            <span>
                Không có dữ liệu
            </span>
        </c:if>
        <c:if test="${f:length(listKH) != 0}">
            <c:forEach items="${ listKH }" var="kh">
                <tr>
                    <td>${ kh.ma }</td>
                    <td>${ kh.ho } ${ kh.tenDem} ${ kh.ten}</td>
                    <td>${ kh.ngaySinh}</td>
                    <td>${ kh.sdt}</td>
                    <td>${ kh.diaChi}</td>
                    <td>${ kh.matKhau}</td>
                    <td>${ kh.thanhPho}</td>
                    <td>${ kh.quocGia}</td>
                    <td>
                        <a class="btn btn-success" role="button" href="/demo_war_exploded/khach-hang/edit?ma=${ kh.ma }">Cập nhật</a>
                        <a class="btn btn-danger" role="button" href="/demo_war_exploded/khach-hang/delete?ma=${ kh.ma }">Xoá</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <a class="btn btn-success" role="button" href="/demo_war_exploded/khach-hang/create">Thêm mới</a>
</section>

<script src="/demo_war_exploded/js/bootstrap.js"></script>
</body>
</html>
