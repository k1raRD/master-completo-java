package com.k1rard.java.jdbc.repository;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection conn;

    public ProductoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public ProductoRepositorioImpl() {
    }

    @Override
    public List<Producto> listar() throws SQLException{
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre categoria " +
                     "FROM productos AS p " +
                     "INNER JOIN categorias AS c ON (p.categoria_id = c.id);";

        try (Statement stmt  = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);){
            while(rs.next()){
                Producto producto = crearProducto(rs);
                productos.add(producto);
            }
        }

        return productos;
    }

    @Override
    public Producto porId(Integer id) throws SQLException{
        Producto producto = null;
        String sql = "SELECT p.*, c.nombre categoria " +
                "FROM productos AS p " +
                "INNER JOIN categorias AS c ON (p.categoria_id = c.id) " +
                "WHERE p.id = ? ;";

        try(PreparedStatement stmt = conn.
                    prepareStatement(sql)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }
        }

        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException{
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ?, sku = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, sku, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setInt(3, producto.getCategoria().getId());
            stmt.setString(4, producto.getSku());
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setInt(5, producto.getId());
            } else {
                stmt.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }
            stmt.executeUpdate();

            if(producto.getId() == null){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        producto.setId(rs.getInt(1));
                    }
                }
            }

            return producto;
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException{
        try(PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id = ?;")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getInt("precio"));
        producto.setFechaRegistro(rs.getDate("fecha_registro"));
        producto.setSku(rs.getString("sku"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        producto.setCategoria(categoria);
        return producto;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
