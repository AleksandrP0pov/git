<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 02.10.2023
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<c:if test="${not empty requestScope.users}">
    <h1> Все пользователи</h1>
    <ul>
        <c:forEach var="users" items="${requestScope.users}">
            <li>${fn:toLowerCase(users)}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
