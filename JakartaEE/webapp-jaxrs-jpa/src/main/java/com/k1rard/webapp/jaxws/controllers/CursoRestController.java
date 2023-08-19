package com.k1rard.webapp.jaxws.controllers;

import com.k1rard.webapp.jaxws.models.Curso;
import com.k1rard.webapp.jaxws.services.CursoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
public class CursoRestController {
    @Inject
    private CursoService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Curso> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id) {
        Optional<Curso> optionalCurso = service.porId(id);
        if (optionalCurso.isPresent()) {
            return Response.ok(optionalCurso.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Curso curso) {
        try {
            Curso cursoNuevo = service.guardar(curso);
            return Response.ok(cursoNuevo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id, Curso curso){
        Optional<Curso> cursoOptional = service.porId(id);
        if(cursoOptional.isPresent()){
            Curso nuevoCurso = cursoOptional.get();
            nuevoCurso.setNombre(curso.getNombre());
            nuevoCurso.setDescripcion(curso.getDescripcion());
            nuevoCurso.setInstructor(curso.getInstructor());
            nuevoCurso.setDuracion(curso.getDuracion());
            try {
                service.guardar(nuevoCurso);
                return Response.ok(nuevoCurso).build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id){
        Optional<Curso> cursoOptional = service.porId(id);
        if(cursoOptional.isPresent()){
            try{
                service.eliminar(cursoOptional.get().getId());
                return Response.noContent().build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
         return Response.status(Response.Status.NOT_FOUND).build();
    }
}
