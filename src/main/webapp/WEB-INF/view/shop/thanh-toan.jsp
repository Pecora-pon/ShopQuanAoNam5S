
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
                        <li class="active"><a href="/list-san-pham/page">Shop</a></li>
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
<a href="/dangxem" class="primary-btn" >Xem Đơn Hang</a>
<!-- Shopping Cart Section Begin -->
<div class="container mt-4">
    <form class="needs-validation" id="paymentForm" enctype="multipart/form-data" method="post"
          action="/themmoi">
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

                                 <li>${gh.sanPham.tenSanPham} - ${gh.sanPham.giaSanPham} - ${gh.soLuongDat} - ${gh.sanPham.giaSanPham*gh.soLuongDat}</li>
                             <input type="hidden" name="gioHangID[]" value="${gh.gioHangID}">
                         </ul>
                        </div>
<%--                        <span class="text-muted">23600000</span>--%>
                    </li>   <c:set var="totalPrice" value="${totalPrice + gh.sanPham.giaSanPham * gh.soLuongDat}" />
                        <c:set var="totalPriceLong" value="${Math.round(totalPrice)}" />
<%--                        <input type="hidden" name="tongTien" value="${totalPrice}">--%>
                    </c:forEach>
                    <input type="hidden" name="gioHangID" value="4">
                    <input type="hidden" name="sanphamgiohang[2][gia]" value="14990000.00">
                    <input type="hidden" name="sanphamgiohang[2][soluong]" value="8">
                    <li class="list-group-item d-flex justify-content-between">
                        <input type="text" name="amount" value="${totalPriceLong}" readonly>
                    </li>
                </ul>


                <div class="input-group">
                    <select name="giamGia.giamGiaID" class="form-control">
                        <option value="" label="Chọn Giảm Giá"/>
                        <c:forEach var="giamGia" items="${listGiamGia}">
                            <option value="${giamGia.giamGiaID}">${giamGia.maGiamGia}</option>
                        </c:forEach>
                    </select>
                </div>

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

                    <div class="col-md-12">
                        <label>Địa Chỉ</label>
                        <select name="thongTinVanChuyen.thongTinVanChuyenID" class="form-control" style="width: 100%;">
                            <option value="" label="Chọn ThongTinVanChuyen"/>
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

                <h4 class="mb-3">Hình thức thanh toán</h4>
                <div class="d-block my-3">
                    <div class="custom-control custom-radio">
                        <input id="httt-1" name="hinhThucThanhToan" type="radio" class="custom-control-input" required=""
                               value="1">
                        <label class="custom-control-label" for="httt-1">Tiền mặt</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="httt-2" name="hinhThucThanhToan"  type="radio" class="custom-control-input" required=""
                               value="2">
                        <label class="custom-control-label" for="httt-2">Chuyển khoản</label>
                    </div>

                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit" onclick="submitForm()">Đặt hàng</button>

            </div>
        </div>
    </form>


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
<script>
    function submitForm() {
        var form = document.getElementById("paymentForm");
        var paymentMethod = document.querySelector('input[name="hinhThucThanhToan"]:checked');
        var radioTienMat = document.getElementById("httt-1");

        if (paymentMethod) {
            if (paymentMethod.value === "1") {
                if (radioTienMat.checked) {
                    alert("Bạn có chắc chắn muốn đặt hàng");
                    // Submit the form
                    form.method = "post";
                    form.action = "/themmoi";
                    form.submit();
                } else {
                    // Handle other cases for "Tiền mặt" if needed
                }
            } else if (paymentMethod.value === "2") {
                form.method = "post";  // Đổi phương thức thành GET
                form.action = "/submitOrder";
                // Submit the form
                form.submit();
            }
            // Add any additional conditions for other payment methods if needed.
        } else {
            // Handle the case where no payment method is selected
            alert("Vui lòng chọn hình thức thanh toán.");
        }
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
</body>

</html>