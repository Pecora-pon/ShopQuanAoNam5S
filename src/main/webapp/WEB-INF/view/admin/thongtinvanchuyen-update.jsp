<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.security.Principal" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template - Pro | v1.0.0
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
-->
<!-- beautify ignore:start -->
<html
        class="light-style layout-menu-fixed"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="../admin/assets/"
        data-template="vertical-menu-template-free"
>
<head>
    <meta charset="UTF-8"/>

    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Thông tin vận chuyển</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="../admin/assets/img/favicon/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="../admin/assets/vendor/fonts/boxicons.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Core CSS -->
    <link rel="stylesheet" href="../admin/assets/vendor/css/core.css" class="template-customizer-core-css"/>
    <link rel="stylesheet" href="../admin/assets/vendor/css/theme-default.css" class="template-customizer-theme-css"/>
    <link rel="stylesheet" href="../admin/assets/css/demo.css"/>

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="../admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>

    <link rel="stylesheet" href="../admin/assets/vendor/libs/apex-charts/apex-charts.css"/>

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="../admin/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="../admin/assets/js/config.js"></script>
    <link rel="stylesheet" href="../mainshop/mainshop2/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../mainshop/mainshop2/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../mainshop/mainshop2/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../mainshop/mainshop2/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="../mainshop/mainshop2/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../mainshop/mainshop2/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../mainshop/mainshop2/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../mainshop/mainshop2/css/style.css" type="text/css">
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->


        <!-- / Menu -->

        <!-- Layout container -->
        <div class="container-fluid">
            <!-- Navbar -->
        <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-7">
                            <div class="header__top__left">
                                <p>Miễn phí vận chuyển, 30-ngày trả lại hoặc hoàn tiền.</p>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-5">
                            <div class="header__top__right">
                                <div class="header__top__links">
                                    <sec:authorize access="hasRole('ROLE_USER')">
                                        <div style="display: flex; align-items: center;">
                                            <span style="color: white;">Xin chào, <%= request.getUserPrincipal().getName() %>!</span>
                                            <form action="/logout" method="post" style="margin-left: 10px;">
                                                <input type="submit" value="Đăng xuất">
                                            </form>
                                        </div>
                                    </sec:authorize>

                                    <sec:authorize access="!hasRole('ROLE_USER')">
                                        <div>
                                            <a href="/login" style="color: white;">Đăng nhập</a>
                                        </div>
                                    </sec:authorize>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-3">
                        <div class="header__logo">
                            <a href="/shop/main-shop"><img src="../mainshop/mainshop2/img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li class="active"><a href="/shop/main-shop">Trang chủ</a></li>
                                <li><a href="/list-san-pham/page">Shop</a></li>
                                <li><a href="#">Tìm hiểu thêm</a>
                                    <ul class="dropdown">
                                        <li><a href="/shop/about">Về chúng tôi</a></li>
                                        <li><a href="/gio-hang">Giỏ hàng</a></li>
                                        <li><a href="/shop/blog">Blog</a></li>
                                    </ul>
                                </li>
                                <li><a href="/shop/blog">Blog</a></li>
                                <li><a href="/shop/lien-he">Liên hệ</a></li>
                            </ul>
                        </nav>

                    </div>
                    <div class="col-lg-3 col-md-3">
                        <div class="header__nav__option">
                            <%--                    <a href="/list-san-pham/ten-san-pham/" class="search-switch"><img src="../mainshop/mainshop2/img/icon/search.png" alt=""></a>--%>
                            <a href="/danh-sach-yt/hien-thi"><img src="../mainshop/mainshop2/img/icon/heart.png" alt=""></a>
                            <a href="/gio-hang"><img src="../mainshop/mainshop2/img/icon/cart.png" alt=""> <span>0</span></a>
                        </div>
                    </div>
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>


            <!-- / Navbar -->

            <!-- Content wrapper -->
            <div class="content-wrapper">
                <div class="container-xxl flex-grow-1 container-p-y">
                    <!--Content -->
                    <!--Table add -->
                    <div class="card">
                        <div class="card-body">
                            <form:form action="/thong-tin-van-chuyen/update/${ttvc.thongTinVanChuyenID}" modelAttribute="ttvc" method="POST">
                                <div class="row">
                                    <div class="mb-3 col-md-6">
                                        <label class="form-label">ID Vận Chuyển</label>
                                        <form:input class="form-control" path="thongTinVanChuyenID" disabled="true" value="${ttvc.thongTinVanChuyenID}"/>

                                    </div>
                                    <div class="mb-3 col-md-6">
                                        <label class="form-label">Địa Chỉ</label>
                                        <form:input class="form-control" path="diaChi" value="${ttvc.diaChi}"/>
                                        <form:errors path="diaChi"/>
                                    </div>
                                    <div class="mb-3 col-md-6">
                                        <label class="form-label">Phương Thức</label>
                                        <form:input class="form-control" path="phuongThuc" value="${ttvc.phuongThuc}"/>
                                        <form:errors path="phuongThuc"/>
                                    </div>
                                    <div class="mb-3 col-md-6">
                                        <label class="form-label">Trạng Thái</label>
                                        <form:input class="form-control" path="trangThai" value="${ttvc.trangThai}"/>
                                        <form:errors path="trangThai"/>
                                    </div>
                                </div>
                                <div class="mt-2">
                                    <button type="submit" class="btn btn-primary me-2">Sửa</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                    <hr class="my-3">
                    <!--Table add -->

                    <div class="card">
                        <form>
                            <div class="mb-3 col-md-6">
                                <div class="input-group">
                                    <input type="search" name="keyword" class="form-control rounded" placeholder="Nhập dia chi" aria-label="Search" aria-describedby="search-addon" />
                                    <button type="submit" class="btn btn-outline-primary">search</button>
                                </div>
                            </div>
                        </form>
                        <br>
                        <h5 class="card-header">Quản lý thông tin vận chuyển</h5>
                        <table class="table">
                            <thead>
                            <tr>
                                <th> ID Vận Chuyển</th>
                                <th>Địa chỉ</th>
                                <th>Phương thức</th>
                                <th>Trạng thái</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody class="table-border-bottom-0">
                            <c:forEach items="${listThongTinVanChuyen}" var="thongtinvanchuyen">
                                <tr>
                                    <td>${thongtinvanchuyen.thongTinVanChuyenID}</td>
                                    <td>${thongtinvanchuyen.diaChi}</td>
                                    <td>${thongtinvanchuyen.phuongThuc}</td>
                                    <td>${thongtinvanchuyen.trangThai}</td>
                                    <td>
                                        <div class="dropdown">
                                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                                <i class="bx bx-dots-vertical-rounded"></i>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="/thong-tin-van-chuyen-view-update/${thongtinvanchuyen.thongTinVanChuyenID}"><i class="bx bx-edit-alt me-1"></i> Sửa</a>
                                                <a class="dropdown-item" href="/thong-tin-van-chuyen/delete/${thongtinvanchuyen.thongTinVanChuyenID}"><i class="bx bx-trash me-1"></i> Xóa</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>


                    </div>
                    <!--Content -->

                    <!--Footer -->

                    <!--Footer -->
                </div>
            </div>
            <!-- Content wrapper -->
            <footer class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="footer__about">
                                <div class="footer__logo">
                                    <a href="#"><img src="../mainshop/mainshop2/img/logo.png" alt=""></a>
                                </div>
                                <p>The customer is at the heart of our unique business model, which includes design.</p>
                                <a href="#"><img src="../mainshop/mainshop2/img/payment.png" alt=""></a>
                            </div>
                        </div>
                        <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                            <div class="footer__widget">
                                <h6>Shopping</h6>
                                <ul>
                                    <li><a href="#">Clothing Store</a></li>
                                    <li><a href="#">Trending Shoes</a></li>
                                    <li><a href="#">Accessories</a></li>
                                    <li><a href="#">Sale</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-3 col-sm-6">
                            <div class="footer__widget">
                                <h6>Shopping</h6>
                                <ul>
                                    <li><a href="#">Contact Us</a></li>
                                    <li><a href="#">Payment Methods</a></li>
                                    <li><a href="#">Delivary</a></li>
                                    <li><a href="#">Return &amp; Exchanges</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                            <div class="footer__widget">
                                <h6>NewLetter</h6>
                                <div class="footer__newslatter">
                                    <p>Be the first to know about new arrivals, look books, sales &amp; promos!</p>
                                    <form action="#">
                                        <input type="text" placeholder="Your email">
                                        <button type="submit"><span class="icon_mail_alt"></span></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="footer__copyright__text">
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                <p>Copyright ©
                                    <script>
                                        document.write(new Date().getFullYear());
                                    </script>20232020
                                    All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                </p>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </div>
                        </div>
                    </div>
                </div>
            </footer>

        </div>
        <!-- / Layout page -->
    </div>

    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
</div>
<!-- / Layout wrapper -->


<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="../admin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="../admin/assets/vendor/libs/popper/popper.js"></script>
<script src="../admin/assets/vendor/js/bootstrap.js"></script>
<script src="../admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="../admin/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->
<script src="../admin/assets/vendor/libs/apex-charts/apexcharts.js"></script>

<!-- Main JS -->
<script src="../admin/assets/js/main.js"></script>

<!-- Page JS -->
<script src="../admin/assets/js/dashboards-analytics.js"></script>

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>
