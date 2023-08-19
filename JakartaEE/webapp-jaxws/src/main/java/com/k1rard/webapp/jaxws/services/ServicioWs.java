package com.k1rard.webapp.jaxws.services;

import com.k1rard.webapp.jaxws.models.Curso;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ServicioWs {
    String saludar(String persona);
    List<Curso> listar();
    Curso crear(Curso curso);
}
