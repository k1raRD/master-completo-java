package com.k1rard.java.jdbc;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.repository.ProductoRepositorioImpl;
import com.k1rard.java.jdbc.repository.Repositorio;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("================= Listar =================");
            repositorio.listar().forEach(System.out::println);

            System.out.println("================= Obtener por id =================");
            System.out.println(repositorio.porId(2));

            System.out.println("================= Insertar nuevo producto =================");
            Producto producto = new Producto();
            producto.setNombre("Mouse Red Dragon mecanico");
            producto.setPrecio(450);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);


    }
}
