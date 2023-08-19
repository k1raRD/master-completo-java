<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" />
  <h3>${title}</h3>
  <form action="${pageContext.request.contextPath}/login" method="post">
      <div class="row my-2">
        <label for="usuario" class="form-label">Usuario</label>
        <div>
          <input type="text" name="usuario" id="usuario" class="form-control">
        </div>
      </div>
    <div class="row my-2">
      <label for="password" class="form-label">Password:</label>
      <div>
        <input type="password" name="password" id="password" class="form-control">
      </div>
    </div>
    <div class="row my-2">
      <input type="submit" value="Login" class="btn btn-primary">
    </div class="row my-2">
      <div>
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/registrarse.jsp">Registrarse</a>
      </div>
  </form>
<jsp:include page="layout/footer.jsp" />