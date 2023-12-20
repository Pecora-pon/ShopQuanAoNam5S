<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.security.Principal" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Collections" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html
        lang="en"
        data-assets-path="../mainshop/mainshop2/"
>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quần áo nam 5S | Liên hệ</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
        rel="stylesheet">
    <!-- Include SweetAlert2 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">

    <!-- Include SweetAlert2 JS -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

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

    <!-- Map Begin -->
    <div class="map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.2073682405874!2d105.8544445155939!3d21.028511993209035!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abb3b3b86c8d%3A0x13b84a64257c7bd1!2zVHLGsOG7nW5nIMSQ4bqhaSBIw7luZyBUcsOsbmggVMOybmcgVGjDtGgsIFZp4buHdCBOYW0!5e0!3m2!1sen!2sbd!4v1597926938024!5m2!1sen!2sbd" height="500" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
    </div>
    <!-- Map End -->

    <!-- Contact Section Begin -->
    <section class="contact spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="contact__text">
                        <div class="section-title">
                            <span>Thông tin</span>
                            <h2>Liên hệ</h2>
                            <p></p>
                        </div>
                        <ul>
                            <li>
                                <h4>Việt Nam</h4>
                                <p>498-Lê Văn Việt - TP Hồ Chí Minh <br />+03 259-322-0587</p>
                            </li>
                            <li>
                                <h4>Việt Nam</h4>
                                <p>25-Trần Nguyên Hãn - Hà Nội <br />+03 59-598-2568</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="contact__form">
                        <form action="/shop/lien-he" method="post">
                            <div class="row">
                                <div class="col-lg-6">
                                    <input type="text" placeholder="Name" name="name">
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" placeholder="Email"name="email">
                                </div>
                                <div class="col-lg-12">
                                    <textarea placeholder="Message" name="content"></textarea>
                                    <button type="submit" class="site-btn">Send Message</button>
                                </div>
                                <div class="col-lg-12">
                                    <% String successMessage = (String) request.getAttribute("successMessage"); %>
                                    <% if (successMessage != null) { %>
                                        <script>
                                            // Display SweetAlert2 success popup
                                            Swal.fire({
                                                icon: 'success',
                                                title: 'Send success',
                                                text: '<%= successMessage %>',
                                                confirmButtonText: 'OK'
                                            });
                                        </script>
                                    <% } %>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact Section End -->

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

        <!-- ... Other head elements ... -->

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var form = document.querySelector('.contact__form form');

                form.addEventListener('submit', function (event) {
                    if (!validateForm()) {
                        event.preventDefault();
                    }
                });

                function validateForm() {
                    var name = form.querySelector('[name="name"]').value.trim();
                    var email = form.querySelector('[name="email"]').value.trim();
                    var content = form.querySelector('[name="content"]').value.trim();

                    if (name === ''||email === '' || !validateEmail(email)||content === '') {
                        Swal.fire({
                            icon: 'error',
                            title: 'Gửi không thành công',
                            text: 'Vui lòng nhập đầy đủ dữ liệu và đúng định dạng',
                            confirmButtonText: 'OK'
                        });
                        return false;
                    }



                    return true;
                }

                function validateEmail(email) {
                    // Add your email validation logic here
                    // Example: Use a regular expression for basic email validation
                    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                    return emailRegex.test(email);
                }
            });

        </script>

    <!-- Thêm đoạn mã JavaScript để ẩn thông báo sau 5 giây -->




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