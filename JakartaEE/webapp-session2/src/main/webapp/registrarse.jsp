<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" />
<h3>${title} : Crear Cuenta</h3>
<form action="${pageContext.request.contextPath}/registro" method="post">
    <div class="row my-2">
        <label for="email" class="form-label">Email</label>
        <div>
            <input type="text" name="email" id="email" class="form-control">
        </div>
    </div>
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
        <input type="submit" value="Crear Cuenta" class="btn btn-primary">
    </div>
</form>
<jsp:include page="layout/footer.jsp" />