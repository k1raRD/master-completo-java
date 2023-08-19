package com.acollado.poointerfaces;

import com.acollado.poointerfaces.modelo.Cliente;
import com.acollado.poointerfaces.modelo.Producto;
import com.acollado.poointerfaces.repositorio.Direccion;
import com.acollado.poointerfaces.repositorio.OrdenablePaginableCrudRepository;
import com.acollado.poointerfaces.repositorio.excepciones.AccesoDatoException;
import com.acollado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import com.acollado.poointerfaces.repositorio.lista.ClienteListRepositorio;
import com.acollado.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try {

            OrdenablePaginableCrudRepository<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa", 50.43));
            repo.crear(new Producto("Silla", 18));
            repo.crear(new Producto("Lampara", 15.5));
            repo.crear(new Producto("Notebook", 400.89));
            repo.crear(new Producto("Laptop", 30.9));

            System.out.println("============= Clean Data: =============");
            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);

            System.out.println("");
            System.out.println("============= paginable =============");
            List<Producto> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("");
            System.out.println("============= orden ASC =============");
            List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
            for (Producto producto : productosOrdenAsc) {
                System.out.println(producto);
            }

            System.out.println("");
            System.out.println("============= orden Desc =============");
            List<Producto> productosOrdenDesc = repo.listar("descripcion", Direccion.DESC);
            for (Producto producto : productosOrdenDesc) {
                System.out.println(producto);
            }

            System.out.println("");
            System.out.println("============= Editar =============");
            Producto mesaActualizar = new Producto("Mesa", 60.7);
            mesaActualizar.setId(1);
            repo.editar(mesaActualizar);
            Producto mesa = (Producto) repo.porId(1);
            System.out.println(mesa);
            repo.listar("descripcion", Direccion.DESC)
                    .forEach(System.out::println);

            System.out.println("");
            System.out.println("============= Eliminar =============");
            repo.eliminar(5);
            repo.listar().forEach(System.out::println);
            System.out.println("");
            System.out.println("============= Total registros =============");
            System.out.println("Total registros: " + repo.total());
        }catch (LecturaAccesoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (AccesoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
