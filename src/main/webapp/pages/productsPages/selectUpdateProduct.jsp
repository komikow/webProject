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
    <title>Установить новую цену</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Введите модель для обновления</th>
    </tr>
    </thead>
    <tbody>
    <form action="/select_product_update" method="post">
        <tr>
            <td><input type="text" name="modelToUpdate" placeholder="put model"></td>
            <td><input type="text" name="newPrice" placeholder="put new price"></td>
            <td><input type="submit" value="Обновить"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>

