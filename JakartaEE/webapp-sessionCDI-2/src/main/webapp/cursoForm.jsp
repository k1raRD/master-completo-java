<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
  <h1>${title} : Curso form</h1>
  <form action="${pageContext.request.contextPath}/curso/operacion" method="post">
    <div class="row mb-2">
      <div>
        <label for="nombre" class="col-form-label col-sm-2">Nombre:</label>
      </div>
      <div class="col-sm-4">
        <input type="text" name="nombre" id="nombre" value="${curso != null ? curso.nombre : "" }" class="form-control">
      </div>
    </div>
    <div class="row mb-2">
      <div>
        <label for="instructor" class="col-form-label col-sm-2">Instructor:</label>
      </div>
      <div class="col-sm-4">
        <input type="text" name="instructor" id="instructor" value="${curso != null ? curso.instructor : ""}" class="form-control">
      </div>
    </div>
    <div class="row mb-2">
      <div>
        <label for="duracion" class="col-form-label col-sm-2">Duracion:</label>
      </div>
      <div class="col-sm-4">
        <input type="decimal" name="duracion" id="duracion" value="${curso != null ? curso.duracion : ""}" class="form-control">
      </div>
    </div>
        <div class="row mb-2">
      <div>
        <label for="descripcion" class="col-form-label col-sm-2">Descripcion:</label>
      </div>
      <div class="col-sm-4">
        <textarea cols="3" rows="5" type="text" name="descripcion" id="descripcion" value="${curso != null ? curso.descripcion : "" }" class="form-control"></textarea>
      </div>
    </div>
    <div class="ms-1 row mb-2 col-sm-2">
      <input class="btn btn-sm btn-primary" type="submit" value="Enviar">
    </div>
    <input type="hidden" name="id" value="${ curso != null && (curso.id != null && curso.id > 0)  ? curso.id : "" }" >
  </form>
<jsp:include page="layout/footer.jsp" />