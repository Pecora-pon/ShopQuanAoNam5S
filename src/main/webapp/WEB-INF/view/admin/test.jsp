<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>Chức vụ ID</th>
        <th>Tên chức vụ</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listChucVu}" var="chucvu">
        <tr>
            <td>${chucvu.chucVuID}</td>
            <td>${chucvu.tenChucVu}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>