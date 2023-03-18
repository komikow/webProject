<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 29.01.2023
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Страница администратора</title>
</head>
<body>
<a href="/user_read">Просмотреть всех пользователей</a>
<a href="/pages/adminPages/adminDeleteUser.jsp">Удалить пользователя</a>
<a href="/product_read">Просмотреть все товары</a>
<a href="/pages/productsPages/addProducts.jsp">Добавить товар в базу данных</a>
<a href="/pages/productsPages/deleteProduct.jsp">Удалить товар из базы данных</a>
<a href="/pages/productsPages/selectUpdateProduct.jsp">Обновить товар в базе данных</a>
<a href="/pages/usersPages/selectUserToUpdatePassword.jsp">Обновить пользователя в базе данных</a>
<div><a href="../../../index.jsp">На страницу авторизации</a></div>
</body>
</html>
