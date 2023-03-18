<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 29.01.2023
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Добавить товар</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>model</th>
    <th>specifications</th>
    <th>guarantee</th>
    <th>price</th>
    <th>quantity</th>
  </tr>
  </thead>
  <tbody>
  <form action="/product_create" method="post">
    <tr>
      <td><input type="text" name="model" placeholder="put model"></td>
      <td><input type="text" name="specifications" placeholder="put specifications"></td>
      <td><input type="text" name="guarantee" placeholder="put guarantee"></td>
      <td><input type="text" name="price" placeholder="put price"></td>
      <td><input type="text" name="quantity" placeholder="put quantity"></td>
      <td><input type="submit" value="ADD"></td>
    </tr>
  </form>
  </tbody>
</table>
</body>
</html>
