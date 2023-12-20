<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.security.Principal" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html>
<html lang="zxx">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quần áo nam 5S | Sản phẩm</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Css Styles -->
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
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__option">
        <div class="offcanvas__links">
            <a href="#">Sign in</a>
            <a href="#">FAQs</a>
        </div>
        <div class="offcanvas__top__hover">
            <span>Usd <i class="arrow_carrot-down"></i></span>
            <ul>
                <li>USD</li>
                <li>EUR</li>
                <li>USD</li>
            </ul>
        </div>
    </div>
    <div class="offcanvas__nav__option">
        <a href="#" class="search-switch"><img src="../mainshop/mainshop2/img/icon/search.png" alt=""></a>
        <a href="#"><img src="../mainshop/mainshop2/img/icon/heart.png" alt=""></a>
        <a href="#"><img src="../mainshop/mainshop2/img/icon/cart.png" alt=""> <span>0</span></a>
    </div>
    <div id="mobile-menu-wrap"></div>
    <div class="offcanvas__text">
        <p>Free shipping, 30-day return or refund guarantee.</p>
    </div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
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
                                <!-- Nếu đã đăng nhập, hiển thị tên người dùng và nút đăng xuất -->
                                <div style="display: flex; align-items: center;">
                                    <span style="color: white;">Xin chào, <%= request.getUserPrincipal().getName() %>!</span>
                                    <form action="/logout" method="post" style="margin-left: 10px;">
                                        <input type="submit" value="Đăng xuất">
                                    </form>
                                </div>
                            </sec:authorize>

                            <sec:authorize access="!hasRole('ROLE_USER')">
                                <!-- Nếu chưa đăng nhập, hiển thị liên kết Đăng nhập -->
                                <div>
                                    <a href="/login" style="color: white;">Đăng nhập</a>
                                </div>
                            </sec:authorize>
                        </div>
                        <%--                            <div class="header__top__hover">--%>
                        <%--                                <span>Usd <i class="arrow_carrot-down"></i></span>--%>
                        <%--                                <ul>--%>
                        <%--                                    <li>USD</li>--%>
                        <%--                                    <li>EUR</li>--%>
                        <%--                                    <li>USD</li>--%>
                        <%--                                </ul>--%>
                        <%--                            </div>--%>
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
</header>
<!-- Header Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Shop</h4>
                    <div class="breadcrumb__links">
                        <a href="/shop/main-shop">Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="shop__sidebar">
                    <div class="shop__sidebar__search">
                       <form id="seachForm">
                            <input type="text" placeholder="Search..." name="tensanpham">
                            <button type="button" onclick="submitForm()"><span class="icon_search"></span></button>
                        </form>
                    </div>
                    <div class="shop__sidebar__accordion">
                        <div class="accordion" id="accordionExample">

                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseTwo">Thương hiệu</a>
                                </div>
                                <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__brand">
                                           <ul>
                                                <li><a href="/list-san-pham/page?page=1&thuonghieuid=1&sizeid=&tensanpham=&minPrice=&maxPrice=">Louis Vuitton</a></li>
                                                <li><a href="/list-san-pham/page?page=1&thuonghieuid=2&sizeid=&tensanpham=&minPrice=&maxPrice=">Chanel</a></li>
                                                <li><a href="/list-san-pham/page?page=1&thuonghieuid=3&sizeid=&tensanpham=&minPrice=&maxPrice=">Hermes</a></li>
                                                <li><a href="/list-san-pham/page?page=1&thuonghieuid=4&sizeid=&tensanpham=&minPrice=&maxPrice=">Gucci</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseThree">Giá</a>
                                </div>
                                <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__price">
                                         <ul>
                                                <li><a href="/list-san-pham/page?page=1&minPrice=0&maxPrice=50000">0Đ -
                                                    50,000Đ</a></li>
                                                <li>
                                                    <a href="/list-san-pham/page?page=1&minPrice=50000&maxPrice=100000">
                                                        50,000Đ - 100,000Đ
                                                    </a>
                                                </li>

                                                <li><a href="/list-san-pham/page?page=1&minPrice=100000&maxPrice=150000">100,000Đ - 150,000Đ</a></li>
                                                <li><a href="/list-san-pham/page?page=1&minPrice=150000&maxPrice=200000">150,000Đ - 200,000Đ</a></li>
                                                <li><a href="/list-san-pham/page?page=1&minPrice=200000&maxPrice=250000">200,000Đ - 250,000Đ</a></li>
                                                <li><a href="/list-san-pham/page?page=1&minPrice=250000&maxPrice=10000000">250,000+</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseFour">Size</a>
                                </div>
                                <div id="collapseFour" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                       <div class="shop__sidebar__size">
                                            <label for="xs">xs
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=1&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="xs">
                                                </a>
                                            </label>
                                            <label for="sm">sm
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=2&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="sm">
                                                </a>

                                            </label>
                                            <label for="md">m
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=3&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="md">
                                                </a>
                                            </label>
                                            <label for="xl">xl
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=4&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="xl">
                                                </a>

                                            </label>
                                            <label for="2xl">2xl
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=5&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="2xl">
                                                </a>

                                            </label>
                                            <label for="xxl">xxl
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=6&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="xxl">
                                                </a>

                                            </label>
                                            <label for="3xl">3xl
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=7&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="3xl">
                                                </a>

                                            </label>
                                            <label for="4xl">4xl
                                                <a href="/list-san-pham/page?page=1&thuonghieuid=&sizeid=8&tensanpham=${tensanpham}&minPrice=&maxPrice=">
                                                    <input id="4xl">
                                                </a>

                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="shop__product__option">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
<%--                            <div class="shop__product__option__left">--%>
<%--                                <p id="pagination-info">Showing ${Math.min(itemsPerPage, totalItems)} of ${totalItems}</p>--%>


<%--                            </div>--%>
                        </div>
<%--                        <div class="col-lg-6 col-md-6 col-sm-6">--%>
<%--                            <div class="shop__product__option__right">--%>
<%--                                <p>Sort by Price:</p>--%>
<%--                                <select>--%>
<%--                                    <option value="">Low To High</option>--%>
<%--                                    <option value="">$0 - $55</option>--%>
<%--                                    <option value="">$55 - $100</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                </div>
                <!-- Sản Phẩm -->
                <div class="row">
                        <c:forEach items="${listSanPham}" var="sp">
                            <div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="/getimage/${sp.hinhAnhURL}">
                                        <ul class="product__hover">
                                            <li><a href="/danh-sach-yt/them/${sp.sanPhamID}"><img src="../mainshop/mainshop2/img/icon/heart.png" alt=""></a>
                                            </li>
                                            <li><a href="/san-pham-detail/${sp.sanPhamID}"><img src="../mainshop/mainshop2/img/icon/search.png" alt=""></a>
                                            </li>
                                            <div class="size">
                                                <span class="highlight-background">${sp.size.tenSize}</span>
                                            </div>
                                            <div class="color">
                                                <span class="highlight-background">${sp.mauSac.tenMauSac}</span>
                                            </div>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6>${sp.tenSanPham}</h6>
                                        <a  class="add-cart" href="/san-pham-detail/${sp.sanPhamID}">+ Add To Cart</a>

                                        <h5>
                                            <fmt:formatNumber value="${sp.giaSanPham}" pattern="#,##0"/> VND
                                        </h5>
                                        <style>
                                        .highlight-background {
                                        background-color: #000; /* Màu nền đậm (đen) */
                                        color: #fff; /* Màu chữ trắng */
                                        padding: 5px 10px; /* Kích thước padding */
                                        border-radius: 5px; /* Bo tròn góc */
                                        display: inline-block; /* Đảm bảo nền chỉ chiếm chiều rộng của văn bản */
                                        }</style>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <!-- Sản phẩm -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product__pagination">
                        <c:if test="${totalItems > itemsPerPage}">
                                    <c:if test="${currentPage > 1}">
                                        <a href="/list-san-pham/page?page=${currentPage - 1}&thuonghieuid=${thuonghieuid}&sizeid=${sizeid}&tensanpham=${tensanpham}&minPrice=${minPrice}&maxPrice=${maxPrice}">&lt;</a>
                                    </c:if>

                                    <c:forEach begin="${currentPage - 1}" end="${currentPage + 1}" var="pageNumber">
                                        <c:if test="${pageNumber > 0 and pageNumber <= totalPages}">
                                            <c:choose>
                                                <c:when test="${pageNumber == currentPage}">
                                                    <a class="active">${pageNumber}</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="/list-san-pham/page?page=${pageNumber}&thuonghieuid=${thuonghieuid}&sizeid=${sizeid}&tensanpham=${tensanpham}&minPrice=${minPrice}&maxPrice=${maxPrice}">${pageNumber}</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </c:forEach>

                                    <c:if test="${currentPage < totalPages}">
                                        <a href="/list-san-pham/page?page=${currentPage + 1}&thuonghieuid=${thuonghieuid}&sizeid=${sizeid}&tensanpham=${tensanpham}&minPrice=${minPrice}&maxPrice=${maxPrice}">&gt;</a>
                                    </c:if>
                                </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Section End -->

<!-- Footer Section Begin -->
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
                        <li><a href="#">Return & Exchanges</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                <div class="footer__widget">
                    <h6>NewLetter</h6>
                    <div class="footer__newslatter">
                        <p>Be the first to know about new arrivals, look books, sales & promos!</p>
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
                        </script>
                        2020
                        All rights reserved | This template is made with <i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i> by <a
                                href="https://colorlib.com" target="_blank">Colorlib</a>
                    </p>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch">+</div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search End -->

<!-- Js Plugins -->
<script src="../mainshop/mainshop2/js/jquery-3.3.1.min.js"></script>
<script src="../mainshop/mainshop2/js/bootstrap.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.nice-select.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.nicescroll.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.magnific-popup.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.countdown.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.slicknav.js"></script>
<script src="../mainshop/mainshop2/js/mixitup.min.js"></script>
<script src="../mainshop/mainshop2/js/owl.carousel.min.js"></script>
<script src="../mainshop/mainshop2/js/main.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        const urlParams = new URLSearchParams(window.location.search);
        const itemsPerPage = 9; 
        const totalItems = 28;

        const currentPage = parseInt(urlParams.get('page')) || 1;

        const startItem = (currentPage - 1) * itemsPerPage + 1;
        const endItem = Math.min(currentPage * itemsPerPage, totalItems);

        const paginationInfo = document.getElementById('pagination-info');
        paginationInfo.textContent = `Showing ${startItem} - ${endItem} of ${totalItems}`;
    });
</script>
<script>
    function submitForm() {
        var tensanpham = document.getElementsByName("tensanpham")[0].value;
        if (tensanpham.trim() !== "") {
            var url = "/list-san-pham/page?page=1" +
                "&thuonghieuid=" +
                "&sizeid=" +
                "&tensanpham=" + encodeURIComponent(tensanpham) +
                "&minPrice=" +
                "&maxPrice=";
            window.location.href = url;
        } else {
            alert("Please enter a search term.");
        }
    }
</script>
</body>

</html>
