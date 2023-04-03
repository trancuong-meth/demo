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
    <title>Danh sách cửa hàng</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.css">

</head>
<body class="container">
<section>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Khác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${f:length(listCH) == 0}">
            <span>
                Không có dữ liệu
            </span>
        </c:if>
        <c:if test="${f:length(listCH) != 0}">
            <c:forEach items="${ listCH }" var="ch">
                <tr>
                    <td>${ ch.ma }</td>
                    <td>${ ch.ten }</td>
                    <td>${ ch.diaChi}</td>
                    <td>${ ch.thanhPho}</td>
                    <td>${ ch.quocGia}</td>
                    <td>
                        <a class="btn btn-success" role="button" href="/demo_war_exploded/cua-hang/edit?ma=${ ch.ma }">Cập nhật</a>
                        <a class="btn btn-danger" role="button" href="/demo_war_exploded/cua-hang/delete?ma=${ ch.ma }">Xoá</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <a class="btn btn-success" role="button" href="/demo_war_exploded/cua-hang/create">Thêm mới</a>
</section>

<script src="/demo_war_exploded/js/bootstrap.js"></script>
</body>
</html>
