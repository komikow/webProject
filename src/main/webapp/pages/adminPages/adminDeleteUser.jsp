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
    <title>Delete user</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Введите логин для удаления пользователя</th>
    </tr>
    </thead>
    <tbody>
    <form action="/user_delete" method="post">
        <tr>
            <td><input type="text" name="loginToDelete" placeholder="put your firstname"></td>
            <td><input type="submit" value="Удалить"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>

