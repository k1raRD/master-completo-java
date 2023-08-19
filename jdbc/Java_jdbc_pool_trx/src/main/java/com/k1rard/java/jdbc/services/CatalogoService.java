package com.k1rard.java.jdbc.services;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.repository.CategoriaRepositorioImpl;
import com.k1rard.java.jdbc.repository.ProductoRepositorioImpl;
import com.k1rard.java.jdbc.repository.Repositorio;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoService implements Service{

    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;


    public CatalogoService() {
        this.productoRepositorio = new ProductoRepositorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            return productoRepositorio.listar();
        }
    }

    @Override
    public Producto porId(Integer id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            return productoRepositorio.porId(id);
        }
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            Producto nuevoProducto = null;
            try{
                nuevoProducto = productoRepositorio.guardar(producto);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace(System.err);
            }
            return nuevoProducto;
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                productoRepositorio.eliminar(id);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace(System.err);
            }
        }
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.listar();
        }
    }

    @Override
    public Categoria porIdCategoria(Integer id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.porId(id);
        }

    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try{
                nuevaCategoria = categoriaRepositorio.guardar(categoria);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace(System.err);
            }
            return nuevaCategoria;
        }
    }

    @Override
    public void eliminarCategoria(Integer id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                categoriaRepositorio.eliminar(id);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace(System.err);
            }
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            categoriaRepositorio.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                Categoria nuevaCategoria = categoriaRepositorio.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                Producto nuevoProducto = productoRepositorio.guardar(producto);
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
                e.printStackTrace(System.err);
            }
        }
    }
}
