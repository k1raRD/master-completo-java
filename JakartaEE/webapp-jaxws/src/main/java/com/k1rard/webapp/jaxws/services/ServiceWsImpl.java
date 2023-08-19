package com.k1rard.webapp.jaxws.services;

import com.k1rard.webapp.jaxws.models.Curso;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "com.k1rard.webapp.jaxws.services.ServicioWs")
public class ServiceWsImpl implements ServicioWs{
    private int contador;
    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("Imprimiendo dentro del servicio web con instancia: "  + this);
        contador++;
        System.out.println("Valor del contador en el metodo contador: " + contador);
        return "Hola que tal " + persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("Java"), new Curso("Spring"), new Curso("Jakarta EE"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con exito... " + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
