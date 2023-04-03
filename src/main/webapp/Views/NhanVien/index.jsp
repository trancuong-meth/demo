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
    <title>Danh sách nhân viên</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.css">
</head>
<body class="container">
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã</th>
        <th scope="col">Họ và tên</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">SDT</th>
        <th scope="col">Mật khẩu</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">Khác</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(listNV) == 0}">
        <span>
            Không có dữ liệu
        </span>
    </c:if>
    <c:if test="${f:length(listNV) != 0}">
        <c:forEach items="${listNV}" var="nv">
            <tr>
                <td>${ nv.ma }</td>
                <td>${ nv.ho } ${ nv.tenDem } ${ nv.ten }</td>
                <td>${ nv.gioiTinh }</td>
                <td>${ nv.ngaySinh }</td>
                <td>${ nv.diaChi }</td>
                <td>${ nv.sdt }</td>
                <td>${ nv.matKhau }</td>
                <td>${ nv.trangThai == "0" ? "Đang làm việc" : "Đã nghỉ việc" }</td>
                <td>
                    <a class="btn btn-success" role="button" href="/demo_war_exploded/nhan-vien/edit?ma=${ nv.ma }">Cập nhật</a>
                    <a class="btn btn-danger" role="button" href="/demo_war_exploded/nhan-vien/delete?ma=${ nv.ma }">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<a class="btn btn-success" role="button" href="/demo_war_exploded/nhan-vien/create">Thêm mới</a>
<script src="/demo_war_exploded/js/bootstrap.js"></script>
</body>
</html>
