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
    <title>Просмотр всех пользователей</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>firstname</th>
        <th>second name</th>
        <th>age</th>
        <th>login</th>
        <th>password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td>${user.age}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
