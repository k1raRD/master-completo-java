package com.k1rard.java.jdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
    List<T> listar() throws SQLException;
    T porId(Integer id) throws SQLException;
    T guardar(T t) throws SQLException;
    void eliminar(Integer id) throws SQLException;
    void setConn(Connection conn);
}
