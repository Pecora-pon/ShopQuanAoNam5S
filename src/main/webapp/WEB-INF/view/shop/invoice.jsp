<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html
        lang="en"
        xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>5S-Fashion</title>
    <link rel="stylesheet" href="css/invoice.css">
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
          rel="stylesheet">
    <style>


        html {
            font-family: "Raleway", "HelveticaNeue", "Helvetica Neue", Helvetica, Arial, sans-serif;
            text-transform: none;
            font-size: 100%;
        }

        strong {
            font-weight: 600;
            color: #333;
            display: inline-block;
        }

        body {
            background: #f4f4f4;
            color: #666;
            font-weight: 300;
            line-height: 28px;
        }

        #invoice {
            background: white;
            width: auto;
            max-width: 900px;
            padding: 60px;
            margin: 0px auto 60px auto;
            border-radius: 4px;
        }

        h1,
        h2,
        h3 {
            font-weight: 300;
            color: #333;
            clear: both;
            margin: 0;
        }

        h2 {
            font-size: 36px;
            line-height: 1;
            margin: 15px 0 45px 0;
        }

        p {
            margin: 0;
            padding-bottom: 40px;
            clear: both;
        }

        #logo img {
            max-height: 44px;
        }

        #details {
            text-align: right;
        }

        table {
            width: 100%;
            margin: 0 0 30px;
            padding: 1px 0;
            border-spacing: 0;
            border-bottom: 1px solid #ddd;
        }

        th,
        td {
            padding: 15px 0;
            text-align: left;
        }

        th {
            font-weight: 700;
            border-bottom: 1px solid #ddd;
            font-size: 16px;
            color: #333;
        }

        th:last-child,
        td:last-child {
            text-align: right;
        }

        th span {
            position: relative;
            display: inline-block;
            height: 100%;
        }

        th span::after {
            content: '';
            width: 100%;
            bottom: -16px;
            position: absolute;
            right: 0;
            border-bottom: 1px solid #f91942;
        }

        #footer {
            width: 100%;
            border-top: 1px solid #ddd;
            margin: 60px 0 0 0;
            padding: 20px 0 0 0;
            list-style: none;
            font-size: 15px;
        }

        #footer li {
            display: inline-block;
            padding: 0 20px;
            border-right: 1px solid #ddd;
            line-height: 11px;
        }

        #footer li:first-child {
            padding-left: 0;
        }

        #footer li:last-child {
            border: none;
        }

        #footer li span {
            color: #f91942;
        }

        .margin-top-20 {
            margin-top: 20px;
        }

        .margin-bottom-5 {
            margin-bottom: 5px;
        }

        .print-button,
        .print-button:hover {
            line-height: 24px;
            font-size: 15px;
            font-weight: 600;
            color: #333;
            background-color: #e6e6e6;
            border-radius: 50px;
            padding: 10px 20px;
            display: block;
            text-align: center;
            margin: 40px auto 40px auto;
            max-width: 190px;
            transition: 0.3s;
            text-decoration: none !important;
            outline: none !important;
        }

        .print-button:hover {
            background-color: #e2e2e2;
        }


        /* Print Styles*/
        @media print {

            .print-button {
                display: none;
                opacity: 0;
                visibility: hidden;
                height: 0;
            }

            body {
                background: #fff;
                height: 100%;
                color: #666;
            }

            strong,
            th,
            h1,
            h2,
            h3 {
                color: #111;
            }

            table,
            th,
            #footer,
            #footer li {
                border-color: #bbb;
            }


            @page {
                size: A4;
                margin: 0 17mm;
            }

            #invoice {
                max-width: 100%;
                padding: 17mm 0;
                margin: 0;
                position: relative;
            }

            #footer {
                position: fixed;
                bottom: 17mm;
            }

            .content-block, p {
                page-break-inside: avoid;
            }

            html, body {
                width: 210mm;
                height: 297mm;
            }

            .col-md-1,
            .col-md-2,
            .col-md-3,
            .col-md-4,
            .col-md-5,
            .col-md-6,
            .col-md-7,
            .col-md-8,
            .col-md-9,
            .col-md-10,
            .col-md-11,
            .col-md-12 {
                float: left;
            }

            .col-md-12 {
                width: 100%
            }

            .col-md-11 {
                width: 91.66666667%
            }

            .col-md-10 {
                width: 83.33333333%
            }

            .col-md-9 {
                width: 75%
            }

            .col-md-8 {
                width: 66.66666667%
            }

            .col-md-7 {
                width: 58.33333333%
            }

            .col-md-6 {
                width: 50%
            }

            .col-md-5 {
                width: 41.66666667%
            }

            .col-md-4 {
                width: 33.33333333%
            }

            .col-md-3 {
                width: 25%
            }

            .col-md-2 {
                width: 16.66666667%
            }

            .col-md-1 {
                width: 8.33333333%
            }

            .col-md-pull-12 {
                right: 100%
            }

            .col-md-pull-11 {
                right: 91.66666667%
            }

            .col-md-pull-10 {
                right: 83.33333333%
            }

            .col-md-pull-9 {
                right: 75%
            }

            .col-md-pull-8 {
                right: 66.66666667%
            }

            .col-md-pull-7 {
                right: 58.33333333%
            }

            .col-md-pull-6 {
                right: 50%
            }

            .col-md-pull-5 {
                right: 41.66666667%
            }

            .col-md-pull-4 {
                right: 33.33333333%
            }

            .col-md-pull-3 {
                right: 25%
            }

            .col-md-pull-2 {
                right: 16.66666667%
            }

            .col-md-pull-1 {
                right: 8.33333333%
            }

            .col-md-pull-0 {
                right: auto
            }

            .col-md-push-12 {
                left: 100%
            }

            .col-md-push-11 {
                left: 91.66666667%
            }

            .col-md-push-10 {
                left: 83.33333333%
            }

            .col-md-push-9 {
                left: 75%
            }

            .col-md-push-8 {
                left: 66.66666667%
            }

            .col-md-push-7 {
                left: 58.33333333%
            }

            .col-md-push-6 {
                left: 50%
            }

            .col-md-push-5 {
                left: 41.66666667%
            }

            .col-md-push-4 {
                left: 33.33333333%
            }

            .col-md-push-3 {
                left: 25%
            }

            .col-md-push-2 {
                left: 16.66666667%
            }

            .col-md-push-1 {
                left: 8.33333333%
            }

            .col-md-push-0 {
                left: auto
            }

            .col-md-offset-12 {
                margin-left: 100%
            }

            .col-md-offset-11 {
                margin-left: 91.66666667%
            }

            .col-md-offset-10 {
                margin-left: 83.33333333%
            }

            .col-md-offset-9 {
                margin-left: 75%
            }

            .col-md-offset-8 {
                margin-left: 66.66666667%
            }

            .col-md-offset-7 {
                margin-left: 58.33333333%
            }

            .col-md-offset-6 {
                margin-left: 50%
            }

            .col-md-offset-5 {
                margin-left: 41.66666667%
            }

            .col-md-offset-4 {
                margin-left: 33.33333333%
            }

            .col-md-offset-3 {
                margin-left: 25%
            }

            .col-md-offset-2 {
                margin-left: 16.66666667%
            }

            .col-md-offset-1 {
                margin-left: 8.33333333%
            }

            .col-md-offset-0 {
                margin-left: 0
            }

        }

    </style>
</head>

<body>

<!-- Print Button -->
<div style="display: flex;">

    <a href="" class="print-button">Continue Shopping</a>


    <a href="" class="print-button">Back to my history</a>

    <a href="javascript:window.print()" class="print-button">Print this invoice</a>
</div>

<!-- Invoice -->
<div id="invoice">

    <!-- Header -->
    <div class="row">
        <div class="col-md-6">
            <div id="logo">
                <%--                <img src="../mainshop/mainshop2/img/logo.png" alt="">--%>
            </div>
        </div>
        <div class="col-md-6">
            <p id="details">
                <strong>Order: </strong><i></i><br>
                <strong>Issued: </strong><i></i><br>
                Due 7 days from date of issue
            </p>
        </div>
    </div>

    <!-- Client & Supplier -->
    <div class="row">
        <div class="col-md-12">
            <h2>Invoice</h2>
        </div>
        <div class="col-md-6">
            <strong class="margin-bottom-5">Supplier</strong>
            <p>
                Male-Fashion <br> 498 Lê Văn Việt - Tăng Nhơn Phú A<br>TP. Thủ Đức - TP. Hồ Chí Minh <br>
            </p>
        </div>
        <div class="col-md-6">
            <strong class="margin-bottom-5">Customer</strong>
            <p>
                <i>Họ tên: ${tt.hoTen}</i> <br>
                <i>SĐT</i> ${tt.soDienThoai}<br>
                <i>Email</i> ${tt.email} <br>
            </p>
        </div>
    </div>

    <!-- Invoice -->
    <div class="row">
        <div class="col-md-12">
            <table class="margin-top-20">
                <tr>
                    <th>STT</th>
                    <th>Ảnh</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Số Lượng</th>
                    <th>Tổng Tiền</th>
                </tr>
                <c:forEach items="${list}" var="dhct" varStatus="i">
                    <tr>
                        <td scope="row">${i.index+1}</td>
                            <%--                                    <td>${dhct.sanPham.sanPhamID}</td>--%>
                        <td><img src="/getimage/${dhct.sanPham.hinhAnhURL}" style="max-width: 35px; max-height: 35px;">
                        </td>
                        <td>${dhct.sanPham.tenSanPham}</td>
                        <td>${dhct.soLuong}</td>
                        <td>${dhct.sanPham.giaSanPham}</td>
                    </tr>
                </c:forEach>
            </table>

            <p>
                <strong class="margin-bottom-5">Address: </strong>
                <%--                <i>${y.donHangID.thongTinVanChuyenID.diaChi}</i><br>--%>
                <strong class="margin-bottom-5">Payment method: </strong>
                <%--                <i>${y.donHangID.hinhThucThanhToan}</i>--%>
            </p>
        </div>

        <div class="col-md-4 col-md-offset-8">
            <table id="totals">
                <tr>
                    <th>Total Due</th>
                    <th>Tổng tiền</th>
                </tr>
                <c:set var="dh" value="${list}" />
                    <tr>
                        <td></td>
                        <td><c:out value="${dh[0].tongTien}" /></td>
                    </tr>

            </table>
        </div>

    </div>

    <!-- Footer -->
    <div class="row">
        <div class="col-md-12">
            <ul id="footer">
                <li><span>www.example.com</span></li>
                <li>test@gmail.com</li>
                <li>01231456</li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
