package com.k1rard.webapp.jsf3.primefaces.repositories;

import java.util.List;

public interface CrudRepository<T> {
    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id);
}
