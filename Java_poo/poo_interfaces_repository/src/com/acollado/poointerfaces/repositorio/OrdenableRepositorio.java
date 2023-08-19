package com.acollado.poointerfaces.repositorio;

import com.acollado.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir);

//      int ordenar(T o1, T o2, String campo);


}
