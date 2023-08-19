package com.k1rard.cliente.ws;

import com.k1rard.webapp.jaxws.services.Curso;
import com.k1rard.webapp.jaxws.services.ServiceWsImplService;
import com.k1rard.webapp.jaxws.services.ServicioWs;

public class Main {
    public static void main(String[] args) {
        ServicioWs service = new ServiceWsImplService().getServiceWsImplPort();
        System.out.println("El saludo: " + service.saludar("Alex"));

        Curso curso = new Curso();
        curso.setNombre("Angular");
        Curso respuesta = service.crear(curso);
        System.out.println("Nuevo curso: " + respuesta.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}
