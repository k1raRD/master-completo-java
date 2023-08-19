package com.k1rard.cliente.ws;

import com.k1rard.webapp.jaxws.services.Curso;
import com.k1rard.webapp.jaxws.services.CursoServiceWsImplService;
import com.k1rard.webapp.jaxws.services.CursoServicioWs;
import jakarta.xml.ws.BindingProvider;

public class Main {
    public static void main(String[] args) {
        CursoServicioWs service = new CursoServiceWsImplService().getCursoServiceWsImplPort();

        ((BindingProvider)service).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)service).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Admin12345");
        Curso curso = new Curso();
        curso.setNombre("React");
        curso.setDescripcion("react js");
        curso.setDuracion(50D);
        curso.setInstructor("Alex Collado");
        Curso respuesta = service.guardar(curso);
        System.out.println("Nuevo curso: " + respuesta.getId() + " " + respuesta.getNombre());
        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}
