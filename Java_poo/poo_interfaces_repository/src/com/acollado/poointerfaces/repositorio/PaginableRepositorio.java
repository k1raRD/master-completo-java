package com.acollado.poointerfaces.repositorio;

import com.acollado.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);

}
