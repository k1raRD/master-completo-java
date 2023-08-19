<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario login</title>
</head>
<body>
  <h1>Iniciar Sesion</h1>
  <form action="/webapp-cookies/login" method="post">
      <div>
        <label for="usuario">Usuario</label>
        <div>
          <input type="text" name="usuario" id="usuario">
        </div>
      </div>
    <div>
      <label for="usuario">Password:</label>
      <div>
        <input type="text" name="password" id="password">
      </div>
    </div>
    <div>
      <input type="submit" value="Login">
    </div>
  </form>
</body>
</html>