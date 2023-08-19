package com.k1rard.cliente.jaxrs;

import com.k1rard.cliente.jaxrs.models.Curso;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget rootUri = client.target("http://localhost:8080/webapp-jaxrs-jpa/api").path("/cursos");

        System.out.println("================ por Id ================");
        Curso curso = rootUri.path("/2").request(MediaType.APPLICATION_JSON).get(Curso.class);
        System.out.println(curso);

        Response response = rootUri.path("/1").request(MediaType.APPLICATION_JSON).get();
        curso = response.readEntity(Curso.class);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());
        System.out.println(curso);

        System.out.println("================ listando ================");
        listar(rootUri);

        response = rootUri.request(MediaType.APPLICATION_JSON)
                .get(Response.class);
        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>() {});
        cursos.forEach(System.out::println);

        System.out.println("================ Creando ================");
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre("Spring Cloud");
        nuevoCurso.setDescripcion("Spring cloud eureka");
        nuevoCurso.setDuracion(25D);
        nuevoCurso.setInstructor("Andres Guzman");

        Entity<Curso> entityHeader = Entity.entity(nuevoCurso, MediaType.APPLICATION_JSON);
        curso = rootUri.request(MediaType.APPLICATION_JSON)
                .post(entityHeader, Curso.class);
        System.out.println("curso guardado: " + curso);
        listar(rootUri);

        System.out.println("================ Editando ================");
        Curso cursoEditado = curso;
        cursoEditado.setNombre("Microservicios con Spring Cloud Eureka");
        entityHeader = Entity.entity(cursoEditado, MediaType.APPLICATION_JSON);
        curso = rootUri.path("/" + curso.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader, Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("================ Eliminando ================");
        rootUri.path("/14").request().delete();
        listar(rootUri);
    }

    private static void listar(WebTarget rootUri) {
        List<Curso> cursos = rootUri.request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Curso>>() {
                });
        cursos.forEach(System.out::println);
    }
}
