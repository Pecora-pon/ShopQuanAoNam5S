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
                <i>Họ tên</i> <br>
                <i>SĐT</i> <br>
                <i>Email</i> <br>
            </p>
        </div>
    </div>

    <!-- Invoice -->
    <div class="row">
        <div class="col-md-12">
            <table class="margin-top-20">
                <tr>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
<%--                <c:forEach >--%>
                    <tr>
                        <td>Tên sản phẩm</td>
                        <td>Số lượng</td>
                        <td>Tổng tiền</td>
                    </tr>
<%--                </c:forEach>--%>
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
