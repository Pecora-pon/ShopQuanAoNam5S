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

    <title>Màu sắc</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
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
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->

        <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
            <div class="app-brand demo">
                <a href="/trang-chu" class="app-brand-link">
              <span class="app-brand-logo demo">
                <svg
                        width="25"
                        viewBox="0 0 25 42"
                        version="1.1"
                        xmlns="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                >
                  <defs>
                    <path
                            d="M13.7918663,0.358365126 L3.39788168,7.44174259 C0.566865006,9.69408886 -0.379795268,12.4788597 0.557900856,15.7960551 C0.68998853,16.2305145 1.09562888,17.7872135 3.12357076,19.2293357 C3.8146334,19.7207684 5.32369333,20.3834223 7.65075054,21.2172976 L7.59773219,21.2525164 L2.63468769,24.5493413 C0.445452254,26.3002124 0.0884951797,28.5083815 1.56381646,31.1738486 C2.83770406,32.8170431 5.20850219,33.2640127 7.09180128,32.5391577 C8.347334,32.0559211 11.4559176,30.0011079 16.4175519,26.3747182 C18.0338572,24.4997857 18.6973423,22.4544883 18.4080071,20.2388261 C17.963753,17.5346866 16.1776345,15.5799961 13.0496516,14.3747546 L10.9194936,13.4715819 L18.6192054,7.984237 L13.7918663,0.358365126 Z"
                            id="path-1"
                    ></path>
                    <path
                            d="M5.47320593,6.00457225 C4.05321814,8.216144 4.36334763,10.0722806 6.40359441,11.5729822 C8.61520715,12.571656 10.0999176,13.2171421 10.8577257,13.5094407 L15.5088241,14.433041 L18.6192054,7.984237 C15.5364148,3.11535317 13.9273018,0.573395879 13.7918663,0.358365126 C13.5790555,0.511491653 10.8061687,2.3935607 5.47320593,6.00457225 Z"
                            id="path-3"
                    ></path>
                    <path
                            d="M7.50063644,21.2294429 L12.3234468,23.3159332 C14.1688022,24.7579751 14.397098,26.4880487 13.008334,28.506154 C11.6195701,30.5242593 10.3099883,31.790241 9.07958868,32.3040991 C5.78142938,33.4346997 4.13234973,34 4.13234973,34 C4.13234973,34 2.75489982,33.0538207 2.37032616e-14,31.1614621 C-0.55822714,27.8186216 -0.55822714,26.0572515 -4.05231404e-15,25.8773518 C0.83734071,25.6075023 2.77988457,22.8248993 3.3049379,22.52991 C3.65497346,22.3332504 5.05353963,21.8997614 7.50063644,21.2294429 Z"
                            id="path-4"
                    ></path>
                    <path
                            d="M20.6,7.13333333 L25.6,13.8 C26.2627417,14.6836556 26.0836556,15.9372583 25.2,16.6 C24.8538077,16.8596443 24.4327404,17 24,17 L14,17 C12.8954305,17 12,16.1045695 12,15 C12,14.5672596 12.1403557,14.1461923 12.4,13.8 L17.4,7.13333333 C18.0627417,6.24967773 19.3163444,6.07059163 20.2,6.73333333 C20.3516113,6.84704183 20.4862915,6.981722 20.6,7.13333333 Z"
                            id="path-5"
                    ></path>
                  </defs>
                  <g id="g-app-brand" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                    <g id="Brand-Logo" transform="translate(-27.000000, -15.000000)">
                      <g id="Icon" transform="translate(27.000000, 15.000000)">
                        <g id="Mask" transform="translate(0.000000, 8.000000)">
                          <mask id="mask-2" fill="white">
                            <use xlink:href="#path-1"></use>
                          </mask>
                          <use fill="#696cff" xlink:href="#path-1"></use>
                          <g id="Path-3" mask="url(#mask-2)">
                            <use fill="#696cff" xlink:href="#path-3"></use>
                            <use fill-opacity="0.2" fill="#FFFFFF" xlink:href="#path-3"></use>
                          </g>
                          <g id="Path-4" mask="url(#mask-2)">
                            <use fill="#696cff" xlink:href="#path-4"></use>
                            <use fill-opacity="0.2" fill="#FFFFFF" xlink:href="#path-4"></use>
                          </g>
                        </g>
                        <g
                                id="Triangle"
                                transform="translate(19.000000, 11.000000) rotate(-300.000000) translate(-19.000000, -11.000000) "
                        >
                          <use fill="#696cff" xlink:href="#path-5"></use>
                          <use fill-opacity="0.2" fill="#FFFFFF" xlink:href="#path-5"></use>
                        </g>
                      </g>
                    </g>
                  </g>
                </svg>
              </span>
                    <span class="app-brand-text demo menu-text fw-bolder ms-2">Quản trị</span>
                </a>

                <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
                    <i class="bx bx-chevron-left bx-sm align-middle"></i>
                </a>
            </div>

            <div class="menu-inner-shadow"></div>

            <ul class="menu-inner py-1">
                <!-- Dashboard -->
                <li class="menu-item active">
                    <a href="/trang-chu" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-home-circle"></i>
                        <div data-i18n="Analytics">Tổng quan</div>
                    </a>
                </li>

                <!-- Layouts -->


                <li class="menu-header small text-uppercase"><span class="menu-header-text">Quản lý sản phẩm</span></li>

                <!-- User interface -->
                <li class="menu-item">
                    <a href="javascript:void(0)" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-box"></i>
                        <div data-i18n="User interface">Sản phẩm</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="http://localhost:8080/mau-sac" class="menu-link">
                                <div data-i18n="Accordion">Màu sắc</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="http://localhost:8080/size" class="menu-link">
                                <div data-i18n="Accordion">Size</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="http://localhost:8080/chat-lieu" class="menu-link">
                                <div data-i18n="Accordion">Chất liệu</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="http://localhost:8080/nha-cung-cap" class="menu-link">
                                <div data-i18n="Accordion">Nhà cung cấp</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="http://localhost:8080/thuong-hieu" class="menu-link">
                                <div data-i18n="Accordion">Thương hiệu</div>
                            </a>
                        </li>

                    </ul>
                </li>

                <!-- Extended components -->
                <li class="menu-item">
                    <a href="http://localhost:8080/san-pham" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-copy"></i>
                        <div data-i18n="Extended UI">Danh sách sản phẩm</div>
                    </a>
                </li>


                <li class="menu-header small text-uppercase"><span
                        class="menu-header-text">Khách hàng &amp; Nhân viên</span>
                </li>

                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-detail"></i>
                        <div data-i18n="Form Elements">Khách hàng</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="http://localhost:8080/khach-hang" class="menu-link">
                                <div data-i18n="Basic Inputs">Quản lý khách hàng</div>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-detail"></i>
                        <div data-i18n="Form Layouts">Nhân viên</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="http://localhost:8080/nhan-vien" class="menu-link">
                                <div data-i18n="Vertical Form">Quản lý nhân viên</div>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="menu-item">
                    <a href="http://localhost:8080/thongke" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-file"></i>
                        <div data-i18n="Analytics">Thống kê</div>
                    </a>

                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-shopping-bag"></i>
                        <div data-i18n="Form Layouts">Đơn hàng</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="http://localhost:8080/don-hang" class="menu-link">
                                <div data-i18n="Vertical Form">Danh sách đơn hàng</div>
                            </a>
                        </li>

                    </ul>
                </li>

                <li class="menu-header small text-uppercase"><span class="menu-header-text">Khuyến mại</span></li>

                <li class="menu-item">
                    <a href="http://localhost:8080/giam-gia" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-basket"></i>
                        <div data-i18n="Analytics">Danh sách khuyến mại</div>
                    </a>

                </li>
                <li class="menu-item">
                    <a href="/logout" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-door-open"></i>
                        <div data-i18n="Analytics">Log out</div>
                    </a>

                </li>
            </ul>
        </aside>
        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">
            <!-- Navbar -->

            <nav
                    class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
                    id="layout-navbar"
            >
                <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
                    <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                        <i class="bx bx-menu bx-sm"></i>
                    </a>
                </div>

                <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
                    <!-- Search -->
                    <div class="navbar-nav align-items-center">
                        <div class="nav-item d-flex align-items-center">
                            <i class="bx bx-search fs-4 lh-0"></i>
                            <input
                                    type="text"
                                    class="form-control border-0 shadow-none"
                                    placeholder="Search..."
                                    aria-label="Search..."
                                    id="searchInput"
                            />
                        </div>
                    </div>
                    <!-- /Search -->

                    <ul class="navbar-nav flex-row align-items-center ms-auto">
                        <!-- Place this tag where you want the button to render. -->

                        <!-- User -->
                        <li class="nav-item navbar-dropdown dropdown-user dropdown">
                            <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);"
                               data-bs-toggle="dropdown">
                                <div class="avatar avatar-online">
                                    <img src="../admin/assets/img/avatars/1.png" alt
                                         class="w-px-40 h-auto rounded-circle"/>
                                </div>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end">
                                <li>
                                    <div class="flex-shrink-0 me-3">
                                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                                            <!-- Nếu đã đăng nhập, hiển thị tên người dùng và nút đăng xuất -->
                                            <div style="display: flex; align-items: center;">
                                                <span style="color: black;">Xin chào, <%= request.getUserPrincipal().getName() %>!</span>

                                            </div>
                                        </sec:authorize>

                                        <sec:authorize access="!hasRole('ROLE_ADMIN')">
                                            <!-- Nếu chưa đăng nhập, hiển thị liên kết Đăng nhập -->
                                            <div>
                                                <a href="/login" style="color: white;">Đăng nhập</a>
                                            </div>
                                        </sec:authorize>
                                    </div>
                                </li>
                                <li>
                                    <div class="dropdown-divider"></div>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/logout">
                                        <i class="bx bx-power-off me-2"></i>
                                        <span class="align-middle">Log Out</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <!--/ User -->
                    </ul>
                </div>
            </nav>

            <!-- / Navbar -->

            <!-- Content wrapper -->
            <div class="content-wrapper">
                <div class="container-xxl flex-grow-1 container-p-y">
                    <!--Content -->
                    <!-- Table add -->
                    <div class="card">
                        <h3 class="card-header">Quản lý màu sắc</h3>
                        <div class="card-body">
                            <form:form action="/ban-hang/insert" modelAttribute="dh" method="post">

                                <div class="mt-2">
                                    <button type="submit" class="btn btn-primary me-2">Thêm</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                    <style>
                        /* Add a style block to include additional CSS if needed */
                        .inline-block-container {
                            position: relative;
                            display: inline-block;
                            vertical-align: top;
                            margin-right: 10px; /* Increase margin for spacing */
                            border: 2px solid #ddd; /* Increase border width */
                            border-radius: 15px; /* Increase border-radius for rounded corners */
                            padding: 10px; /* Increase padding for spacing */
                        }

                        .form-container {
                            position: absolute;
                            top: 100%; /* Position the form below the inline-block container */
                            left: 0;
                            display: none;
                        }

                        .inline-block-container a {
                            display: block;
                            color: white;
                            text-decoration: none;
                        }

                        .product-image img {
                            max-width: 100%;
                            max-height: 100%;
                        }
                    </style>
                    <!-- Table add -->
                    <!--Content -->
                    <div class="card">
                        <table class="table custom-table">
                            <tbody class="table-border-bottom-0">
                            <tr><input type="hidden" id="currentDonHangID" value="">
                                <c:forEach items="${listBanHang}" var="donhang" varStatus="i">
                                    <td class="inline-block-container">
                                        <div onclick="showProductForm(${i.index}, '${donhang.donHangID}')"
                                             data-donHangId="${donhang.donHangID}"
                                             style="width: 50px; height: 50px; background-color: green; text-align: center; line-height: 50px; border-radius: 10px;">
                                            <a style="color: white; text-decoration: none;">${donhang.tenKhach}</a>
                                        </div>
                                        <div class="product-image">
                                            <img src="../mainshop/mainshop2/img/logo.png" alt="">
                                        </div>
                                        <div id="productForm${i.index}" style="display: none;">
                                            <!-- Your product form goes here -->
                                            <!-- Form fields go here -->
                                            <input type="hidden" name="donhangid" id="donhangid"
                                                   value="${donhang.donHangID}">
                                            <div>
                                                <a href="/ban-hang/hienthi?donhangid=${donhang.donHangID}"class="btn btn-primary">Xem Đơn Hàng</a>
                                            </div>
                                            <div>
                                                <a href="javascript:void(0);" onclick="confirmDelete('${donhang.donHangID}')" class="btn btn-primary">Xóa</a>
                                            </div>
                                            <div>
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                        data-bs-target="#exampleModal"
                                                        onclick="openModalWithDonHangID('${donhang.donHangID}')">Thêm
                                                    sản phẩm
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </c:forEach>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <script>
                        function confirmDelete(donHangID) {
                            var result = confirm("Bạn có muốn xóa?");

                            if (result) {
                                // User confirmed, proceed with the delete operation
                                window.location.href = "/ban-hang/delete1/" + donHangID;
                            } else {
                                // User canceled
                                alert("Delete operation canceled.");
                            }
                        }
                        function openModalWithDonHangID(donHangID) {
                            document.getElementById('currentDonHangID').value = donHangID;
                            console.log("ádjflsdjf", donHangID);
                            console.log("Don Hang ID in Modal:", document.getElementById('currentDonHangID').value);
                            $('#exampleModal').modal('show');
                        }
                    </script>
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Sản Phẩm</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="row">
                                    <div class="modal-body">
<%--                                        <form id="searchForm" action="/ban-hang/timkiem" method="get" class="d-flex align-items-center">--%>
<%--                                            <label class="me-2">Tìm Kiếm:</label>--%>
<%--                                            <input type="text" name="ten" class="form-control" required>--%>
<%--                                            <button type="submit" class="btn btn-primary ms-2">Tìm Kiếm</button>--%>
<%--                                        </form>--%>
                                        <c:forEach items="${listSanPham}" var="sanpham">
                                            <div class="product-row">
                                                <img src="/getimage/${sanpham.hinhAnhURL}" class="product-image">
                                                <div class="product-details">
                                                    <h4>${sanpham.tenSanPham}</h4>
                                                    <p>Size: ${sanpham.size.tenSize}</p>
                                                    <p>Màu sắc: ${sanpham.mauSac.tenMauSac}</p>
                                                    <a class="product-link" href="#"
                                                       onclick="addProductToOrder('${sanpham.sanPhamID}')"> Thêm </a>

                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            // Khởi tạo modal
                            var myModal = new bootstrap.Modal(document.getElementById('exampleModal'));

                            $("#searchForm").submit(function (event) {
                                event.preventDefault();

                                var formData = $(this).serialize();

                                $.ajax({
                                    type: "GET",
                                    url: "/ban-hang/timkiem",
                                    data: formData,
                                    success: function (response) {
                                        // Cập nhật nội dung phần body của modal với phản hồi
                                        $("#exampleModal .modal-body").html($(response).find('.modal-body').html());

                                        // Khi modal đã được hiển thị, bạn cần kích hoạt nó bằng cách gọi show()
                                        myModal.show();
                                    },
                                    error: function (error) {
                                        console.log("Lỗi:", error);
                                    }
                                });
                            });

                            // Sự kiện được kích hoạt sau khi modal đã được hiển thị
                            $('#exampleModal').on('shown.bs.modal', function () {
                                // Bất kỳ hành động nào bạn muốn thực hiện sau khi modal hiển thị
                            });
                        });
                        function addProductToOrder(sanPhamID) {
                            var currentDonHangID = document.getElementById('currentDonHangID').value;
                            var url = '/ban-hang/insertsp/' + sanPhamID + '/' + currentDonHangID;
                            // Set the href attribute dynamically before redirecting
                            document.querySelector('.product-link').href = url;
                            window.location.href = url;
                        }
                    </script>
                    <script>

                        var selectedDonHangId;

                        function showProductForm(index, donHangId) {
                            console.log("donHangChiTietID:", donHangId);
                            selectedDonHangId = donHangId;
                            // Hiển thị form sản phẩm
                            // ...
                        }

                        function selectProduct(sanPhamId) {
                            console.log("sanPhamId:", sanPhamId);
                            console.log("selectedDonHangId:", selectedDonHangId);
                            if (selectedDonHangId && sanPhamId) {
                                var url = "/ban-hang/insertsp/" + sanPhamId + "/" + selectedDonHangId;
                                window.location.href = url;
                            } else {
                                console.error("Không thể xác định donHangId hoặc sanPhamId.");
                            }
                        }
                    </script>
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
                            flex-grow: 1;
                        }

                        .radio-input {
                            margin-left: auto;
                            margin-right: 10px;
                        }
                    </style>
                    <script>
                        function showProductForm(index) {
                            var selectedForm = document.getElementById('productForm' + index);

                            // Toggle the visibility of the form
                            if (selectedForm.style.display === 'block') {
                                selectedForm.style.display = 'none'; // Hide the form
                            } else {
                                // Hide all other forms
                                document.querySelectorAll('.form-container').forEach(function (form) {
                                    form.style.display = 'none';
                                });

                                selectedForm.style.display = 'block'; // Show the form
                            }
                        }
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
            <!-- Content wrapper -->

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
<script>
    // Đặt sự kiện khi người dùng ấn Enter trên input
    $('#searchInput').keypress(function (e) {
        if (e.which === 13) { // Kiểm tra nếu phím ấn là Enter
            e.preventDefault(); // Ngăn chặn hành động mặc định của nút Enter

            // Lấy giá trị từ input và chuyển đổi thành chữ thường
            var searchTerm = $(this).val().trim().toLowerCase();

            // Kiểm tra giá trị nhập và chuyển hướng tương ứng
            if (searchTerm === 'khach hang' || searchTerm === 'khách hàng') {
                window.location.href = '/khach-hang';
            } else if (searchTerm === 'hien thi' || searchTerm === 'hiển thị') {
                window.location.href = '/hien-thi';
            } else if (searchTerm === 'chat lieu' || searchTerm === 'chất liệu') {
                window.location.href = '/chat-lieu';
            } else if (searchTerm === 'mau sac' || searchTerm === 'thương hiệu') {
                window.location.href = '/mau-sac';
            } else if (searchTerm === 'nhap kho' || searchTerm === 'nhập kho') {
                window.location.href = '/nhap-kho';
            } else if (searchTerm === 'size') {
                window.location.href = '/size';
            } else if (searchTerm === 'thuong hieu' || searchTerm === 'thương hiệu') {
                window.location.href = '/thuong-hieu';
            } else if (searchTerm === 'giam gia' || searchTerm === 'giảm giá') {
                window.location.href = '/giam-gia';
            } else if (searchTerm === 'giam gia chi tiet' || searchTerm === 'giảm giá chi tiết') {
                window.location.href = '/giam-gia-chi-tiet';
            } else {
                // Xử lý chuyển hướng mặc định hoặc thông báo lỗi nếu cần
                window.location.href = '/non-find' + encodeURIComponent(searchTerm.replace(/\s+/g, '-'));
            }
        }
    });
</script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>