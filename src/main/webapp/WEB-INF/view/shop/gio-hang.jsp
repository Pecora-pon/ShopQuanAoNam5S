<!DOCTYPE html>
<html lang="zxx">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.security.Principal" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>5S-Fashion | Giỏ hàng</title>
    <link rel="icon" type="image/x-icon" href="../admin/assets/img/favicon/favicon.ico"/>

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
    <link rel="stylesheet" href="../admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>

    <link rel="stylesheet" href="../admin/assets/vendor/libs/apex-charts/apex-charts.css"/>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
          rel="stylesheet">
    <script src="../admin/assets/vendor/js/helpers.js"></script>
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
        <a href="#"><img
                src="../../../../../../../mainshop/mainshop2/malefashion-master/malefashion-master/img/icon/heart.png"
                alt=""></a>
        <a href="#"><img
                src="../../../../../../../mainshop/mainshop2/malefashion-master/malefashion-master/img/icon/cart.png"
                alt=""> <span>0</span></a>
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
    <!-- Header Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Shopping Cart</h4>
                        <div class="breadcrumb__links">
                            <a href="/shop/main-shop">Home</a>
                            <a href="/list-san-pham/page">Shop</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    <a href="/dangxem" class="primary-btn">Xem Đơn Hang</a>
    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="shopping__cart__table">


                        <table>
                            <thead>
                            <tr>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>Total</th>

                                <th></th>
                            </tr>
                            </thead>
                            <form method="post" action="/list-gh" onsubmit="return validateQuantity()">
                                <c:forEach items="${listGioHang}" var="gh">
                                    <tbody>
                                    <tr>
                                        <td class="product__cart__item">
                                            <div class="product__cart__item__pic">
                                                <img src="/getimage/${gh.sanPham.hinhAnhURL}"
                                                     style="max-height: 60px; max-height: 60px;">
                                            </div>
                                            <div class="product__cart__item__text">
                                                <h6>${gh.sanPham.tenSanPham}</h6>
                                                <p>Giá:
                                                    <c:choose>
                                                        <c:when test="${gh.sanPham.giaSanPham >= 1000000}">
                                                            <fmt:formatNumber value="${gh.sanPham.giaSanPham / 1000000}" pattern="#,##0.### triệu đ"/>
                                                        </c:when>
                                                        <c:when test="${gh.sanPham.giaSanPham >= 1000}">
                                                            <fmt:formatNumber value="${gh.sanPham.giaSanPham / 1000}" pattern="#,##0.### nghìn đ"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <fmt:formatNumber value="${gh.sanPham.giaSanPham}" pattern="#,##0 đ"/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </p>

                                                <div class="color-size-info">
                                                    <p>Kích thước: ${gh.sanPham.size.tenSize}</p>
                                                    <p>Màu sắc: ${gh.sanPham.mauSac.tenMauSac}</p>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="quantity__item">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" id="soLuongDat_${gh.gioHangID}" name="soLuongDat_${gh.gioHangID}" value="${gh.soLuongDat}"
                                                           data-available-stock="${gh.sanPham.soLuongTon}" oninput="updateTotal(${gh.gioHangID}, ${gh.sanPham.giaSanPham}, this.value)"
                                                           class="custom-input">
                                                </div>
                                            </div>
                                        </td>
                                        <style>
                                            .custom-input {
                                                width: 50px;
                                                padding: 8px;
                                                border: 1px solid #ccc;
                                                border-radius: 4px;
                                                box-sizing: border-box;
                                                font-size: 14px;
                                            }
                                        </style>
                                        <td class="cart__price" id="tongTien_${gh.gioHangID}">
                                            <fmt:formatNumber value="${gh.tongTien}" pattern="#,##0"/> <đ></đ>
                                            <script>
                                                function updateTotal(gioHangID, giaSanPham, soLuongDat) {
                                                    var tongTien = giaSanPham * soLuongDat;
                                                    var formattedTongTien = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(tongTien);
                                                    document.getElementById('tongTien_' + gioHangID).textContent = formattedTongTien;
                                                }
                                                function updateTotalOnPageLoad(gioHangID, giaSanPham, soLuongDat) {
                                                    updateTotal(gioHangID, giaSanPham, soLuongDat);
                                                }

                                                var gioHangID = "${gh.gioHangID}";
                                                var giaSanPham = ${gh.sanPham.giaSanPham};
                                                var soLuongDat = ${gh.soLuongDat};
                                                updateTotalOnPageLoad(gioHangID, giaSanPham, soLuongDat);
                                            </script>
                                        </td>



                                        <td>
                                            <div class="mt-2">
                                                <input type="checkbox" name="selectedItems" value="${gh.gioHangID}">
                                            </div>
                                            <span id="quantityError_${gh.gioHangID}" style="color: #ff0000;"></span>
                                            <div class="mt-2">
                                                <a class="dropdown-item" href="/deletedh/${gh.gioHangID}"><i
                                                        class="bx bx-trash me-1"></i></a>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <c:set var="totalPrice"
                                           value="${totalPrice + gh.sanPham.giaSanPham * gh.soLuongDat}"/>
                                </c:forEach>

                                <button type="submit" class="btn btn-success btn-sm">Apply</button>
                            </form>
                        </table>
                    </div>
                    <script>
                        function updateTotal(gioHangID, giaSanPham) {
                            var quantityInput = document.getElementById("soLuongDat_" + gioHangID);
                            var totalAmountElement = document.getElementById("tongTien_" + gioHangID);
                            var currentQuantity = parseInt(quantityInput.value) || 0;
                            currentQuantity = Math.max(0, currentQuantity);
                            quantityInput.value = currentQuantity;
                            var totalPrice = currentQuantity * giaSanPham;
                            var formattedTotalPrice = new Intl.NumberFormat('vi-VN', { style: 'decimal', minimumFractionDigits: 0, maximumFractionDigits: 0 }).format(totalPrice);
                            formattedTotalPrice += ' đ</đ>';
                            totalAmountElement.innerHTML = formattedTotalPrice;
                        }
                    </script>

                    <script>
                        function validateQuantity() {
                            var isValid = true;
                            var checkboxes = document.getElementsByName("selectedItems");
                            var isChecked = false;

                            for (var i = 0; i < checkboxes.length; i++) {
                                if (checkboxes[i].checked) {
                                    isChecked = true;

                                    // Accessing the corresponding quantity input and error span
                                    var quantityInput = document.getElementById("soLuongDat_" + checkboxes[i].value);
                                    var quantityError = document.getElementById("quantityError_" + checkboxes[i].value);

                                    // Extracting the available stock and ordered quantity
                                    var availableStock = parseInt(quantityInput.getAttribute("data-available-stock"));
                                    var orderedQuantity = parseInt(quantityInput.value);

                                    // Validating the quantity
                                    if (orderedQuantity > availableStock) {
                                        quantityError.innerHTML = "Số lượng đặt vượt quá số lượng tồn kho. Chỉ còn " + availableStock + " sản phẩm";
                                        isValid = false;
                                    } else if (orderedQuantity <= 0) {
                                        quantityError.innerHTML = "Số lượng đặt phải từ 1 trở lên.";
                                        isValid = false;
                                    } else {
                                        quantityError.innerHTML = "";
                                    }
                                }
                            }

                            if (!isChecked) {
                                alert("Vui lòng chọn ít nhất một sản phẩm.");
                                return false;
                            }

                            return isValid;
                        }
                    </script>

                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn">
                                <a href="/list-san-pham/page">Continue Shopping</a>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn update__btn">
                                <a href="/gio-hang"><i class="fa fa-spinner"></i> Update cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <%--                    <div class="cart__discount">--%>
                    <%--                        <h6>Discount codes</h6>--%>
                    <%--                        <form action="#">--%>
                    <%--                            <input type="text" placeholder="Coupon code">--%>
                    <%--                            <button type="submit">Apply</button>--%>
                    <%--                        </form>--%>
                    <%--                    </div>--%>
                    <div class="cart__total">
                        <h6>Tổng tiền trong giỏ hàng</h6>
                        <ul>
                            <li>Tổng tiền <span>
    <c:choose>
        <c:when test="${totalPrice >= 1000000}">
            <fmt:formatNumber value="${totalPrice / 1000000}" pattern="#,##0.###"/> triệu VNĐ
        </c:when>
        <c:when test="${totalPrice >= 1000}">
            <fmt:formatNumber value="${totalPrice / 1000}" pattern="#,##0.###"/> nghìn VNĐ
        </c:when>
        <c:otherwise>
            <fmt:formatNumber value="${totalPrice}" pattern="#,##0"/> VNĐ
        </c:otherwise>
    </c:choose>
</span></li>

                        </ul>
                        <%--                        <a href="#" class="primary-btn">Proceed to checkout</a>--%>
                    </div>

                        <form action="/gio-hang/detail" method="get" class="d-flex align-items-center">
                            <label class="me-2">Tên Sản Phẩm:</label>
                            <input type="text" name="tenSanPham" class="form-control" required>
                            <button type="submit" class="btn btn-primary ms-2">Tìm Kiếm</button>
                        </form>
                </div>
            </div>  <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${totalPages}" var="page">
                    <c:choose>
                        <c:when test="${page == currentPage}">
                            <li class="page-item active"><span class="page-link">${page}</span></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="/gio-hang/page?page=${page}">${page}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ul>
        </nav>
        </div>
    </section>
    <!-- Shopping Cart Section End -->

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

</body>

</html>