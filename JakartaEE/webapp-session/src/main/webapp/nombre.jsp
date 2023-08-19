<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nombre Sesion</title>
</head>
<body>
  <h1>Hola <%= session.getAttribute("nombre") != null ? session.getAttribute("nombre") : "anonymous" %> Sesion</h1>
  <form action="/webapp-session/nombre" method="post">
      <div>
        <label for="nombre">Usuario</label>
        <div>
          <input type="text" name="nombre" id="nombre">
        </div>
      </div>
    <div>
      <input type="submit" value="Enviar">
    </div>
  </form>
</body>
</html>