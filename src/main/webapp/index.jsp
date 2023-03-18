<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 22.01.2023
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<div>
    <h3>Здравствуйте! Авторизуйтесь, пожалуйста.</h3>
</div>
<table>
    <thead>
    <tr>
        <th>login</th>
        <th>password</th>
    </tr>
    </thead>
    <tbody>
    <%--    <form action="/uniq_filter" method="get">--%>
    <form action="/user/input" method="get">
        <tr>
            <td><input type="text" name="login" placeholder="put your login"></td>
            <td><input type="text" name="password" placeholder="put your password"></td>
            <td><input type="submit" value="INPUT"></td>
        </tr>
    </form>
    <tr height=40px></tr>
    <tr>
        <td><a href="pages/servicesPages/registration.jsp">Зарегистрироваться</a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
