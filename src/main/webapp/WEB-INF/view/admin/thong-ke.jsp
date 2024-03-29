<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.security.Principal" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
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

    <title>Responsive</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

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
                    <div class="row">
                        <div class="col-lg-8 mb-4 order-0">
                            <div class="card">
                                <div class="d-flex align-items-end row">
                                    <div class="col-sm-7">
                                        <div class="card-body">
                                            <h5 class="card-title text-primary">Thống kê doanh số 🎉</h5>
                                            <p class="mb-4">
                                                Thống kê doanh số của cửa hàng <span
                                                    class="fw-bold">trong năm 2023</span>
                                            </p>


                                        </div>
                                    </div>
                                    <div class="col-sm-5 text-center text-sm-left">
                                        <div class="card-body pb-0 px-0 px-md-4">
                                            <img src="../admin/assets/img/illustrations/man-with-laptop-light.png"
                                                 height="140" alt="View Badge User"
                                                 data-app-dark-img="illustrations/man-with-laptop-dark.png"
                                                 data-app-light-img="illustrations/man-with-laptop-light.png">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 order-1">
                            <div class="row">
                                <div class="col-lg-6 col-md-12 col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img src="../admin/assets/img/icons/unicons/chart-success.png"
                                                         alt="chart success" class="rounded">
                                                </div>
                                                <div class="dropdown">
                                                    <button class="btn p-0" type="button" id="cardOpt3"
                                                            data-bs-toggle="dropdown" aria-haspopup="true"
                                                            aria-expanded="false">
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"
                                                         aria-labelledby="cardOpt3">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span class="fw-semibold d-block mb-1">Nhân Viên</span>
                                            <h3 class="card-title mb-2">Số lượng</h3>
                                            <small class="text-success fw-semibold"> ${totalNhanVien}</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-12 col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img src="../admin/assets/img/icons/unicons/wallet-info.png"
                                                         alt="Credit Card" class="rounded">
                                                </div>
                                                <div class="dropdown">
                                                    <button class="btn p-0" type="button" id="cardOpt6"
                                                            data-bs-toggle="dropdown" aria-haspopup="true"
                                                            aria-expanded="false">
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"
                                                         aria-labelledby="cardOpt6">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span>Số lượng sản phẩm</span>
                                            <h3 class="card-title text-nowrap mb-1">Số lượng</h3>
                                            <small class="text-success fw-semibold">${totalSanPham}</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Total Revenue -->
                        <div class="col-12 col-lg-8 order-2 order-md-3 order-lg-2 mb-4">
                            <div class="card">
                                <div class="row row-bordered g-0">
                                    <div class="col-md-10">
                                        <h5 class="card-header m-0 me-2 pb-3 text-primary">Thống kê số lượng sản phẩm bán ra</h5>
                                        <h6 class="card-header m-0 me-2 pb-3 text-primary">Tổng số lượng sản phẩm bán ra : ${totalQuantity}</h6>
                                        <div class="input-group">
                                            <input type="date" class="form-control" id="datePicker" value="${dates.format(selectedDate, 'yyyy-MM-dd')}" onchange="updateChart()">
                                        </div>
                                        <canvas id="myColumnChart" width="400" height="200"></canvas>


                                        <script>
                                            function getCurrentDate() {
                                                var currentDate = new Date();
                                                var year = currentDate.getFullYear();
                                                var month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
                                                var day = currentDate.getDate().toString().padStart(2, '0');
                                                return `${year}-${month}-${day}`;
                                            }


                                            document.getElementById('datePicker').value = getCurrentDate();

                                            var ctx = document.getElementById('myColumnChart').getContext('2d');
                                            var myColumnChart;


                                            function updateChart() {
                                                var selectedDate = document.getElementById('datePicker').value;
                                                if (selectedDate === '') {
                                                    selectedDate = getCurrentDate();
                                                    document.getElementById('datePicker').value = selectedDate;
                                                }

                                                // Redirect to the URL with the formatted date
                                                window.location.href = '/thongke?selectedDate=' + selectedDate;
                                            }
                                            function selectToday() {
                                                var currentDate = getCurrentDate();
                                                document.getElementById('datePicker').value = getCurrentDate();
                                                updateChart();
                                            }

                                            // Use the specific dates from your data for the x-axis labels
                                            var labels = [<c:forEach var="item" items="${totalQuantityByMonth}">'${item[0]}', </c:forEach>];

                                            var data = {
                                                labels: labels,
                                                datasets: [{
                                                    label: "Số lượng sản phẩm bán ra",
                                                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                                                    borderColor: 'rgba(75, 192, 192, 1)',
                                                    borderWidth: 1,
                                                    data: [<c:forEach var="item" items="${totalQuantityByMonth}">${item[1]}, </c:forEach>],
                                                }]
                                            };

                                            var options = {
                                                scales: {
                                                    y: {
                                                        beginAtZero: true,
                                                        stepSize: 1,  // Set the stepSize to 1 for integer values
                                                        ticks: {
                                                            callback: function (value) {
                                                                if (Number.isInteger(value)) {
                                                                    return value;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            };

                                            myColumnChart = new Chart(ctx, {
                                                type: 'bar',
                                                data: data,
                                                options: options
                                            });
                                        </script>
                                    </div>


                                </div>
                            </div>
                            <div class="card">
                                <h5 class="card-header m-0 me-2 pb-3 text-primary">Trạng thái đơn hàng</h5>
                                <div class="card-body">
                                    <div class="card-title d-flex align-items-start justify-content-between">

                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <h3 class="card-title text-nowrap mb-2">Đã đặt hàng</h3>
                                            <h4 class="text-danger fw-semibold">${ordersByStatus}</h4>
                                        </div>
                                        <div class="col-md-4">
                                            <h3 class="card-title text-nowrap mb-2">Vận chuyển</h3>
                                            <h4 class="text-danger fw-semibold">${ordersByStatus1}</h4>
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-md-4">
                                            <h3 class="card-title text-nowrap mb-2">Chờ xác nhận</h3>
                                            <h4 class="text-danger fw-semibold">${ordersByStatus2}</h4>
                                        </div>
                                        <div class="col-md-4">
                                            <h3 class="card-title text-nowrap mb-2">Thành công</h3>
                                            <h4 class="text-danger fw-semibold">${ordersByStatus3}</h4>
                                        </div>
                                        <div class="col-md-4">
                                            <h3 class="card-title text-nowrap mb-2">Đã hủy</h3>
                                            <h4 class="text-danger fw-semibold">${ordersByStatus4}</h4>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="card">
                                <h5 class="card-header m-0 me-2 pb-3 text-primary">Top 5 sản phẩm được mua nhiều nhất </h5>
                                <div class="card-body">
                                    <div style="width: 80%; margin: auto;">
                                        <canvas id="myBarChart" width="400" height="200"></canvas>
                                    </div>

                                    <%
                                        List<Object[]> topProducts = (List<Object[]>) request.getAttribute("topProducts");

                                        if (topProducts != null && !topProducts.isEmpty()) {
                                            StringBuilder labels = new StringBuilder("[");
                                            StringBuilder data = new StringBuilder("[");
                                            for (Object[] product : topProducts) {
                                                labels.append("\"").append(product[0]).append("\",");
                                                data.append(product[1]).append(",");
                                            }
                                            labels.setLength(labels.length() - 1);
                                            data.setLength(data.length() - 1);
                                            labels.append("]");
                                            data.append("]");
                                    %>

                                    <script>
                                        var data = {
                                            labels: <%= labels %>,
                                            datasets: [{
                                                label: 'Sản phẩm được mua nhiều nhất',
                                                data: <%= data %>,
                                                backgroundColor: [
                                                    'rgba(255, 99, 132, 0.2)',
                                                    'rgba(54, 162, 235, 0.2)',
                                                    'rgba(255, 206, 86, 0.2)',
                                                    'rgba(75, 192, 192, 0.2)',
                                                    'rgba(153, 102, 255, 0.2)'
                                                ],
                                                borderColor: [
                                                    'rgba(255, 99, 132, 1)',
                                                    'rgba(54, 162, 235, 1)',
                                                    'rgba(255, 206, 86, 1)',
                                                    'rgba(75, 192, 192, 1)',
                                                    'rgba(153, 102, 255, 1)'
                                                ],
                                                borderWidth: 1
                                            }]
                                        };

                                        var options = {
                                            scales: {
                                                y: {
                                                    display: false,
                                                }
                                            },
                                            plugins: {
                                                datalabels: {
                                                    anchor: 'end',
                                                    align: 'end',
                                                    formatter: function(value, context) {
                                                        return value; // Hiển thị giá trị trên đỉnh của mỗi cột
                                                    }
                                                }
                                            }
                                        };

                                        var ctx = document.getElementById('myBarChart').getContext('2d');
                                        var myBarChart = new Chart(ctx, {
                                            type: 'bar',
                                            data: data,
                                            options: options
                                        });
                                    </script>






                                    <%
                                        } else {
                                            // Hiển thị thông báo hoặc xử lý trường hợp không có dữ liệu
                                            out.println("Không có dữ liệu để hiển thị.");
                                        }
                                    %>
                                </div>

                            </div>

                            <div class="card">
                                <h5 class="card-header m-0 me-2 pb-3 text-primary">Danh sách sản phẩm sắp hết hàng</h5>
                                <br>
                                <form action="<c:url value='/thongke/sapHetHang'/>" method="post" class="row g-3" id="myForm">
                                    <div class="col-md-2">
                                        <label class="form-label"> Nhỏ hơn</label>
                                        <input type="number" class="form-control" value="${soLuongTon}" name="soLuongTon" min="1" max="1000000000" required>
                                    </div>
                                    <!-- Add a radio button for the user to choose the output format -->
                                    <div class="col-md-2">
                                        <label style="margin-top: 22%">
                                            <input type="radio" name="outputFormat" value="table" checked> Hiển thị bảng
                                        </label>
                                    </div>
                                    <div class="col-md-2">
                                        <label style="margin-top: 22%">
                                            <input type="radio" name="outputFormat" value="excel"> Xuất Excel
                                        </label>
                                    </div>
                                    <div class="col-md-2">
                                        <button style="margin-top: 17%" type="submit" id="submitButton" class="btn btn-primary">Tìm</button>
                                    </div>
                                </form>

                                <br>
                                <table class="table table-success table-striped" >
                                    <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Sản phẩm</th>
                                        <th>Kích cỡ</th>
                                        <th>Màu sắc</th>
                                        <th>Chất liệu</th>
                                        <th>Thương hiệu</th>
                                        <th>Số Lượng</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="row" items="${ListDanhSachSapHetHang15}" varStatus="iterStat">
                                        <tr>
                                            <td><c:out value="${iterStat.index+1}" /></td>
                                            <td><c:out value="${row[0]}" /></td>
                                            <td><c:out value="${row[1]}" /></td>
                                            <td><c:out value="${row[2]}" /></td>
                                            <td><c:out value="${row[3]}" /></td>
                                            <td><c:out value="${row[4]}" /></td>
                                            <td><c:out value="${row[5]}" /></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <!--/ Total Revenue -->
                        <div class="col-12 col-md-8 col-lg-4 order-3 order-md-2">
                            <div class="row">
                                <div class="col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img src="../admin/assets/img/icons/unicons/paypal.png"
                                                         alt="Credit Card" class="rounded">
                                                </div>
                                                <div class="dropdown">
                                                    <button class="btn p-0" type="button" id="cardOpt4"
                                                            data-bs-toggle="dropdown" aria-haspopup="true"
                                                            aria-expanded="false">
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"
                                                         aria-labelledby="cardOpt4">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span class="d-block mb-1">Tổng tiền</span>
                                            <h3 class="card-title text-nowrap mb-2">Doanh thu</h3>
                                            <h4 class="text-danger fw-semibold">
                                                <fmt:formatNumber value="${totalTongTien}" pattern="0"/> VND</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img src="../admin/assets/img/icons/unicons/cc-primary.png"
                                                         alt="Credit Card" class="rounded">
                                                </div>
                                                <div class="dropdown">
                                                    <button class="btn p-0" type="button" id="cardOpt1"
                                                            data-bs-toggle="dropdown" aria-haspopup="true"
                                                            aria-expanded="false">
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu" aria-labelledby="cardOpt1">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span class="fw-semibold d-block mb-1">Khách hàng</span>
                                            <h3 class="card-title mb-2">Số lượng</h3>
                                            <small class="text-success fw-semibold"> ${totalKhachHang}</small>
                                        </div>
                                    </div>
                                </div>
                                <!-- </div>
                <div class="row"> -->
                                <div class="col-12 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <canvas id="myLineChart" width="400" height="200"></canvas>

                                            <script>
                                                var data = {
                                                    labels: [
                                                        <c:forEach var="item" items="${totalRevenueByMonth}">
                                                        '<c:out value="${item[0]}" />',
                                                        </c:forEach>
                                                    ],
                                                    datasets: [{
                                                        label: "Số tiền nhận vào theo ngày",
                                                        borderColor: 'rgba(75, 192, 192, 1)',
                                                        borderWidth: 2,
                                                        fill: false,
                                                        data: [
                                                            <c:forEach var="item" items="${totalRevenueByMonth}">
                                                            <c:out value="${item[1]}" />,
                                                            </c:forEach>
                                                        ],
                                                    }]
                                                };

                                                var options = {
                                                    scales: {
                                                        x: {
                                                            type: 'category',
                                                            position: 'bottom'
                                                        },
                                                        y: {
                                                            beginAtZero: true
                                                        }
                                                    }
                                                };

                                                var ctx = document.getElementById('myLineChart').getContext('2d');
                                                var myLineChart = new Chart(ctx, {
                                                    type: 'line',
                                                    data: data,
                                                    options: options
                                                });
                                            </script>
                                        </div>

                                    </div>
                                </div>
                                <div class="col-12 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <canvas id="myColumnChart1" width="400" height="200"></canvas>

                                            <script>
                                                var data = {
                                                    labels: [<c:forEach var="item" items="${getTotalRevenueForCurrentMonth}"><c:out value="${item[0]}" />, </c:forEach>],
                                                    datasets: [{
                                                        label: "Số tiền tháng này",
                                                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                                                        borderColor: 'rgba(75, 192, 192, 1)',
                                                        borderWidth: 1,
                                                        data: [<c:forEach var="item" items="${getTotalRevenueForCurrentMonth}"><c:out value="${item[1]}" />, </c:forEach>],
                                                    }]
                                                };

                                                var options = {
                                                    scales: {
                                                        x: {
                                                            type: 'category',
                                                            labels: [<c:forEach var="item" items="${getTotalRevenueForCurrentMonth}"><c:out value="${item[0]}" />, </c:forEach>],
                                                        },
                                                        y: {
                                                            beginAtZero: true
                                                        }
                                                    }
                                                };

                                                var ctx = document.getElementById('myColumnChart1').getContext('2d');
                                                var myBarChart = new Chart(ctx, {
                                                    type: 'bar',
                                                    data: data,
                                                    options: options
                                                });
                                            </script>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Content -->

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
