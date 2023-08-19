package com.k1rard.java.jdbc.repository;

import java.util.List;

public interface Repositorio<T> {

    List<T> listar();
    T porId(Integer id);
    void guardar(T t);
    void eliminar(Integer id);

}
