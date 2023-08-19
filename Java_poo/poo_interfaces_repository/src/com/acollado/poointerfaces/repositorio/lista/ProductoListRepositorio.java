package com.acollado.poointerfaces.repositorio.lista;

import com.acollado.poointerfaces.modelo.Cliente;
import com.acollado.poointerfaces.modelo.Producto;
import com.acollado.poointerfaces.repositorio.AbstractaListRepositorio;
import com.acollado.poointerfaces.repositorio.Direccion;
import com.acollado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((o1, o2) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(o1, o2, campo);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(o2, o1, campo);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(Producto o1, Producto o2, String campo) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = o1.getId().compareTo(o2.getId());
            case "descripcion" -> resultado = o1.getDescripcion().compareTo(o2.getDescripcion());
            case "precio" -> resultado = o1.getPrecio().compareTo(o2.getPrecio());
        }
        return resultado;
    }
}
