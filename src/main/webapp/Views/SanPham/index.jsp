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
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.css">
</head>
<body class="container">
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Khác</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(listSP) == 0}">
        <span>
            Không có dữ liệu
        </span>
    </c:if>
    <c:if test="${f:length(listSP) != 0}">
        <c:forEach items="${listSP}" var="sp">
            <tr>
                <td>${ sp.ma }</td>
                <td>${ sp.ten }</td>
                <td>
                    <a class="btn btn-success" role="button" href="/demo_war_exploded/san-pham/edit?ma=${ sp.ma }">Cập nhật</a>
                    <a class="btn btn-danger" role="button" href="/demo_war_exploded/san-pham/delete?ma=${ sp.ma }">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<a class="btn btn-success" role="button" href="/demo_war_exploded/san-pham/create">Thêm mới</a>
<script src="/demo_war_exploded/js/bootstrap.js"></script>
</body>
</html>
