<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 28.02.2023
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение пароля пользователя</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Введите логин пользователя</th>
    </tr>
    </thead>
    <tbody>
    <form action="/select_user_update" method="post">
        <tr>
            <td><input type="text" name="loginToUpdate" placeholder="put login"></td>
            <td><input type="text" name="newPassword" placeholder="put new password"></td>
            <td><input type="submit" value="Select"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>

