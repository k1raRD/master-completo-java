package com.k1rard.apiservlet.webapp.headers.repositories;

import com.k1rard.apiservlet.webapp.headers.models.Categoria;
import com.k1rard.apiservlet.webapp.headers.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {
    private Connection conn;

    public ProductoRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre AS categoria FROM productos AS p " +
                     "INNER JOIN categorias AS c ON (p.categoria_id = c.id) ORDER BY p.id ASC")) {
            while (rs.next()) {
                Producto p = getProducto(rs);

                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre AS categoria FROM productos AS p " +
                "INNER JOIN categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = getProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?, precio=?, sku=?,categoria_id=? WHERE id=?;";
        } else {
            sql = "INSERT INTO productos (nombre, precio, sku, categoria_id, fecha_registro) VALUES (?, ?, ?, ?, ?);";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setString(3, producto.getSku());
            stmt.setLong(4, producto.getCategoria().getId());
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());
            } else {
                stmt.setDate(5, Date.valueOf(producto.getFechaRegistro()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM productos AS p WHERE p.id = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private static Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setSku(rs.getString("sku"));
        p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
        Categoria c = new Categoria();
        c.setId(rs.getLong("categoria_id"));
        c.setNombre(rs.getString("categoria"));
        p.setCategoria(c);
        return p;
    }
}
