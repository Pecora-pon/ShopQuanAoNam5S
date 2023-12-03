<!DOCTYPE html>
<html lang="zxx">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Male-Fashion | Template</title>
    <link rel="icon" type="image/x-icon" href="../admin/assets/img/favicon/favicon.ico"/>
    <title>Thông Báo Thành Công</title>--%>
    <%--    <!-- Thêm các tệp CSS của Bootstrap -->--%>
    <%--    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">--%>
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
        <a href="#"><img src="../../../../../../../mainshop/mainshop2/malefashion-master/malefashion-master/img/icon/heart.png" alt=""></a>
        <a href="#"><img src="../../../../../../../mainshop/mainshop2/malefashion-master/malefashion-master/img/icon/cart.png" alt=""> <span>0</span></a>
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
                        <p>Free shipping, 30-day return or refund guarantee.</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <a href="/logout">Sign in</a>
                            <a href="#">FAQs</a>
                        </div>
                        <div class="header__top__hover">
                            <span>Usd <i class="arrow_carrot-down"></i></span>
                            <ul>
                                <li>USD</li>
                                <li>EUR</li>
                                <li>USD</li>
                            </ul>
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
                    <a href="../mainshop/mainshop2/index.html"><img src="../../../../../../../malefashion-master/malefashion-master/img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li><a href="../mainshop/mainshop2/index.html">Home</a></li>
                        <li class="active"><a href="../mainshop/mainshop2/shop.html">Shop</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="../mainshop/mainshop2/about.html">About Us</a></li>
                                <li><a href="../mainshop/mainshop2/shop-details.html">Shop Details</a></li>
                                <li><a href="./gio-hang.jsp">Shopping Cart</a></li>
                                <li><a href="../mainshop/mainshop2/checkout.html">Check Out</a></li>
                                <li><a href="../mainshop/mainshop2/blog-details.html">Blog Details</a></li>
                            </ul>
                        </li>
                        <li><a href="../mainshop/mainshop2/blog.html">Blog</a></li>
                        <li><a href="../mainshop/mainshop2/contact.html">Contacts</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="#" class="search-switch"><img src="../mainshop/mainshop2/img/icon/search.png" alt=""></a>
                    <a href="#"><img src="../mainshop/mainshop2/img/icon/heart.png" alt=""></a>
                    <a href="/gio-hang"><img src="../mainshop/mainshop2/img/icon/cart.png" alt=""> <span>0</span></a>
                    <div class="price">$0.00</div>
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
                    <h4>Shopping Cart</h4>
                    <div class="breadcrumb__links">
                        <a href="../mainshop/mainshop2/index.html">Home</a>
                        <a href="../mainshop/mainshop2/shop.html">Shop</a>
                        <span>Shopping Cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shopping Cart Section Begin -->
<div class="content-wrapper">
    <div class="container-xxl flex-grow-1 container-p-y">
        <!--Content -->
        <!--Table add -->
        <div class="card">
            <div class="card-body">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#exampleModal">
                    Tạo hóa đơn
                </button>

            </div>
        </div>
        <hr class="my-3">
        <!--Table add -->

        <div class="card">
            <h5 class="card-header">Vận Chuyển</h5>
            <table class="table">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Đơn Hang ID</th>
                    <%--                                <th>ID Sản Phẩm</th>--%>
                    <th>Hình Ảnh</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Số Lượng</th>
                    <th>Ngay Đặt</th>
                    <th>Trạng Thái</th>
                    <th>Lý Do Hủy</th>
                    <th>Tổng Tiền</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                <c:forEach items="${list}" var="dhct" varStatus="i">
                    <tr>
                        <td scope="row">${i.index+1}</td>
                        <td>${dhct.donHang.donHangID}</td>
                            <%--                                    <td>${dhct.sanPham.sanPhamID}</td>--%>
                        <td>  <img src="getimage/${dhct.sanPham.hinhAnhURL}" style="max-width: 35px; max-height: 35px;">
                        </td>
                        <td>${dhct.sanPham.tenSanPham}</td>
                        <td>${dhct.soLuong}</td>
                        <td>${dhct.donHang.ngayDatHang}</td>
                        <td>
                            <c:if test="${dhct.trangThai == 0}"> Đã đặt hàng </c:if>
                            <c:if test="${dhct.trangThai == 1}"> Vận chuyển</c:if>
                            <c:if test="${dhct.trangThai== 2}"> Chờ xác nhận</c:if>
                            <c:if test="${dhct.trangThai == 3}"> Thành Công</c:if>
                            <c:if test="${dhct.trangThai == 4}"> Đã hủy</c:if>
                        </td>
                        <td>${dhct.lyDoHuy}</td>
                        <td>${dhct.tongTien}</td>
                        <td>
                            <a id="cancelLink-${i.index}" class="bx bx-edit-alt me-1 cancel-link" href="#" data-donhangid="${dhct.donHang.donHangID}"></a>

                        </td>
                    </tr>
                </c:forEach>
                <a href="/xacnhan" class="primary-btn" >next</a>
                <a href="/dahuy" class="primary-btn" >Đơn hàng đã hủy</a>
                </tbody>
            </table>
        </div>
        <script>
            // Updated function to handle confirmation and redirection
            function confirmCancellation(event) {
                event.preventDefault();

                var link = event.currentTarget;
                var donHangID = link.getAttribute('data-donhangid');

                var confirmation = confirm("Bạn Có chắc chắn?");
                if (confirmation) {
                    // If the user clicks "OK", navigate to the cancellation page
                    window.location.href = "/huyt/" + donHangID;
                } else {
                    // If the user clicks "Cancel", do nothing
                    return false;
                }
            }

            // Add click event listeners to the links
            document.addEventListener('DOMContentLoaded', function () {
                var cancelLinks = document.querySelectorAll('.cancel-link');
                cancelLinks.forEach(function (link) {
                    link.addEventListener('click', confirmCancellation);
                });
            });
        </script>
        <!--Footer -->
        <footer class="content-footer footer bg-footer-theme">
            <div class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
                <div class="mb-2 mb-md-0">
                    ©
                    <script>
                        document.write(new Date().getFullYear());
                    </script>
                    , made with ❤️ by
                    <a href="https://themeselection.com" target="_blank" class="footer-link fw-bolder">Quần
                        áo Nam 5S</a>
                </div>
                <div>
                    <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">Trang
                        chủ</a>
                    <a href="https://themeselection.com/" target="_blank" class="footer-link me-4">Sản
                        phẩm</a>

                    <a href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/"
                       target="_blank" class="footer-link me-4">Thống kê</a>

                    <a href="https://github.com/themeselection/sneat-html-admin-template-free/issues"
                       target="_blank" class="footer-link me-4">Hỗ trợ</a>
                </div>
            </div>
        </footer>
        <!--Footer -->
    </div>
</div>
<!-- Shopping Cart Section End -->

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
                        </script>2020
                        All rights reserved | This template is made with <i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
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