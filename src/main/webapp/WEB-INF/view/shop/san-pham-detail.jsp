<!DOCTYPE html>
<html lang="zxx">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>5S-Fashion | Sản phẩm</title>

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
                <a href="/logout">Sign in</a>
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
            <a href="/gio-hang"><img src="../mainshop/mainshop2/img/icon/cart.png" alt=""> <span>0</span></a>
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

    <!-- Shop Details Section Begin -->
    <section class="shop-details">
        <div class="product__details__pic">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="product__details__breadcrumb">
                            <a href="/shop/main-shop">Home</a>
                            <a href="/list-san-pham/page">Shop</a>
                            <span>Chi tiết sản phẩm</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-3">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">
                                    <div class="product__thumb__pic set-bg" data-setbg="img/shop-details/thumb-1.png" style="background-image: url(&quot;img/shop-details/thumb-1.png&quot;);">
                                    </div>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">
                                    <div class="product__thumb__pic set-bg" data-setbg="img/shop-details/thumb-2.png" style="background-image: url(&quot;img/shop-details/thumb-2.png&quot;);">
                                    </div>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">
                                    <div class="product__thumb__pic set-bg" data-setbg="img/shop-details/thumb-3.png" style="background-image: url(&quot;img/shop-details/thumb-3.png&quot;);">
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-lg-6 col-md-9">
                        <div class="tab-content">
                            <form:form action="" modelAttribute="sp">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__pic__item" value="${sp.hinhAnhURL}">
                                        <img src="<c:url value='/getimage/'/>${sp.hinhAnhURL}" alt="">
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="product__details__content">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-8">
                        <div class="product__details__text">
                        <form:form action="/them-gio-hang/${sp.tenSanPham}/${sp.hinhAnhURL}" modelAttribute="sp" method="post">
                            <h4 value="${sp.tenSanPham}">${sp.tenSanPham}</h4>
                            <h3 value="${sp.giaSanPham}">
                                <fmt:formatNumber value="${sp.giaSanPham}" pattern="#,##0"/>
                            </h3>
                            <label>Size</label>
                            <div class="custom-radio">
                                <input type="radio" id="md" name="sizeID" value="1" >
                                <label for="md">XS</label>
                            </div>

                            <div class="custom-radio">
                                <input type="radio" id="xl" name="sizeID" value="2">
                                <label for="xl">SM</label>
                            </div>

                            <div class="custom-radio">
                                <input type="radio" id="2xl" name="sizeID" value="3">
                                <label for="2xl">MD</label>
                            </div>
                            <label>Màu Sắc</label>
                            <div class="custom-radio">
                                <input type="radio" id="do" name="mauSacID" value="1" >
                                <label for="do">Trắng</label>
                            </div>

                            <div class="custom-radio">
                                <input type="radio" id="xanh" name="mauSacID" value="2">
                                <label for="xanh">Đen</label>
                            </div>

                            <div class="custom-radio">
                                <input type="radio" id="hong" name="mauSacID" value="3">
                                <label for="hong">Xám</label>
                            </div>
                            <input type="hidden" name="sizeID" value="${sp.size.sizeID}" />
                            <input type="hidden" name="mauSacID" value="${sp.mauSac.mauSacID}" />
                                <div class="product__details__cart__option">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <input type="text" id="soLuongDatInput" value="1" name="soLuongDat">
                                        </div>
                                    </div>
                                    <button class="primary-btn" onclick="validateAndSubmit(event)">add to cart</button>
                                    <a href="javascript:void(0);" class="primary-btn" onclick="muaNgay()">Mua Ngay</a>
                                </div>
                        </form:form>
                            <style>
                                .custom-radio {
                                    display: inline-block;
                                    margin-right: 10px;
                                    cursor: pointer;
                                }

                                .custom-radio input {
                                    display: none;
                                }

                                .custom-radio label {
                                    display: block;
                                    width: 50px; /* Đặt chiều rộng của mỗi ô radio */
                                    height: 50px; /* Đặt chiều cao của mỗi ô radio */
                                    border: 2px solid #ccc;
                                    border-radius: 5px;
                                    text-align: center;
                                    line-height: 50px; /* Đặt độ cao dòng chữ giữa ô radio */
                                    font-size: 16px;
                                    background-color: #fff;
                                    transition: background-color 0.3s ease;
                                }

                                .custom-radio input:checked + label {
                                    background-color: #e0e0e0;
                                }
                            </style>
<%--                            <script>--%>
<%--                                function muaNgay() {--%>
<%--                                    var soLuongDat = document.getElementById("soLuongDatInput").value;--%>
<%--                                    var sanPhamID = "${sp.sanPhamID}";--%>
<%--                                    var slton = parseInt("${sp.soLuongTon}"); // Giả sử "soLuongTon" là số lượng có sẵn--%>

<%--                                    // Kiểm tra nếu số lượng đặt là nhỏ hơn 1--%>
<%--                                    if (parseInt(soLuongDat) < 1) {--%>
<%--                                        // Hiển thị thông báo lỗi--%>
<%--                                        alert('Số lượng đặt phải lớn hơn hoặc bằng 1.');--%>
<%--                                        return;--%>
<%--                                    }--%>

<%--                                    // Kiểm tra nếu số lượng đặt lớn hơn số lượng tồn--%>
<%--                                    if (parseInt(soLuongDat) > slton) {--%>
<%--                                        // Hiển thị thông báo với số lượng tồn không đủ và ghi số lượng còn lại--%>
<%--                                        alert('Số lượng tồn không đủ. Chỉ còn ' + slton + ' sản phẩm.');--%>
<%--                                        return;--%>
<%--                                    }--%>

<%--                                    // Nếu số lượng đủ, thì chuyển hướng đến URL với tham số soLuongDat--%>
<%--                                    window.location.href = "/themngay/" + sanPhamID + "?soLuongDat=" + soLuongDat;--%>
<%--                                }--%>
<%--                            </script>--%>


                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <ul class="nav nav-tabs" role="tablist">
<%--                                <li class="nav-item">--%>
<%--                                    <a class="nav-link active" data-toggle="tab" href="#tabs-5"--%>
<%--                                    role="tab">Mô tả</a>--%>
<%--                                </li>--%>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-6" role="tab">Đánh giá</a>
                                </li>
<%--                                <li class="nav-item">--%>
<%--                                    <a class="nav-link" data-toggle="tab" href="#tabs-7" role="tab">Additional--%>
<%--                                    information</a>--%>
<%--                                </li>--%>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-5" role="tabpanel">
                                    <div class="product__details__tab__content">
                                        <p class="note">${sp.tenSanPham} là một trong những item nổi bật của ${sp.thuongHieu.tenThuongHieu}, với thiết kế đơn giản:</p>
                                        <div class="product__details__tab__content__item">
                                            <h5>Thông tin sản phẩm</h5>
                                            <p>${sp.tenSanPham} không chỉ mang lại cảm giác thoải mái mà còn có thiết kế hỗ trợ cho nhiều hoạt động khác nhau. Đường may chất lượng cao và việc chọn kích thước phù hợp giúp người mặc tự tin và thoải mái khi tham gia các hoạt động vận động.

                                                Trong khi giữ vững chất lượng, giá cả của chiếc áo này cũng phản ánh giá trị đồng giá, tạo nên sự cân bằng tốt giữa chất lượng và chi phí.</p>
                                            <p></p>
                                        </div>
                                        <div class="product__details__tab__content__item">
                                            <h5>Chất lượng sản phẩm</h5>
                                            <p>Được may từ chất vải sợi S.Cafe bảo vệ môi trường, thân thiện với làn da người mặc
                                                Vải cafe mang sự mát mẻ,nhanh khô, khử mùi tốt và chống được tia cực tím, tia UV
                                                Form áo rộng rãi, phù hợp với mọi vóc dáng mang lại sự thoải mái cho người mặc
                                                Sở hữu 2 gam màu cơ bản cực dễ phối đồ
                                                Mang phong cách basic có thể phù hợp với mọi đối tượng, mọi phong cách
                                                Là chiếc áo quốc dân sử dụng được trong mọi hoàn cảnh.</p>
                                        </div>
                                    </div>
                                </div>
<%--                                --%>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tabs-5" role="tabpanel">
                                        <div class="product__details__tab__content">
                                            <!-- ... previous code ... -->

                                            <h5 style="font-size: 20px; font-weight: bold;">Đánh giá sản phẩm</h5>

                                            <div class="customer-reviews">
                                                <c:forEach var="item" items="${rv}">
                                                    <div class="customer-review" style="margin-bottom: 15px; border-bottom: 1px solid #ccc; padding-bottom: 15px;">
                                                        <span class="customer-name" style="font-size: 19px; font-weight: bold; color: #333; font-style: italic;"><c:out value="${item.khachHang.hoTen} :" /></span>
                                                        <div class="product__cart__item__pic">
                                                            <img src="/getimage/${item.hinhAnhURL}" style="max-height: 60px; max-height: 60px;">
                                                        </div>
                                                        <div class="product__cart__item__text">
                                                            <h6><c:out value="${item.sanPham.tenSanPham} " /></h6>
                                                            <h7>Giá: <c:out value="${item.sanPham.giaSanPham} " /></h7>
                                                            <h7>Kích thước: <c:out value="${item.sanPham.size.tenSize} " /></h7>
                                                            <h7>Màu sắc: <c:out value="${item.sanPham.mauSac.tenMauSac} " /></h7>
                                                            <br>
                                                            <span class="customer-comment" style="font-size: 16px; font-weight: bold; color: #555;"><c:out value="${item.binhLuan}" /></span>
                                                        </div>
<%--                                                        <span class="customer-name" style="font-size: 19px; font-weight: bold; color: #333; font-style: italic;"><c:out value="${item.sanPham.tenSanPham} :" /></span>--%>
<%--                                                        <span class="customer-name" style="font-size: 19px; font-weight: bold; color: #333; font-style: italic;"><c:out value="${item.sanPham.mauSac.tenMauSac} :" /></span>--%>
<%--                                                        <span class="customer-name" style="font-size: 19px; font-weight: bold; color: #333; font-style: italic;"><c:out value="${item.sanPham.size.tenSize} :" /></span>--%>
<%--                                                        <img src="/getimage/${item.hinhAnhURL}" style="max-width: 105px; max-height: 105px;">--%>

                                                        <br>
                                                    </div>
                                                </c:forEach>
                                            </div>

                                            <!-- ... remaining code ... -->
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-6" role="tabpanel">
                                    <div class="product__details__tab__content">
                                        <div class="product__details__tab__content__item">
                                            <h5>Products Infomation</h5>
                                            <p>A Pocket PC is a handheld computer, which features many of the same
                                                capabilities as a modern PC. These handy little devices allow
                                                individuals to retrieve and store e-mail messages, create a contact
                                                file, coordinate appointments, surf the internet, exchange text messages
                                                and more. Every product that is labeled as a Pocket PC must be
                                                accompanied with specific software to operate the unit and must feature
                                            a touchscreen and touchpad.</p>
                                            <p>As is the case with any new technology product, the cost of a Pocket PC
                                                was substantial during it’s early release. For approximately $700.00,
                                                consumers could purchase one of top-of-the-line Pocket PCs in 2003.
                                                These days, customers are finding that prices have become much more
                                                reasonable now that the newness is wearing off. For approximately
                                            $350.00, a new Pocket PC can now be purchased.</p>
                                        </div>
                                        <div class="product__details__tab__content__item">
                                            <h5>Material used</h5>
                                            <p>Polyester is deemed lower quality due to its none natural quality’s. Made
                                                from synthetic materials, not natural like wool. Polyester suits become
                                                creased easily and are known for not being breathable. Polyester suits
                                                tend to have a shine to them compared to wool and cotton suits, this can
                                                make the suit look cheap. The texture of velvet is luxurious and
                                                breathable. Velvet is a great choice for dinner party jacket and can be
                                            worn all year round.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-7" role="tabpanel">
                                    <div class="product__details__tab__content">
                                        <p class="note">Nam tempus turpis at metus scelerisque placerat nulla deumantos
                                            solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis
                                            ut risus. Sedcus faucibus an sullamcorper mattis drostique des commodo
                                        pharetras loremos.</p>
                                        <div class="product__details__tab__content__item">
                                            <h5>Products Infomation</h5>
                                            <p>A Pocket PC is a handheld computer, which features many of the same
                                                capabilities as a modern PC. These handy little devices allow
                                                individuals to retrieve and store e-mail messages, create a contact
                                                file, coordinate appointments, surf the internet, exchange text messages
                                                and more. Every product that is labeled as a Pocket PC must be
                                                accompanied with specific software to operate the unit and must feature
                                            a touchscreen and touchpad.</p>
                                            <p>As is the case with any new technology product, the cost of a Pocket PC
                                                was substantial during it’s early release. For approximately $700.00,
                                                consumers could purchase one of top-of-the-line Pocket PCs in 2003.
                                                These days, customers are finding that prices have become much more
                                                reasonable now that the newness is wearing off. For approximately
                                            $350.00, a new Pocket PC can now be purchased.</p>
                                        </div>
                                        <div class="product__details__tab__content__item">
                                            <h5>Material used</h5>
                                            <p>Polyester is deemed lower quality due to its none natural quality’s. Made
                                                from synthetic materials, not natural like wool. Polyester suits become
                                                creased easily and are known for not being breathable. Polyester suits
                                                tend to have a shine to them compared to wool and cotton suits, this can
                                                make the suit look cheap. The texture of velvet is luxurious and
                                                breathable. Velvet is a great choice for dinner party jacket and can be
                                            worn all year round.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Details Section End -->

    <!-- Related Section Begin -->
<%--    <section class="related spad">--%>
<%--        <div class="container">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12">--%>
<%--                    <h3 class="related-title">Related Product</h3>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row">--%>
<%--               <form action="/san-pham-detail" method="get">--%>
<%--                   <c:forEach items="${listSanPham4}" var="sp2">--%>
<%--                       <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">--%>
<%--                           <div class="product__item">--%>
<%--                               <div class="product__item__pic set-bg" data-setbg="/getimage/${sp2.hinhAnhURL}" style="background-image: url(&quot;img/product/product-1.jpg&quot;);">--%>
<%--                                   <span class="label">New</span>--%>
<%--                                   <ul class="product__hover">--%>
<%--                                       <li><a href="/danh-sach-yt/them/${sp2.sanPhamID}"><img src="../mainshop/mainshop2/img/icon/heart.png" alt=""></a></li>--%>
<%--                                       <li><a href="/san-pham-detail/${sp2.sanPhamID}"><img src="../mainshop/mainshop2/img/icon/search.png" alt=""></a></li>--%>
<%--                                   </ul>--%>
<%--                               </div>--%>
<%--                               <div class="product__item__text">--%>
<%--                                   <h6>${sp2.tenSanPham}</h6>--%>
<%--                                   <a href="/san-pham-detail/${sp2.sanPhamID}" class="add-cart">+ Add To Cart</a>--%>

<%--                                   <h5><fmt:formatNumber value="${sp2.giaSanPham}" pattern="0"/> VND</h5>--%>
<%--                               </div>--%>
<%--                           </div>--%>
<%--                       </div>--%>
<%--                   </c:forEach>--%>
<%--               </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </section>--%>
    <!-- Related Section End -->

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
    <script>
        function validateAndSubmit(event) {
            var soLuongDatInput = document.getElementById("soLuongDatInput");
            var soLuongDatValue = soLuongDatInput.value.trim();

            // Kiểm tra xem giá trị có phải là một số và không để trống
            if (/^\d+$/.test(soLuongDatValue) && soLuongDatValue !== "") {
                // Nếu là số và không để trống, có thể thực hiện các hành động tiếp theo, ví dụ: gửi yêu cầu đặt hàng

            } else {
                // Nếu không phải là số hoặc để trống, thông báo lỗi
                alert("Số lượng không hợp lệ. Vui lòng nhập một số nguyên dương.");
                event.preventDefault();
            }
            var soLuongDat = parseInt(document.getElementById('soLuongDatInput').value);
            var slton = parseInt("${sp.soLuongTon}");

            if (!validateSoLuong(soLuongDat, slton)) {
                // Chặn sự kiện mặc định nếu số lượng không hợp lệ
                event.preventDefault();
            }
        }

        function muaNgay() {
            var soLuongDatInput = document.getElementById("soLuongDatInput");
            var soLuongDatValue = soLuongDatInput.value.trim();

            // Kiểm tra xem giá trị có phải là một số và không để trống
            if (/^\d+$/.test(soLuongDatValue) && soLuongDatValue !== "") {
                // Nếu là số và không để trống, có thể thực hiện các hành động tiếp theo, ví dụ: gửi yêu cầu đặt hàng

            } else {
                // Nếu không phải là số hoặc để trống, thông báo lỗi
                alert("Số lượng không hợp lệ. Vui lòng nhập một số nguyên dương.");
                return false;
            }
            var soLuongDat = parseInt(document.getElementById("soLuongDatInput").value);
            var sanPhamID = "${sp.tenSanPham}";
            var hinhAnh= "${sp.hinhAnhURL}";
            var size = parseInt("${sp.size.sizeID}");
            var mausac=parseInt("${sp.mauSac.mauSacID}");
            var slton = parseInt("${sp.soLuongTon}");

            if (validateSoLuong(soLuongDat, slton)) {
                window.location.href = "/themngay/" + sanPhamID +"/"+hinhAnh+"/"+size+"/"+mausac+"?soLuongDat=" + soLuongDat;
            }
        }

        function validateSoLuong(soLuongDat, slton) {
            if (soLuongDat < 1) {
                alert('Số lượng đặt phải lớn hơn hoặc bằng 1.');
                return false;
            }

            if (soLuongDat > slton) {
                alert('Số lượng tồn không đủ. Chỉ còn ' + slton + ' sản phẩm.');
                return false;
            }

            return true;
        }


    </script>

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
    <script src="../mainshop/mainshop2/js/mixitup.min.js"></script>
    <script src="../mainshop/mainshop2/js/owl.carousel.min.js"></script>
    <script src="../mainshop/mainshop2/js/main.js"></script>
</body>

</html>