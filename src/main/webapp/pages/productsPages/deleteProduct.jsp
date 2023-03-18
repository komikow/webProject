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
  <title>Удаление продукта</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>Введите модель для удаления</th>
  </tr>
  </thead>
  <tbody>
  <form action="/product_delete" method="post">
    <tr>
      <td><input type="text" name="model" placeholder="put model"></td>
      <td><input type="submit" value="Удалить"></td>
    </tr>
  </form>
  </tbody>
</table>
</body>
</html>

