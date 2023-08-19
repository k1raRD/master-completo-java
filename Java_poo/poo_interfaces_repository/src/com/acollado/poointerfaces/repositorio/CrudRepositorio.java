package com.acollado.poointerfaces.repositorio;

import com.acollado.poointerfaces.modelo.Cliente;
import com.acollado.poointerfaces.repositorio.excepciones.AccesoDatoException;
import com.acollado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T t) throws AccesoDatoException;
    void editar(T t) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;
}
