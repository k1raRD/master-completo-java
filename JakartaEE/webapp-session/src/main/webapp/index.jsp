<%@page contentType="text/html" pageEncoding="UTF-8" import="com.k1rard.apiservlet.webapp.headers.models.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
    <h3>${title}</h3>
    <ul class="list-group">
        <li class="list-group-item active">Menu de opciones</li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/productos.html">Ver los productos</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/login.html">Ir al login</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/nombre.jsp">Ir al nombre sesion</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/carro/ver">Ver carro</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath}/cursos">Ir a los cursos</a></li>
    </ul>
<jsp:include page="layout/footer.jsp" />