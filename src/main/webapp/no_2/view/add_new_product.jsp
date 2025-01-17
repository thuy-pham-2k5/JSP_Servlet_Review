<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/17/2025
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
</head>
<body>
<main>
    <div>
        <h1>Thêm sản phẩm mới</h1>
    </div>
    <div>
        <form action="/product-type?action=add" method="post">
            <div>
                <p>
                    <span>Tên sản phẩm</span>
                    <input type="text" name="name" placeholder="Nhập tên sản phẩm...">
                </p>
                <p>
                    <span>Giá</span>
                    <input type="number" name="price" step="any" placeholder="0.00 $">
                </p>
                <p>
                    <span>Số lượng</span>
                    <input type="number" name="price" placeholder="0">
                </p>
                <p>
                    <span>Loại sản phẩm</span>
                    <select>
                        <option value="" selected hidden>--Chọn loại sản phẩm--</option>
                        <c:forEach var="type" items="${types}">
                            <option value="${type.id_type}">${type.name_type}</option>
                        </c:forEach>
                    </select>
                </p>
            </div>
            <div>
                <input type="submit" value="Thêm sản phẩm">
            </div>
        </form>

    </div>
</main>
</body>
</html>
