<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <%--                <li class="menu-item">--%>
                <%--                    <a href="" class="menu-link menu-toggle">--%>
                <%--                        <i class="menu-icon tf-icons bx bx-layout"></i>--%>
                <%--                        <div data-i18n="Layouts">Layouts</div>--%>
                <%--                    </a>--%>

                <%--                    <ul class="menu-sub">--%>
                <%--                        <li class="menu-item">--%>
                <%--                            <a href="layouts-without-menu.html" class="menu-link">--%>
                <%--                                <div data-i18n="Without menu">Without menu</div>--%>
                <%--                            </a>--%>
                <%--                        </li>--%>
                <%--                        <li class="menu-item">--%>
                <%--                            <a href="layouts-without-navbar.html" class="menu-link">--%>
                <%--                                <div data-i18n="Without navbar">Without navbar</div>--%>
                <%--                            </a>--%>
                <%--                        </li>--%>
                <%--                        <li class="menu-item">--%>
                <%--                            <a href="layouts-container.html" class="menu-link">--%>
                <%--                                <div data-i18n="Container">Container</div>--%>
                <%--                            </a>--%>
                <%--                        </li>--%>
                <%--                        <li class="menu-item">--%>
                <%--                            <a href="layouts-fluid.html" class="menu-link">--%>
                <%--                                <div data-i18n="Fluid">Fluid</div>--%>
                <%--                            </a>--%>
                <%--                        </li>--%>
                <%--                        <li class="menu-item">--%>
                <%--                            <a href="layouts-blank.html" class="menu-link">--%>
                <%--                                <div data-i18n="Blank">Blank</div>--%>
                <%--                            </a>--%>
                <%--                        </li>--%>
                <%--                    </ul>--%>
                <%--                </li>--%>

                <li class="menu-header small text-uppercase">
                    <span class="menu-header-text">Account</span>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-dock-top"></i>
                        <div data-i18n="Account Settings">Tài khoản</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="/responsive/thong-tin-tai-khoan" class="menu-link">
                                <div data-i18n="Account">Thông tin</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="/doimatkhau" class="menu-link">
                                <div data-i18n="Notifications">Đổi mật khẩu</div>
                            </a>
                        </li>

                    </ul>
                </li>

                <%--                <li class="menu-item">--%>
                <%--                    <a href="javascript:void(0);" class="menu-link menu-toggle">--%>
                <%--                        <i class="menu-icon tf-icons bx bx-cube-alt"></i>--%>
                <%--                        <div data-i18n="Misc">Misc</div>--%>
                <%--                    </a>--%>
                <%--                    <ul class="menu-sub">--%>
                <%--                        <li class="menu-item">--%>
                <%--                            <a href="pages-misc-error.html" class="menu-link">--%>
                <%--                                <div data-i18n="Error">Error</div>--%>
                <%--                            </a>--%>
                <%--                        </li>--%>
                <%--                        <li class="menu-item">--%>
                <%--                            <a href="pages-misc-under-maintenance.html" class="menu-link">--%>
                <%--                                <div data-i18n="Under Maintenance">Under Maintenance</div>--%>
                <%--                            </a>--%>
                <%--                        </li>--%>
                <%--                    </ul>--%>
                <%--                </li>--%>
                <!-- Components -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text">Quản lý sản phẩm</span></li>

                <!-- User interface -->
                <li class="menu-item">
                    <a href="javascript:void(0)" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-box"></i>
                        <div data-i18n="User interface">Sản phẩm</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="ui-accordion.html" class="menu-link">
                                <div data-i18n="Accordion">Màu sắc</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-accordion.html" class="menu-link">
                                <div data-i18n="Accordion">Size</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-accordion.html" class="menu-link">
                                <div data-i18n="Accordion">Danh mục</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-accordion.html" class="menu-link">
                                <div data-i18n="Accordion">Thương hiệu</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-accordion.html" class="menu-link">
                                <div data-i18n="Accordion">Hình ảnh</div>
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- Extended components -->
                <li class="menu-item">
                    <a href="" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-copy"></i>
                        <div data-i18n="Extended UI">Danh sách sản phẩm</div>
                    </a>
                    <%--                    <ul class="menu-sub">--%>
                    <%--                        <li class="menu-item">--%>
                    <%--                            <a href="extended-ui-perfect-scrollbar.html" class="menu-link">--%>
                    <%--                                <div data-i18n="Perfect Scrollbar">Perfect scrollbar</div>--%>
                    <%--                            </a>--%>
                    <%--                        </li>--%>
                    <%--                        <li class="menu-item">--%>
                    <%--                            <a href="extended-ui-text-divider.html" class="menu-link">--%>
                    <%--                                <div data-i18n="Text Divider">Text Divider</div>--%>
                    <%--                            </a>--%>
                    <%--                        </li>--%>
                    <%--                    </ul>--%>
                </li>


                <!-- Forms & Tables -->
                <li class="menu-header small text-uppercase"><span
                        class="menu-header-text">Khách hàng &amp; Nhân viên</span>
                </li>
                <!-- Forms -->
                <li class="menu-item">
                    <a href="" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-file"></i>
                        <div data-i18n="Analytics">Chức vụ</div>
                    </a>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-detail"></i>
                        <div data-i18n="Form Elements">Khách hàng</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="/trang-chu/login" class="menu-link">
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
                            <a href="form-layouts-vertical.html" class="menu-link">
                                <div data-i18n="Vertical Form">Quản lý nhân viên</div>
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- Tables -->
                <%--                <li class="menu-item">--%>
                <%--                    <a href="tables-basic.html" class="menu-link">--%>
                <%--                        <i class="menu-icon tf-icons bx bx-table"></i>--%>
                <%--                        <div data-i18n="Tables">Tables</div>--%>
                <%--                    </a>--%>
                <%--                </li>--%>
                <!-- Misc -->
                <li class="menu-header small text-uppercase"><span
                        class="menu-header-text">Đơn hàng &amp; Vận chuyển</span></li>
                <li class="menu-item">
                    <a href="" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-file"></i>
                        <div data-i18n="Analytics">Thống kê</div>
                    </a>
                    <%--                    <a--%>
                    <%--                            href="https://github.com/themeselection/sneat-html-admin-template-free/issues"--%>
                    <%--                            target="_blank"--%>
                    <%--                            class="menu-link"--%>
                    <%--                    >--%>
                    <%--                        <i class="menu-icon tf-icons bx bx-support"></i>--%>
                    <%--                        <div data-i18n="Support">Support</div>--%>
                    <%--                    </a>--%>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-shopping-bag"></i>
                        <div data-i18n="Form Layouts">Đơn hàng</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="form-layouts-vertical.html" class="menu-link">
                                <div data-i18n="Vertical Form">Danh sách đơn hàng</div>
                            </a>
                        </li>

                    </ul>
                    <%--                    <a--%>
                    <%--                            href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/"--%>
                    <%--                            target="_blank"--%>
                    <%--                            class="menu-link"--%>
                    <%--                    >--%>
                    <%--                        <i class="menu-icon tf-icons bx bx-file"></i>--%>
                    <%--                        <div data-i18n="Documentation">Đơn hàng</div>--%>
                    <%--                    </a>--%>

                </li>
                <li class="menu-item">
                    <a href="" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-car"></i>
                        <div data-i18n="Analytics">Vận chuyển</div>
                    </a>

                </li>
                <!--/ Khuyến mãi -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text">Khuyến mại</span></li>

                <li class="menu-item">
                    <a href="" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-basket"></i>
                        <div data-i18n="Analytics">Danh sách khuyến mại</div>
                    </a>

                </li>
                <li class="menu-item">
                    <a href="" class="menu-link">
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
                            />
                        </div>
                    </div>
                    <!-- /Search -->

                    <ul class="navbar-nav flex-row align-items-center ms-auto">
                        <!-- Place this tag where you want the button to render. -->
                        <li class="nav-item lh-1 me-3">
                            <a
                                    class="github-button"
                                    href="https://github.com/themeselection/sneat-html-admin-template-free"
                                    data-icon="octicon-star"
                                    data-size="large"
                                    data-show-count="true"
                                    aria-label="Star themeselection/sneat-html-admin-template-free on GitHub"
                            >Star</a
                            >
                        </li>

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
                                    <a class="dropdown-item" href="#">
                                        <div class="d-flex">
                                            <div class="flex-shrink-0 me-3">
                                                <div class="avatar avatar-online">
                                                    <img src="../admin/assets/img/avatars/1.png" alt
                                                         class="w-px-40 h-auto rounded-circle"/>
                                                </div>
                                            </div>
                                            <div class="flex-grow-1">
                                                <span class="fw-semibold d-block">John Doe</span>
                                                <small class="text-muted">Admin</small>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <div class="dropdown-divider"></div>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#">
                                        <i class="bx bx-user me-2"></i>
                                        <span class="align-middle">My Profile</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#">
                                        <i class="bx bx-cog me-2"></i>
                                        <span class="align-middle">Settings</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#">
                        <span class="d-flex align-items-center align-middle">
                          <i class="flex-shrink-0 bx bx-credit-card me-2"></i>
                          <span class="flex-grow-1 align-middle">Billing</span>
                          <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="dropdown-divider"></div>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="auth-login-basic.html">
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
                    <div class="head-shop d-block overflow-hidden position-relative">
                        <img src="../admin/assets/img/backgrounds/background_show_room.webp" alt="" width="1200"
                             height="253" class="d-block w-100">
                    </div>
                    <br>
                    <br>
                    <div class="row ">
                        <div class="left-content col-xl-4 col-lg-6 col-md-10 col-12 ps-0 pe-0">
                            <div class="list-group card">
                                <a href="#"
                                   class="list-group-item list-group-item-action flex-column align-items-start">
                                    <div class="d-flex w-100 justify-content-between">

                                        <h5 class="mb-1 text-danger"><i class="menu-icon tf-icons bx bx-building-house"></i>5S Fasion Lê Lợi</h5>

                                    </div>
                                    <p class="mb-1">Số 92 Lê Lợi, Phường Đề Thám, TP Thái Bình.</p>
                                    <small>Giờ mở cửa: 07:30 - 22:00.</small>
                                </a>
                                <a href="#"
                                   class="list-group-item list-group-item-action flex-column align-items-start">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1 text-danger"><i class="menu-icon tf-icons bx bx-building-house"></i> 5S Fashion - Hưng Hà</h5>
                                    </div>
                                    <p class="mb-1">Ngã 6, thị trấn Hưng Hà, Thái Bình (Cách chợ mới 100m)</p>
                                    <small class="text-muted">Giờ mở cửa: 07:30 - 22:00</small>
                                </a>
                                <a href="#"
                                   class="list-group-item list-group-item-action flex-column align-items-start">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1 text-danger"><i class="menu-icon tf-icons bx bx-building-house"></i> 5S Fashion - Quỳnh Phụ</h5>

                                    </div>
                                    <p class="mb-1">Số 50 Nguyễn Du, thị trấn Quỳnh Côi, Quỳnh Phụ, Thái Bình (Cách cầu
                                        Tây 30m)</p>
                                    <small class="text-muted">Giờ mở cửa: 07:30 - 22:00.</small>
                                </a> <a href="#"
                                        class="list-group-item list-group-item-action flex-column align-items-start">
                                <div class="d-flex w-100 justify-content-between">
                                    <h5 class="mb-1 text-danger"><i class="menu-icon tf-icons bx bx-building-house"></i> 5S Fashion - Nam Định</h5>

                                </div>
                                <p class="mb-1">ố 108 Quang Trung, TP Nam Định, Nam Định (Cạnh khu Cơ Động 54 Quang Trung)</p>
                                <small class="text-muted">Giờ mở cửa: 07:30 - 22:00</small>
                            </a>
                            </div>
                        </div>
                        <div class="right-content col-xl-8 col-lg-10 col-md-6 col-12 pe-0 ">
                            <div class="map h-200">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3738.41958590278!2d106.33851621536645!3d20.44795281272634!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135e5ee51dfb67b%3A0xfe11c690dc3a2941!2zNVMgRmFzaGlvbiAtIEzDqiBMxqHMo2kgVHAuIFRoYcyBaSBCacyAbmg!5e0!3m2!1svi!2s!4v1669779078350!5m2!1svi!2s"
                                        width="900" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                                        referrerpolicy="no-referrer-when-downgrade"></iframe>
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
                                <a href="https://themeselection.com" target="_blank" class="footer-link fw-bolder">Quần áo Nam 5S</a>
                            </div>
                            <div>
                                <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">Trang chủ</a>
                                <a href="https://themeselection.com/" target="_blank" class="footer-link me-4">Sản phẩm</a>

                                <a href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/" target="_blank" class="footer-link me-4">Thống kê</a>

                                <a href="https://github.com/themeselection/sneat-html-admin-template-free/issues" target="_blank" class="footer-link me-4">Hỗ trợ</a>
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

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>
