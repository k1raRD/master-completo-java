<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
  <h3 class="my-2">${title} : Lista de curos</h3>
  
  <div>
    <form class="my-4" action="${pageContext.request.contextPath}/cursos" method="post">
      <a class="btn btn-sm btn-primary me-4" href="${pageContext.request.contextPath}/curso/operacion">Crear [+]</a>
      <label for="nombre">Ingrese el nombre:</label>
      <input class="form-control-sm" type="text" name="nombre" id="nombre">
      <input class="btn btn-primary" type="submit" value="Buscar">
    </form>
  </div>
  <div>
    <table class="table table-hover table-striped">
      <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Descripcion</th>
        <th>Instructor</th>
        <th>Duracion</th>
        <th>Editar</th>
        <th>Eliminar</th>
      </tr>
      <c:forEach items="${cursos}" var="c">
      <tr>
        <td>${c.id}</td>
        <td>${c.nombre}</td>
        <td>${c.descripcion}</td>
        <td>${c.instructor}</td>
        <td>${c.duracion}</td>
        <td><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/curso/operacion?id=${c.id}">Editar</a></td>
        <td>
            <form action="${pageContext.request.contextPath}/curso/operacion" method="post">
                <input type="hidden" name="id" value="${c.id}">
                <input type="hidden" name="eliminar" value="true">
                 <input class="btn btn-sm btn-danger" onclick="return confirm('Estas seguro que deseas eliminar este curso?')" type="submit" value="Eliminar">
            </form>
        </td>
      </tr>
      </c:forEach>
    </table>
  </div>
<jsp:include page="layout/footer.jsp" />