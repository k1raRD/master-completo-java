<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hola Mundo Ejb</title>
</head>
<body>
    <h2>Hola Mundo Ejb</h2>
    <h3>${saludo}</h3>
    <h3>${saludo2}</h3>
    <ul>
    <c:forEach items="${listado}" var="p">
        <li>${p.nombre}</li>
    </c:forEach>
    </ul>
</body>
</html>