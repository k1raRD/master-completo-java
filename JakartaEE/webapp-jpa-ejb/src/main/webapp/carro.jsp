<%@page contentType="text/html" pageEncoding="UTF-8" import="com.k1rard.apiservlet.webapp.headers.models.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
            <h3>${title}</h3>
            <c:choose>
                <c:when test="${carro.items.isEmpty()}">
                    <div class="alert alert-warning">Lo sentimos no hay productos en el carro de compras</div>
                </c:when>
                <c:otherwise>
                    <table class="table table-hover table-striped">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                            <th>Eliminar</th>
                        </tr>
                        <c:forEach items="${carro.items}" var="i">
                            <tr>
                                <td>${i.producto.id}</td>
                                <td>${i.producto.nombre}</td>
                                <td>${i.producto.precio}</td>
                                <td>${i.cantidad}</td>
                                <td>${i.importe}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/carro/actualizar" method="post">
                                        <input type="hidden" value="${i.producto.id}" name="id">
                                        <input class="btn btn-sm btn-danger" type="submit" value="Eliminar">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="5" style="text-align: right">Total: </td>
                            <td>${sessionScope.carro.total}</td>
                        </tr>
                    </table>
                </c:otherwise>
            </c:choose>
            <div class="my-2">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/index.jsp">Ir al inicio</a>
                <a class="btn btn-success" href="${pageContext.request.contextPath}/productos.html">Seguir comprando</a>
            </div> 
<jsp:include page="layout/footer.jsp" />