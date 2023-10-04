
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 30.09.2023
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="/register" method="post">
    <label for="name">Name:
        <input type="text" name="name" id="name">
    </label><br>
    <label for="name">Birthday:
        <input type="date" name="birthday" id="birthday">
    </label><br>
    <label for="name">Email:
        <input type="text" name="email" id="email">
    </label><br>
    <label for="name">Password:
        <input type="password" name="password" id="password">
    </label><br>
    <select name="role" id="role">
        <option value="USER">USER</option>
        <option value="ADMIN">ADMIN</option>
    </select><br>
    <button type="submit">Send</button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.messege}</span>
            </c:forEach>
        </div>
    </c:if>
</form>
</body>
</html>
