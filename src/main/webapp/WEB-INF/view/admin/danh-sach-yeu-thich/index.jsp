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
    <style>
        .row {
            display: flex;
            flex-wrap: wrap;
        }

        .product__item {
            flex: 0 0 calc(33.333% - 20px); /* Điều chỉnh chiều rộng theo ý muốn */
            margin: 10px;
        }
    </style>
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
        <div class="price">$0.00</div>
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
                    <a href="./index.html"><img src="../mainshop/mainshop2/img/logo.png" alt=""></a>
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
                                <li><a href="gio-hang.jsp">Giỏ hàng</a></li>
                                <li><a href="./blog-details.html">Blog</a></li>
                            </ul>
                        </li>
                        <li><a href="./blog.html">Blog</a></li>
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
                        <span>Yêu Thích</span>
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
                        <form action="" id="productSearchForm">
                            <input type="text" id="searchInput" placeholder="Tìm kiếm...">
                            <button type="button" onclick="searchProducts()"><span class="icon_search"></span></button>
                        </form>
                    </div>
<%--                    <div class="shop__sidebar__accordion">--%>
<%--                        <div class="accordion" id="accordionExample">--%>

<%--                            <div class="card">--%>
<%--                                <div class="card-heading">--%>
<%--                                    <a data-toggle="collapse" data-target="#collapseTwo">Branding</a>--%>
<%--                                </div>--%>
<%--                                <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">--%>
<%--                                    <div class="card-body">--%>
<%--                                        <div class="shop__sidebar__brand">--%>
<%--                                            <ul>--%>
<%--                                                <li><a href="/list-san-pham/page?thuonghieuid=1">Louis Vuitton</a></li>--%>
<%--                                                <li><a href="/list-san-pham/page?thuonghieuid=2">Chanel</a></li>--%>
<%--                                                <li><a href="/list-san-pham/page?thuonghieuid=3">Hermes</a></li>--%>
<%--                                                <li><a href="/list-san-pham/page?thuonghieuid=4">Gucci</a></li>--%>
<%--                                            </ul>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseThree">Filter Price</a>
                                </div>
                                <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <div class="shop__sidebar__price">
                                            <ul>
                                                <li><a href="javascript:void(0);" onclick="filterProductsByPrice(0, 50000)">0Đ -
                                                    50000Đ</a></li>
                                                <li><a href="javascript:void(0);" onclick="filterProductsByPrice(50000, 100000)">50000Đ - 100000Đ</a></li>
                                                <li><a href="javascript:void(0);" onclick="filterProductsByPrice(100000, 150000)">100000Đ - 150000Đ</a></li>
                                                <li><a href="javascript:void(0);" onclick="filterProductsByPrice(150000, 200000)">150000Đ - 200000Đ</a></li>
                                                <li><a href="javascript:void(0);" onclick="filterProductsByPrice(200000, 250000)">200000Đ - 250000Đ</a></li>
                                                <li><a href="javascript:void(0);" onclick="filterProductsByPrice(250000, 10000000)">250000+</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
<%--                            <div class="card">--%>
<%--                                <div class="card-heading">--%>
<%--                                    <a data-toggle="collapse" data-target="#collapseFour">Size</a>--%>
<%--                                </div>--%>
<%--                                <div id="collapseFour" class="collapse show" data-parent="#accordionExample">--%>
<%--                                    <div class="card-body">--%>
<%--                                        <div class="shop__sidebar__size">--%>
<%--                                            <label for="xs">xs--%>
<%--                                                <a href="/list-san-pham/page?sizeid=0">--%>
<%--                                                    <input id="xs">--%>
<%--                                                </a>--%>
<%--                                            </label>--%>
<%--                                            <label for="sm">s--%>
<%--                                                <a href="/list-san-pham/page?sizeid=1">--%>
<%--                                                    <input id="sm">--%>
<%--                                                </a>--%>

<%--                                            </label>--%>
<%--                                            <label for="md">m--%>
<%--                                                <a href="/list-san-pham/page?sizeid=2">--%>
<%--                                                    <input id="md">--%>
<%--                                                </a>--%>
<%--                                            </label>--%>
<%--                                            <label for="xl">xl--%>
<%--                                                <a href="/list-san-pham/page?sizeid=3">--%>
<%--                                                    <input id="xl">--%>
<%--                                                </a>--%>

<%--                                            </label>--%>
<%--                                            <label for="2xl">2xl--%>
<%--                                                <a href="/list-san-pham/page?sizeid=4">--%>
<%--                                                    <input id="2xl">--%>
<%--                                                </a>--%>

<%--                                            </label>--%>
<%--                                            <label for="xxl">xxl--%>
<%--                                                <a href="/list-san-pham/page?sizeid=5">--%>
<%--                                                    <input id="xxl">--%>
<%--                                                </a>--%>

<%--                                            </label>--%>
<%--                                            <label for="3xl">3xl--%>
<%--                                                <a href="/list-san-pham/page?sizeid=6">--%>
<%--                                                    <input id="3xl">--%>
<%--                                                </a>--%>

<%--                                            </label>--%>
<%--                                            <label for="4xl">4xl--%>
<%--                                                <a href="/list-san-pham/page?sizeid=7">--%>
<%--                                                    <input id="4xl">--%>
<%--                                                </a>--%>

<%--                                            </label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="card">--%>
<%--                                <div class="card-heading">--%>
<%--                                    <a data-toggle="collapse" data-target="#collapseFive">Colors</a>--%>
<%--                                </div>--%>
<%--                                <div id="collapseFive" class="collapse show" data-parent="#accordionExample">--%>
<%--                                    <div class="card-body">--%>
<%--                                        <div class="shop__sidebar__color">--%>
<%--                                            <label class="c-1" for="sp-1">--%>
<%--                                                <input type="radio" id="sp-1">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-2" for="sp-2">--%>
<%--                                                <input type="radio" id="sp-2">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-3" for="sp-3">--%>
<%--                                                <input type="radio" id="sp-3">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-4" for="sp-4">--%>
<%--                                                <input type="radio" id="sp-4">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-5" for="sp-5">--%>
<%--                                                <input type="radio" id="sp-5">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-6" for="sp-6">--%>
<%--                                                <input type="radio" id="sp-6">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-7" for="sp-7">--%>
<%--                                                <input type="radio" id="sp-7">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-8" for="sp-8">--%>
<%--                                                <input type="radio" id="sp-8">--%>
<%--                                            </label>--%>
<%--                                            <label class="c-9" for="sp-9">--%>
<%--                                                <input type="radio" id="sp-9">--%>
<%--                                            </label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="card">--%>
<%--                                <div class="card-heading">--%>
<%--                                    <a data-toggle="collapse" data-target="#collapseSix">Tags</a>--%>
<%--                                </div>--%>
<%--                                <div id="collapseSix" class="collapse show" data-parent="#accordionExample">--%>
<%--                                    <div class="card-body">--%>
<%--                                        <div class="shop__sidebar__tags">--%>
<%--                                            <a href="#">Product</a>--%>
<%--                                            <a href="#">Bags</a>--%>
<%--                                            <a href="#">Shoes</a>--%>
<%--                                            <a href="#">Fashio</a>--%>
<%--                                            <a href="#">Clothing</a>--%>
<%--                                            <a href="#">Hats</a>--%>
<%--                                            <a href="#">Accessories</a>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="shop__product__option">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="shop__product__option__left">
                                <p>Showing ${itemsPerPage} of ${totalItems}</p>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
<%--                            <div class="shop__product__option__right">--%>
<%--                                <p>Sort by Price:</p>--%>
<%--                                <select>--%>
<%--                                    <option value="">Low To High</option>--%>
<%--                                    <option value="">$0 - $55</option>--%>
<%--                                    <option value="">$55 - $100</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
                        </div>
                    </div>
                </div>
                <!-- Sản Phẩm -->
                <div class="row" id="productContainer">

                      <c:forEach items="${listSanPham}" var="sp">
                          <div class="col-lg-4 col-md-6 col-sm-6">
                              <div class="product__item">
                                  <div class="product__item__pic set-bg" data-setbg="/getimage/${sp.sanPham.hinhAnhURL}">
                                      <ul class="product__hover">
                                          <li><a href="/danh-sach-yt/delete/${sp.danhSachSanPhamYeuThichID}"><img src="../mainshop/mainshop2/img/icon/heart.png" alt=""></a>
                                          </li>
                                          <li><a href="#"><img src="../mainshop/mainshop2/img/icon/compare.png" alt="">
                                              <span>Compare</span></a>
                                          </li>
                                          <li><a href="#"><img src="../mainshop/mainshop2/img/icon/search.png" alt=""></a>
                                          </li>
                                      </ul>
                                  </div>
                                  <div class="product__item__text">
                                      <h6>${sp.sanPham.tenSanPham}</h6>
                                      <a  class="add-cart" href="/san-pham-detail/${sp.sanPham.sanPhamID}">+ Add To Cart</a>
                                      <div class="rating">
                                          <i class="fa fa-star-o"></i>
                                          <i class="fa fa-star-o"></i>
                                          <i class="fa fa-star-o"></i>
                                          <i class="fa fa-star-o"></i>
                                          <i class="fa fa-star-o"></i>
                                      </div>
                                      <h5>
                                          <fmt:formatNumber value="${sp.sanPham.giaSanPham}" pattern="0"/> VND
                                      </h5>
                                      <div class="product__color__select">
                                          <label for="pc-4">
                                              <input type="radio" id="pc-4">
                                          </label>
                                          <label class="active black" for="pc-5">
                                              <input type="radio" id="pc-5">
                                          </label>
                                          <label class="grey" for="pc-6">
                                              <input type="radio" id="pc-6">
                                          </label>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </c:forEach>


                </div>
                <!-- Sản phẩm -->
<%--                <nav aria-label="Page navigation example">--%>
<%--                    <ul class="pagination">--%>
<%--                        <c:forEach begin="0" end="${totalPages}" var="page">--%>
<%--                            <c:choose>--%>
<%--                                <c:when test="${page == currentPage}">--%>
<%--                                    <li class="page-item active"><span class="page-link">${page}</span></li>--%>
<%--                                </c:when>--%>
<%--                                <c:otherwise>--%>
<%--                                    <li class="page-item"><a class="page-link"--%>
<%--                                                             href="/san-pham/page?page=${page}">${page}</a></li>--%>
<%--                                </c:otherwise>--%>
<%--                            </c:choose>--%>
<%--                        </c:forEach>--%>
<%--                    </ul>--%>
<%--                </nav>--%>
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
                        <a href="#"><img src="../mainshop/mainshop2/img/footer-logo.png" alt=""></a>
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
    function searchProducts() {
        // Lấy giá trị từ ô input
        var searchTerm = document.getElementById('searchInput').value.toLowerCase();

        // Lặp qua từng sản phẩm trong danh sách
        var productContainer = document.getElementById('productContainer');
        var products = document.querySelectorAll('.product__item');
        var foundProduct = null;

        products.forEach(function(product) {
            var productName = product.querySelector('h6').innerText.toLowerCase();

            // Tìm sản phẩm thỏa mãn điều kiện
            if (productName.includes(searchTerm)) {
                foundProduct = product;
            }
        });

        // Ẩn các sản phẩm không phù hợp và đưa sản phẩm tìm thấy lên đầu danh sách
        products.forEach(function(product) {
            if (product === foundProduct) {
                productContainer.insertBefore(product, productContainer.firstChild);
                product.style.display = 'block'; // Hiển thị sản phẩm tìm thấy
            } else {
                product.style.display = 'none'; // Ẩn sản phẩm không phù hợp
            }
        });
    }
</script>

<script>
    function filterProductsByPrice(minPrice, maxPrice) {
        // Lưu lại thứ tự ban đầu của các sản phẩm
        var productContainer = document.getElementById('productContainer');
        var originalOrder = Array.from(productContainer.children);

        // Lặp qua từng sản phẩm trong danh sách
        var products = document.querySelectorAll('.product__item');
        var foundProduct = null;

        // Ẩn các sản phẩm không phù hợp và tìm sản phẩm thỏa mãn điều kiện
        products.forEach(function(product) {
            // Lấy giá của sản phẩm
            var productPriceStr = product.querySelector('h5').innerText;
            var productPrice = parseFloat(productPriceStr.replace(/[^\d.]/g, '')); // Chuyển đổi chuỗi giá thành số

            // Ẩn sản phẩm không phù hợp
            if (productPrice < minPrice || productPrice > maxPrice) {
                product.style.display = 'none';
            } else {
                // Nếu sản phẩm thỏa mãn điều kiện, lưu lại và đưa lên đầu danh sách
                foundProduct = product;
                productContainer.insertBefore(product, productContainer.firstChild);
                product.style.display = 'block';
            }
        });

        // Sắp xếp lại sản phẩm dựa trên kết quả tìm kiếm
        var sortedProducts = Array.from(productContainer.children);
        sortedProducts.sort(function(a, b) {
            var indexA = originalOrder.indexOf(a);
            var indexB = originalOrder.indexOf(b);
            return indexA - indexB;
        });

        // Đặt lại thứ tự của các sản phẩm trong DOM
        productContainer.innerHTML = '';
        sortedProducts.forEach(function(product) {
            productContainer.appendChild(product);
        });
    }
</script>



</body>

</html>