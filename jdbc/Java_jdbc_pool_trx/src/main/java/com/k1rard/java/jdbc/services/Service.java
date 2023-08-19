package com.k1rard.java.jdbc.services;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import java.sql.SQLException;
import java.util.List;

public interface Service {
    List<Producto> listar() throws SQLException;
    Producto porId(Integer id) throws SQLException;
    Producto guardar(Producto producto) throws SQLException;
    void eliminar(Integer id) throws SQLException;

    List<Categoria> listarCategoria() throws SQLException;
    Categoria porIdCategoria(Integer id) throws SQLException;
    Categoria guardarCategoria(Categoria producto) throws SQLException;
    void eliminarCategoria(Integer id) throws SQLException;
    void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException;
}
