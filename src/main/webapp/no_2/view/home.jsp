<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/17/2025
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
</head>
<body>
<main>
    <div>
        <h1>Danh sách sản phẩm</h1>
    </div>
    <div>
        <div>
            <form method="post">
                <input type="search" name="keyword" placeholder="Tìm kiếm sản phẩm theo tên...." required>
                <input type="submit" value="Tìm kiếm">
            </form>
        </div>
        <div>
            <a href="/product-type?action=add">
                <button>Thêm sản phẩm</button>
            </a>
        </div>
    </div>
    <div>
        <table>
            <tr>
                <th>#</th>
                <th>Tên sản phẩm</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Loại sản phẩm</th>
                <th>Hành động</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id_product}</td>
                    <td>${product.name}</td>
                    <td id="price">${product.price} $</td>
                    <td>${product.quantity}</td>
                    <td>${product.name_type}</td>
                    <td>
                        <a href="/product-type?action=view">
                            <button>Xem</button>
                        </a>
                        <a href="/product-type?action=edit">
                            <button>Sửa</button>
                        </a>
                        <a href="/product-type?action=delete">
                            <button>Xóa</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>
