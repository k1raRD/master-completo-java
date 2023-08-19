package com.k1rard.java.jdbc;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.repository.CategoriaRepositorioImpl;
import com.k1rard.java.jdbc.repository.ProductoRepositorioImpl;
import com.k1rard.java.jdbc.repository.Repositorio;
import com.k1rard.java.jdbc.services.CatalogoService;
import com.k1rard.java.jdbc.services.Service;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) throws SQLException {

        Service service = new CatalogoService();
        System.out.println("================= Listar =================");
        service.listar().forEach(System.out::println);
        System.out.println("================= Insertar una nueva categoria =================");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        System.out.println("================= Insertar nuevo producto =================");
        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("edfg1238");
        service.guardarProductoConCategoria(producto, categoria);

        System.out.println("Producto guardado con exito: " + producto.getId());
        service.listar().forEach(System.out::println);

    }
}
