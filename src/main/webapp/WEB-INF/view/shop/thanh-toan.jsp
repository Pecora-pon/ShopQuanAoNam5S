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
<%@ page import="java.util.Date" %>


<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.thongTinVanChuyen.thongTinVanChuyenID0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>5S-Fashion | Thanh toán</title>
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
                    <a href="../mainshop/mainshop2/index.html"><img
                            src="../../../../../../../malefashion-master/malefashion-master/img/logo.png" alt=""></a>
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
<a href="/dangxem" class="primary-btn">Xem Đơn Hang</a>
<!-- Shopping Cart Section Begin -->
<div class="container mt-4">
    <form class="needs-validation" id="paymentForm" enctype="multipart/form-data" method="post"
          action="/themmoi" onsubmit="return submitForm()">
        <input type="hidden" name="kh_tendangnhap" value="dnpcuong">

        <div class="py-5 text-center">
            <i class="fa fa-credit-card fa-4x" aria-hidden="true"></i>
            <h2>Thanh toán</h2>
            <p class="lead">Vui lòng kiểm tra thông tin Khách hàng, thông tin Giỏ hàng trước khi Đặt hàng.</p>
        </div>
        <div class="row">
            <div class="col-md-4 order-md-2 mb-4">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">Giỏ hàng</span>
                    <span class="badge badge-secondary badge-pill">2</span>
                </h4>
                <ul class="list-group mb-3">
                    <input type="hidden" name="sanphamgiohang[1][sp_ma]" value="2">
                    <input type="hidden" name="sanphamgiohang[1][gia]" value="11800000.00">
                    <input type="hidden" name="sanphamgiohang[1][soluong]" value="2">
                    <c:forEach items="${listGioHang}" var="gh">
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div>
                                <ul>

                                    <li>
                                            ${gh.sanPham.tenSanPham} -
                                        <c:choose>
                                            <c:when test="${gh.sanPham.giaSanPham >= 1000000}">
                                                <fmt:formatNumber value="${gh.sanPham.giaSanPham / 1.0}"
                                                                  pattern="#,##0"/>
                                            </c:when>
                                            <c:otherwise>
                                                <fmt:formatNumber value="${gh.sanPham.giaSanPham}" pattern="#,##0"/>
                                            </c:otherwise>
                                        </c:choose> -
                                            ${gh.soLuongDat} -  ${gh.sanPham.size.tenSize} -${gh.sanPham.mauSac.tenMauSac} -
                                        <c:choose>
                                            <c:when test="${gh.sanPham.giaSanPham * gh.soLuongDat >= 1000000}">
                                                <fmt:formatNumber
                                                        value="${(gh.sanPham.giaSanPham * gh.soLuongDat) / 1.0}"
                                                        pattern="#,##0"/>
                                            </c:when>
                                            <c:otherwise>
                                                <fmt:formatNumber value="${gh.sanPham.giaSanPham * gh.soLuongDat}"
                                                                  pattern="#,##0"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                    <input type="hidden" name="gioHangID[]" value="${gh.gioHangID}">
                                </ul>
                            </div>
                                <%--                        <span class="text-muted">23600000</span>--%>
                        </li>
                        <c:set var="totalPrice" value="${totalPrice + gh.sanPham.giaSanPham * gh.soLuongDat}"/>
                        <c:set var="totalPriceLong" value="${Math.round(totalPrice)}"/>


                    </c:forEach>
                    <input type="hidden" name="gioHangID" value="4">
                    <input type="hidden" name="sanphamgiohang[2][gia]" value="14990000.00">
                    <input type="hidden" name="sanphamgiohang[2][soluong]" value="8">

                    <li class="list-group-item d-flex justify-content-between">
                        <input type="hidden" name="totalprice1" value="${totalPriceLong}" readonly>
                        Tạm tính : <input type="text" name="totalprice" value="<c:choose>
    <c:when test='${totalPriceLong >= 1000000}'>
        <fmt:formatNumber value='${totalPriceLong / 1000000}' pattern='#,##0.###'/> triệu
    </c:when>
    <c:when test='${totalPriceLong >= 1000}'>
        <fmt:formatNumber value='${totalPriceLong / 1000}' pattern='#,##0.###'/> nghìn
    </c:when>
    <c:otherwise>
        <fmt:formatNumber value='${totalPriceLong}' pattern='#,##0'/>
    </c:otherwise>
</c:choose>" readonly>

                    </li>


                </ul>

                <%
                    // Lấy thời gian hiện tại
                    Date now = new Date();
                    // (Dùng SimpleDateformat để định dạng ngày theo định dạng y-m-d để so sánh với ngàyHetHan)
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    String nowString = sdf.format(now);
                %>

                <style>
                    .sotiengiam-label {
                        font-weight: bold;
                        color: #007BFF; /* Màu sắc tùy chọn */
                        margin-top: 10px; /* Khoảng cách giữa select box và label, tùy chỉnh theo nhu cầu */
                        display: block; /* Hiển thị label dưới dạng block để nó xuống dòng */
                    }
                </style>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Mã Giảm Giá</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="row">
                                <div class="modal-body">
                                    <c:forEach var="giamGia" items="${listGiamGia}">
                                        <div class="product-row">
                                            <div class="product-details">
                                                <div class="product-image">
                                                    <img src="../mainshop/mainshop2/img/logo.png" alt="">
                                                </div>
                                                <div class="product-info">
                                                    <h4>${giamGia.maGiamGia}</h4>
                                                    <p>Số tiền giảm:<fmt:formatNumber value="${giamGia.soTienGiam}" pattern="#,##0"/> VND</p>
                                                    <p>Đơn giá tối thiểu:<fmt:formatNumber value="${giamGia.donToiThieu}" pattern="#,##0"/> VND</p>
                                                    <p>Hạn sử dụng: ${giamGia.ngayHetHan}</p>
                                                    <div class="expired-message" style="color: red; font-weight: bold; display: none;">Đã hết hạn</div>
                                                    <div class="totalprice-message" style="color: red; font-weight: bold; display: none;">Tổng tiền không đạt điều kiện</div>

                                                </div>
                                                <c:choose>
                                                    <c:when test="${giamGia.ngayHetHan < nowString}">
                                                        <p>Đã hết hạn</p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" value="${giamGia.giamGiaID}" name="giamGiaRadio" data-ngayHetHan="${giamGia.ngayHetHan}" data-donToiThieu="${giamGia.donToiThieu}" data-soTienGiam="${giamGia.soTienGiam}" onchange="updateSoTienGiam(this)" />

                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <script defer>
                                        document.addEventListener('DOMContentLoaded', function () {
                                            $('#exampleModal').on('shown.bs.modal', function () {
                                                var radios = document.querySelectorAll('input[type="radio"]');
                                                checkDateAndEnableRadios(radios);
                                            });
                                        });

                                        function parseDateString(dateString) {
                                            // Giả sử dateString có định dạng "yyyy-MM-dd"
                                            var parts = dateString.split("-");
                                            var formattedDate = parts[1] + "/" + parts[2] + "/" + parts[0];
                                            return new Date(formattedDate);
                                        }

                                        function checkDateAndEnableRadios(radios) {
                                            console.log("Number of radios:", radios.length);
                                            var nowString = "<%= nowString %>";
                                            var now = new Date();

                                            radios.forEach(function (radio) {
                                                var ngayHetHanString = radio.getAttribute('data-ngayHetHan');
                                                console.log("Original NgayHetHanString: ", ngayHetHanString);

                                                var ngayHetHan = parseDateString(ngayHetHanString);
                                                console.log("Parsed NgayHetHan: ", ngayHetHan);

                                                // So sánh ngày hiện tại và ngàyHetHan
                                                if (isNaN(ngayHetHan.getTime())) {
                                                    console.error("Ngày hết hạn không hợp lệ:", ngayHetHanString);
                                                    return;
                                                }

                                                // Loại bỏ giờ, phút, giây, và mili giây
                                                var nowWithoutTime = new Date(now.getFullYear(), now.getMonth(), now.getDate());
                                                var ngayHetHanWithoutTime = new Date(ngayHetHan.getFullYear(), ngayHetHan.getMonth(), ngayHetHan.getDate());

                                                console.log("Now without time:", nowWithoutTime);
                                                console.log("NgayHetHan without time:", ngayHetHanWithoutTime);

                                                if (ngayHetHanWithoutTime < nowWithoutTime) {
                                                    // Đã hết hạn
                                                    console.log("Đã hết hạn");
                                                    radio.disabled = true;
                                                    radio.parentElement.querySelector('.expired-message').style.display = 'block';
                                                    return;
                                                }else {
                                                    radio.disabled = false;
                                                    radio.parentElement.querySelector('.expired-message').style.display = 'none';
                                                }
                                                    // Chưa hết hạn
                                                    var donToiThieu = parseFloat(radio.getAttribute('data-donToiThieu'));
                                                    var totalprice = parseFloat(document.getElementsByName('totalprice1')[0].value.replace(/[^0-9.-]+/g, ""));
                                                    console.log("donToiThieu:", donToiThieu);
                                                    console.log("totalprice:", totalprice);

                                                // Kiểm tra điều kiện đơn tối thiểu
                                                if (isNaN(donToiThieu) || isNaN(totalprice)) {
                                                    console.error("Giá trị không hợp lệ cho donToiThieu hoặc totalprice");
                                                    return;
                                                }

                                                if (donToiThieu <= totalprice) {
                                                    // Đơn tối thiểu hợp lệ
                                                    radio.disabled = false;

                                                    radio.parentElement.querySelector('.totalprice-message').style.display = 'none';
                                                } else {
                                                    // Đơn tối thiểu không hợp lệ
                                                    radio.disabled = true;

                                                    radio.parentElement.querySelector('.totalprice-message').style.display = 'block';
                                                }
                                            });
                                        }
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                    <!-- Your product form goes here -->
                    <!-- Form fields go here -->
                <div class="form-group">
                    <label for="giamGiaSelect" class="sotiengiam-label">Giảm Gia:</label>
                    <input type="text" name="giamGia.giamGiaID" id="giamGiaSelect" readonly class="form-control">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Chọn Giảm Giá</button>
                </div>


                <c:set var="totalPriceLong" value="${Math.round(totalPrice)}"/>
                <c:choose>
                    <c:when test="${totalPriceLong > 500000}">
                        <!-- Nếu totalPriceLong lớn hơn 500000 -->
                        <c:set var="updatedTotalPriceLong1" value="${totalPriceLong + 0}"/>
                        <p>Phí ship : 0đ</p>
                        <li class="list-group-item d-flex justify-content-between">Tổng tiền : <input type="text" name="amount" value="
${updatedTotalPriceLong1}" readonly>


                        </li>
                    </c:when>
                    <c:otherwise>
                        <!-- Nếu totalPriceLong không lớn hơn 500000 -->
                        <%-- Cộng thêm 50000 vào totalPriceLong --%>
                        <%-- Tạo biến mới để lưu giá trị --%>
                        <p>Phí ship của bạn: 32000đ</p>
                        <c:set var="updatedTotalPriceLong" value="${totalPriceLong + 32000}"/>
                        <li class="list-group-item d-flex justify-content-between">

                            Tổng tiền : <input type="text" name="amount" value="${updatedTotalPriceLong}" readonly>



                        </li>
                    </c:otherwise>
                </c:choose>

                <style>
                    .product-link {
                        display: inline-block;
                        padding: 10px 20px;
                        background-color: #4CAF50; /* Green background color */
                        color: white;
                        text-decoration: none;
                        border-radius: 5px;
                        transition: background-color 0.3s;
                    }

                    /* Change background color on hover */
                    .product-link:hover {
                        background-color: #45a049; /* Darker green on hover */
                    }

                    .product-row {
                        display: flex;
                        align-items: center;
                        margin-bottom: 15px;
                        padding: 15px;
                        border: 1px solid #ccc;
                        border-radius: 8px;
                        transition: transform 0.2s ease-in-out;
                    }

                    .product-row:hover {
                        transform: scale(1.05);
                    }

                    .product-image {
                        max-width: 105px;
                        max-height: 105px;
                        margin-right: 15px;
                        border-radius: 8px;
                    }

                    .product-details {
                        display: flex;
                        align-items: center;
                        /* Hiển thị các thông tin và ảnh theo chiều ngang */
                        flex-direction: row;
                        flex-grow: 1;
                    }

                    .product-info {
                        flex-grow: 1;
                    }

                    .radio-input {
                        margin-left: auto;
                        margin-right: 10px;
                    }
                </style>
                <script>
                    function updateSoTienGiam(radio) {
                    // Get the data-soTienGiam attribute value from the selected radio button
                    console.log('Radio button:', radio);
                    console.log('data-soTienGiam attribute:', radio.getAttribute('data-soTienGiam'));
                    var soTienGiam = radio.getAttribute('data-soTienGiam');
                    console.log('Selected soTienGiam:', soTienGiam);
                    // Update the value of the text input field
                    document.getElementById('giamGiaSelect').value = soTienGiam;
                        updateTongTien(soTienGiam);
                }


                    function updateTongTien(soTienGiam) {
                        // Kiểm tra nếu có giảm giá
                        if (soTienGiam !== undefined) {
                            // Lấy giá trị tổng tiền hiện tại
                            var totalPriceLong = parseInt("${totalPriceLong}");

                            // Nếu tổng tiền hiện tại lớn hơn 500000, thì chỉ trừ giảm giá
                            if (totalPriceLong > 500000) {
                                totalPriceLong -= parseFloat(soTienGiam);
                            } else {
                                // Nếu tổng tiền hiện tại không lớn hơn 500000, cộng giảm giá và phí ship
                                totalPriceLong -= parseFloat(soTienGiam);
                                totalPriceLong += 32000;
                            }

                            // Cập nhật giá trị tổng tiền mới vào input
                            $("input[name='amount']").val(totalPriceLong);

                            // Log để kiểm tra xem giá trị đã chuyển đổi đúng chưa
                            console.log('Tổng Tiền Mới (Long):', totalPriceLong);
                        } else {
                            // Hiển thị thông báo yêu cầu chọn mã giảm giá
                            alert("Vui lòng chọn mã giảm giá trước khi thanh toán.");
                        }
                    }

                </script>

            </div>

            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Thông tin khách hàng</h4>

                <div class="row">
                    <div class="col-md-12">
                        <label for="hoTen">Họ tên</label>
                        <input type="text" class="form-control" name="hoTen" id="hoTen"
                               value="${tt.hoTen}" readonly="">
                        <input type="hidden" name="tenKhach" value="${tt.hoTen}">
                    </div>
                    <div class="col-md-12">
                        <label for="kh_gioitinh">Giới tính</label>
                        <input type="text" class="form-control" name="kh_gioitinh" id="kh_gioitinh" value="Nam"
                               readonly="">
                    </div>
                    <%--                    <div class="col-md-12">--%>
                    <%--                        <label for="diaChi">Địa chỉ</label>--%>
                    <%--                        <input type="text" class="form-control" name="diaChi" id="diaChi"--%>
                    <%--                               value="${tt.diaChi}" readonly="">--%>
                    <%--                    </div>--%>
                    <div class="col-md-12">
                        <label for="soDienThoai">Điện thoại</label>
                        <input type="text" class="form-control" name="soDienThoai" id="soDienThoai"
                               value="${tt.soDienThoai}" readonly="">
                    </div>
                    <div class="col-md-12">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" name="email" id="email"
                               value="${tt.email}" readonly="">
                    </div>

                    <div class="mb-3 col-md-12">
                        <label class="form-label">Địa Chỉ</label>
                        <select name="thongTinVanChuyen.thongTinVanChuyenID" class="form-control" style="width: 100%;"
                                id="yourSelect" onchange="redirectToPage()" required>
                            <option class="form-control" value="" selected disabled hidden>Mời bạn chọn địa chỉ</option>
                            <option value="thong-tin-van-chuyen/page">Thêm địa chỉ mới</option>
                            <c:forEach var="thongTinVanChuyen" items="${listThongTinVanChuyen}">
                                <option value="${thongTinVanChuyen.thongTinVanChuyenID}">${thongTinVanChuyen.diaChi}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-12">
                        <label for="note">Note</label>
                        <input type="text" class="form-control" name="note" id="note" value=""
                               readonly="">
                    </div>
                </div>
                <input type="hidden" id="trangThaiInput" name="trangThai">
                <h4 class="mb-3">Hình thức thanh toán</h4>
                <div class="d-block my-3">
                    <div class="custom-control custom-radio">
                        <input id="httt-1" name="hinhThucThanhToan" type="radio" class="custom-control-input"
                               required=""
                               value="1">
                        <label class="custom-control-label" for="httt-1">Tiền mặt</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="httt-2" name="hinhThucThanhToan" type="radio" class="custom-control-input"
                               required=""
                               value="2">
                        <label class="custom-control-label" for="httt-2">Chuyển khoản</label>
                    </div>

                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Đặt hàng</button>

            </div>

        </div>
    </form>


</div>
<div class="container">
    <div class="section-title">
        <span></span>
        <h2>Sản phẩm nổi bật</h2>
    </div>
    <div class="row">
        <c:forEach items="${listSanPham}" var="sp">
            <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="/getimage/${sp.hinhAnhURL}" style="background-image: url(&quot;img/product/product-1.jpg&quot;);">
                        <span class="label">New</span>
                        <ul class="product__hover">
                            <li><a href="/danh-sach-yt/them/${sp.sanPhamID}"><img src="../mainshop/mainshop2/img/icon/heart.png" alt=""></a></li>
                            <li><a href="/san-pham-detail/${sp.sanPhamID}"><img src="../mainshop/mainshop2/img/icon/search.png" alt=""></a></li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>${sp.tenSanPham}</h6>
                        <a href="/san-pham-detail/${sp.sanPhamID}" class="add-cart">+ Add To Cart</a>

                        <h5> <fmt:formatNumber value="${sp.giaSanPham}" pattern="#,##0"/> VND</h5>
                    </div>
                </div>
            </div>
        </c:forEach>
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

<!-- Js Plugins -->
<script src="../mainshop/mainshop2/js/jquery-3.3.1.min.js"></script>
<script src="../mainshop/mainshop2/js/bootstrap.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.nice-select.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.nicescroll.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.magnific-popup.min.js"></script>
<script src="../mainshop/mainshop2/js/jquery.countdown.min.js"></script>
<script src="../mainshop/mainshop2/js/mixitup.min.js"></script>
<script src="../mainshop/mainshop2/js/owl.carousel.min.js"></script>
<script src="../mainshop/mainshop2/js/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js" integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="../admin/assets/vendor/js/menu.js"></script>
<!-- endbuild -->
<script src="../admin/assets/vendor/libs/jquery/jquery.js"></script>
<script src="../admin/assets/vendor/libs/popper/popper.js"></script>
<script src="../admin/assets/vendor/js/bootstrap.js"></script>
<script src="../admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js" integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="../admin/js/diachi.js"></script>

<script src="../admin/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->
<script src="../admin/assets/vendor/libs/apex-charts/apexcharts.js"></script>

<!-- Main JS -->
<script src="../admin/assets/js/main.js"></script>
<script>
    function submitForm() {
        var form = document.getElementById("paymentForm");
        var paymentMethod = document.querySelector('input[name="hinhThucThanhToan"]:checked');
        var radioTienMat = document.getElementById("httt-1");
        var trangThaiInput = document.getElementById("trangThaiInput"); // Thêm dòng này

        trangThaiInput.value = paymentMethod && paymentMethod.value === "1" ? "5" : "0";
        if (paymentMethod) {
            if (paymentMethod.value === "1") {
                if (radioTienMat.checked) {
                    var confirmOrder = confirm("Bạn có chắc chắn muốn đặt hàng?");
                    if (confirmOrder) {
                        // Submit the form
                        form.method = "post";
                        form.action = "/themmoi";

                    } else {
                        return false;
                    }
                } else {
                    // Handle other cases for "Tiền mặt" if needed
                }
            } else if (paymentMethod.value === "2") {
                // Đổi phương thức thành POST và action thành "/submitOrder"
                form.method = "post";
                form.action = "/submitOrder";

                // Submit the form

            }
            // Add any additional conditions for other payment methods if needed.
        } else {
            // Handle the case where no payment method is selected
            alert("Vui lòng chọn hình thức thanh toán.");
        }
        form.submit();
    }
</script>
<script>
    function convertToLong(input) {
        // Lấy giá trị từ trường nhập số
        let inputValue = input.value;

        // Loại bỏ dấu chấm và số 0 phía sau nó
        let formattedValue = inputValue.replace(/\.0+$/, '');

        // Kiểm tra xem giá trị có phải là một số hợp lệ không
        if (!isNaN(parseInt(formattedValue))) {
            // Đặt giá trị mới cho trường nhập số
            input.value = formattedValue;
        } else {
            // Nếu giá trị không hợp lệ, có thể xử lý theo cách khác hoặc báo lỗi
            console.error("Invalid number format");
        }
    }
</script>
<script type="text/javascript">
    function redirectToPage() {
        var selectedValue = document.getElementById("yourSelect").value;
        // Assuming selected values correspond to the target page URLs
        if (selectedValue === "thong-tin-van-chuyen/page") {
            // Assuming selected values correspond to the target page URLs
            var targetPageUrl = "/" + selectedValue;

            // Redirect to the selected page
            window.location.href = targetPageUrl;
        }
    }
</script>

</body>

</html>
