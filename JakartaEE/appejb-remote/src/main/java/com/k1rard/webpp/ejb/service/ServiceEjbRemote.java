package com.k1rard.webpp.ejb.service;

import com.k1rard.webpp.ejb.models.Producto;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface ServiceEjbRemote {

    String saludar(String nombre);

    List<Producto> listar();

    Producto crear(Producto producto);
}
