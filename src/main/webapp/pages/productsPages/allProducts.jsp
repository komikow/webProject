<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 22.01.2023
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="cor" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>PRODUCT_ID</th>
        <th>MODEL</th>
        <th>SPECIFICATIONS</th>
        <th>GUARANTEE</th>
        <th>PRICE</th>
        <th>QUANTITY</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="products" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.product_id}</td>
            <td>${product.model}</td>
            <td>${product.specifications}</td>
            <td>${product.guarantee}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
