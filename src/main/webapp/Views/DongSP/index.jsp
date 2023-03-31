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
    <title>Danh sách dòng sản phẩm</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.css">
</head>
<body class="container">
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(listDSP) == 0}">
        <span>
            Không có dữ liệu
        </span>
    </c:if>
    <c:if test="${f:length(listDSP) != 0}">
        <c:forEach items="${listDSP}" var="dsp">
            <tr>
                <td>${ dsp.ma }</td>
                <td>${ dsp.ten }</td>
                <td>
                    <a class="btn btn-success" role="button" href="/demo_war_exploded/dong-san-pham/edit?ma=${ dsp.ma }">Cập nhật</a>
                    <a class="btn btn-danger" role="button" href="/demo_war_exploded/dong-san-pham/delete?ma=${ dsp.ma }">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<a class="btn btn-success" role="button" href="/demo_war_exploded/dong-san-pham/create">Thêm mới</a>
<script src="/demo_war_exploded/js/bootstrap.js"></script>
</body>
</html>
