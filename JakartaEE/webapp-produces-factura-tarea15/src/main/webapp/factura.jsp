<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />

<h3>${title}</h3>

<ul class="list-group">
    <li class="list-group-item">Factura: ${factura.folio}</li>
    <li class="list-group-item">${factura.descripcion}</li>
    <li class="list-group-item">${factura.cliente.nombre} ${factura.cliente.apellido}</li>
</ul>

<table class="table table-hover table-striped">
    <thead>
        <tr>
            <th>Producto</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${factura.lineas}" var="linea">
            <tr>
                <td>${linea.producto.nombre}</td>
                <td>${linea.producto.precio}</td>
                <td>${linea.cantidad}</td>
                <td>${linea.calcularImporte()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jsp:include page="layout/footer.jsp" />