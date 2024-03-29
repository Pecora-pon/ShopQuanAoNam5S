<!DOCTYPE html>
<html lang="zxx">
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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>5S-Fashin | Thông Báo Thành Công</title>
    <link rel="icon" type="image/x-icon" href="../admin/assets/img/favicon/favicon.ico"/>
    <title>Thông Báo Thành Công</title>
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

        <div class="row">
            <div class="col-md-4 mb-3">
                <form action="/timkiemngay" method="get" class="d-flex align-items-center">
                    <label class="me-2">Ngày Đặt:</label>
                    <input type="date" name="ngaydat" class="form-control" required>
                    <button type="submit" class="btn btn-primary ms-2">Tìm Kiếm</button>
                </form>
            </div>

            <div class="col-md-4 mb-3">
                <form action="/timkiemten" method="get" class="d-flex align-items-center">
                    <label class="me-2">Tên Sản Phẩm:</label>
                    <input type="text" name="ten" class="form-control" required>
                    <button type="submit" class="btn btn-primary ms-2">Tìm Kiếm</button>
                </form>
            </div>

            <div class="col-md-4 mb-3">
                <form action="/timkiemtongtien" method="get" class="d-flex align-items-center">
                    <label class="me-2">Tổng Tiền:</label>
                    <input type="text" name="tongTien" class="form-control" required>
                    <button type="submit" class="btn btn-primary ms-2">Tìm Kiếm</button>
                </form>
            </div>
        </div>
        <hr class="my-3">
        <!--Table add -->

        <div class="card">
            <h5 class="card-header">Đã Đặt</h5>
            <table class="table">
                <thead>
                <tr>
                    <th>STT</th>
<%--                    <th>Đơn Hang ID</th>--%>
                    <%--                                <th>ID Sản Phẩm</th>--%>
                    <th>Hình Ảnh</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Size</th>
                    <th>Màu sắc</th>
                    <th>Số Lượng</th>
                    <th>Ngày Đặt</th>
                    <th>Trạng Thái</th>
                    <th>Tổng Tiền</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                <c:forEach items="${list}" var="dhct" varStatus="i">
                    <c:if test="${!dhct.donHang.donHangID.equals(pageContext.getAttribute('previousDonHangID'))}">
                    <!-- Hiển thị thông tin chung của đơn hàng, chỉ hiển thị nếu đơn hàng có sản phẩm -->
                    <tr>
                        <td scope="row">${i.index+1}</td>
<%--                        <td>${dhct.donHang.donHangID}</td>--%>
                        <!-- Các cột thông tin khác của đơn hàng -->

                        <!-- Đặt giá trị mới cho biến theo dõi -->
                        <c:set var="previousDonHangID" value="${dhct.donHang.donHangID}" />
                        <td>  <img src="/getimage/${dhct.sanPham.hinhAnhURL}" style="max-width: 35px; max-height: 35px;">
                        </td>
                        <td>${dhct.sanPham.tenSanPham}</td>
                        <td>${dhct.sanPham.size.tenSize}</td>
                        <td>${dhct.sanPham.mauSac.tenMauSac}</td>
                        <td>${dhct.soLuong}</td>
                        <td>${dhct.donHang.ngayDatHang}</td>
                        <td>
                            <c:if test="${dhct.trangThai == 5}"> Chờ xác nhận đơn hàng </c:if>
                            <c:if test="${dhct.trangThai == 0}"> Đã đặt hàng </c:if>
                            <c:if test="${dhct.trangThai == 1}"> Vận chuyển</c:if>
                            <c:if test="${dhct.trangThai== 2}"> Chờ xác nhận</c:if>
                            <c:if test="${dhct.trangThai == 3}"> Thành Công</c:if>
                            <c:if test="${dhct.trangThai == 4}"> Đã hủy</c:if>
                        </td>
                        <td><fmt:formatNumber value="${dhct.tongTien}" pattern="#,##0"/> VND</td>
                        <td>
                            <a class="dropdown-item" href="javascript:void(0);" onclick="showCancelForm(${i.index})">
                                <i class="bx bx-trash me-1"></i>Hủy Đơn Hàng
                            </a>
                            <a class="dropdown-item" href="/detail/${dhct.donHang.donHangID}">
                                <i class="bx bx-edit-alt me-1"></i>Chi Tiết
                            </a>
                        </td>
                    </tr>
                        <!-- Hidden form for entering the reason -->
                        <tr id="cancelForm${i.index}" style="display: none;">
                            <td colspan="9">
                                <form action="/huydacho/${dhct.donHang.donHangID}">
                                    <label class="dark-style">Nếu bạn đã thanh toán chúng tôi sẽ sớm liên hệ với bạn qua sdt và email bạn cung cấp để gửi lại tiền</label><br>
                                    <!-- Include form fields for entering the reason -->
                                    <input type="text" name="lyDoHuy" placeholder="Lý do hủy đơn hàng" required>
                                    <button type="submit">Xác nhận hủy đơn hàng</button>
                                </form>
                            </td>
                        </tr>
                    </tr>
                    </c:if>
                </c:forEach>
                <script>
                    function showCancelForm(index) {
                        var form = document.getElementById('cancelForm' + index);
                        form.style.display = (form.style.display === 'none' || form.style.display === '') ? 'table-row' : 'none';
                    }
                </script>
                <script>
                    function confirmCancelOrder(donHangID) {
                        var confirmCancel = confirm("Bạn có chắc chắn muốn hủy đơn hàng?");
                        if (confirmCancel) {
                            // Nếu người dùng chấp nhận, chuyển hướng đến trang hủy đơn hàng
                            window.location.href = "/huydacho/" + donHangID;
                        } else {
                            // Người dùng đã hủy xác nhận, không thực hiện chuyển hướng
                        }
                    }
                </script>
                <style>
                    .btn-container {
                        display: flex;
                    }

                    .primary-btn {
                        text-decoration: none;
                        color: #ffffff;
                        background-color: #007bff;
                        padding: 10px 20px;
                        border-radius: 5px;
                        margin-right: 10px;
                    }
                </style>

                <div class="btn-container">
                    <a href="/choxacnhan" class="primary-btn">Chờ Xác Nhận</a>
                    <a href="/dangxem" class="primary-btn">Xem Đơn Hàng</a>
                    <a href="/vanchuyen" class="primary-btn">Vận Chuyển</a>
                    <a href="/xacnhan" class="primary-btn">Xác Nhận</a>
                    <a href="/thanhcong" class="primary-btn">Thành Công</a>
                    <a href="/dahuy" class="primary-btn">Đơn hàng đã hủy</a>
                </div>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:forEach begin="0" end="${totalPages}" var="page">
                        <c:choose>
                            <c:when test="${page == currentPage}">
                                <li class="page-item active"><span class="page-link">${page}</span></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="/khach-hang-xem/page?page=${page}">${page}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </nav>
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
                    window.location.href = "/huydx/" + donHangID;
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
</div><script>
    // Hàm xác nhận khi liên kết được bấm
    function confirmAction() {
        // Sử dụng SweetAlert để hiển thị thông báo xác nhận
        Swal.fire({
            title: 'Xác nhận',
            text: 'Bạn có chắc chắn muốn thực hiện hành động này?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Đồng ý',
            cancelButtonText: 'Hủy bỏ'
        }).then((result) => {
            // Nếu người dùng đồng ý, bạn có thể thực hiện hành động mong muốn ở đây
            if (result.isConfirmed) {
                // Thực hiện hành động, ví dụ: chuyển hướng đến một trang cụ thể
                window.location.href = "/huydx/${dhct.donHang.donHangID}";
            }
        });
    }
</script>
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
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    function deleteOrder(donHangID, rowIndex) {
        $.ajax({
            url: '/huydx/' + donHangID,
            type: 'GET',
            success: function (response) {
                // Xóa dòng khỏi giao diện người dùng
                $('#row_' + rowIndex).remove();
                console.log(response);
            },
            error: function (error) {
                console.error(error);
            }
        });
    }
</script>
</body>

</html>
