package com.k1rard.java.jdbc;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.repository.ProductoRepositorioImpl;
import com.k1rard.java.jdbc.repository.Repositorio;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJDBCTrx {
    public static void main(String[] args) throws SQLException {

        try ( Connection conn = ConexionBaseDatos.getConnection();) {
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                System.out.println("================= Listar =================");
                repositorio.listar().forEach(System.out::println);

                System.out.println("================= Obtener por id =================");
                System.out.println(repositorio.porId(2));

                System.out.println("================= Insertar nuevo producto =================");
                Producto producto = new Producto();
                producto.setNombre("Teclado IBM mecanico");
                producto.setPrecio(1550);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3);
                producto.setCategoria(categoria);
                producto.setSku("abcd123");
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");

                System.out.println("================= Editar nuevo producto =================");
                producto = new Producto();
                producto.setId(4);
                producto.setNombre("Teclado lenovo mecanico");
                producto.setPrecio(1000);
                categoria = new Categoria();
                categoria.setId(3);
                producto.setCategoria(categoria);
                producto.setSku("abcd2345");
                repositorio.guardar(producto);
                System.out.println("Producto actualizado con exito");
                repositorio.listar().forEach(System.out::println);
                conn.commit();
            } catch (SQLException ex){
                conn.rollback();
                ex.printStackTrace();
            }
        }


    }
}
