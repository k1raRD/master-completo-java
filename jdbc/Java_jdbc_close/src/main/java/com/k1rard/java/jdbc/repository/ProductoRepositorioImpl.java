package com.k1rard.java.jdbc.repository;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre categoria " +
                     "FROM productos AS p " +
                     "INNER JOIN categorias AS c ON (p.categoria_id = c.id);";

        try (Connection conn = getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);){
            while(rs.next()){
                Producto producto = crearProducto(rs);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return productos;
    }

    @Override
    public Producto porId(Integer id) {
        Producto producto = null;
        String sql = "SELECT p.*, c.nombre categoria " +
                "FROM productos AS p " +
                "INNER JOIN categorias AS c ON (p.categoria_id = c.id) " +
                "WHERE p.id = ? ;";

        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.
                    prepareStatement(sql)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES (?, ?, ?, ?)";
        }

        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setInt(3, producto.getCategoria().getId());
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setInt(4, producto.getId());
            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id = ?;")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getInt("precio"));
        producto.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        producto.setCategoria(categoria);
        return producto;
    }
}
