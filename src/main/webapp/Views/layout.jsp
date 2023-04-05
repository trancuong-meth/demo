<%--
  Created by IntelliJ IDEA.
  User: Tran Tuan Cuong
  Date: 22/3/2023
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="/demo_war_exploded/css/bootstrap.min.css"/>
</head>
<body class="container">
<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/khach-hang/index">Khách hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/chuc-vu/index">Chức vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/mau-sac/index">Màu sắc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/nsx/index">Nhà sản xuất</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/cua-hang/index">Cửa hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/san-pham/index">Sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/nhan-vien/index">Nhân viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/dong-san-pham/index">Dòng sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/demo_war_exploded/hoa-don/index">Hoá đơn</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="row">
        <div class="col-2 bg-dark-subtle justify-content-center">Cuongttph25500</div>
        <div class="col-10" style="min-height: 600px">
            <jsp:include page="${ views }"></jsp:include>
        </div>
    </div>
</main>

<footer>
    <div class="row bg-light-subtle justify-content-center">
        FPT POLYTECHNIC
    </div>
</footer>
<script src="/demo_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
