<%--
  Created by IntelliJ IDEA.
  User: Tran Tuan Cuong
  Date: 14/3/2023
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Danh sách hoá đơn</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.css">
</head>
<body class="container">
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã</th>
        <th scope="col">Ngày tạo</th>
        <th scope="col">Ngày thanh Toán</th>
        <th scope="col">Ngày ship</th>
        <th scope="col">Ngày nhận</th>
        <th scope="col">Tên nguời nhận</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">SDT</th>
        <th scope="col">Tình trạng</th>
        <th scope="col">Khác</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(listHD) == 0}">
        <span>
            Không có dữ liệu
        </span>
    </c:if>
    <c:if test="${f:length(listHD) != 0}">
        <c:forEach items="${listHD}" var="hd">
            <tr>
                <td>${ hd.ma }</td>
                <td>${ hd.ngayTao }</td>
                <td>${ hd.ngayThanhToan }</td>
                <td>${ hd.ngayShip }</td>
                <td>${ hd.ngayNhan }</td>
                <td>${ hd.tenNguoiNhan }</td>
                <td>${ hd.diaChi }</td>
                <td>${ hd.sdt }</td>
                <td>${ hd.tinhTrang }</td>
                <td>
                    <a class="btn btn-success" role="button" href="/demo_war_exploded/chuc-vu/edit?ma=${ hd.ma }">Cập nhật</a>
                    <a class="btn btn-danger" role="button" href="/demo_war_exploded/chuc-vu/delete?ma=${ hd.ma }">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<a class="btn btn-success" role="button" href="/demo_war_exploded/hoa-don/create">Thêm mới</a>
<script src="/demo_war_exploded/js/bootstrap.js"></script>
</body>
</html>
