<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01.10.2023
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
  <label for="email">Email:
    <input type="text" name="email" id="email" value="${param.email}" required>
  </label><br>
  <label for="password">Password:
    <input type="text" name="password" id="password" required>
  </label><br>
  <button type="submit">Login</button>
  <a href="${pageContext.request.contextPath}/register">
    <button type="button">Register</button>
  </a><br>
</form>
</body>
</html>
