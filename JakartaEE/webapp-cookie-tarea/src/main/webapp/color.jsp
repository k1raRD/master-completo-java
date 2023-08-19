<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body style="color: ${cookie.color.getValue()}">
    <h1>Cambio de color con cookie</h1>
    <form action="<%= request.getContextPath() %>/colorServlet" method="post">
        <label for="color">Selecciona el color: </label>
        <select name="color" id="color">
            <option value="blue">Azul</option>
            <option value="red">Rojo</option>
            <option value="green">Verde</option>
            <option value="aqua">Aqua</option>
            <option value="voliet">Violeta</option>
            <option value="gray">Gris</option>
            <option value="cyan">Cyan</option>
        </select>
        <input type="submit" value="Cambiar color">
    </form>
</body>
</html>