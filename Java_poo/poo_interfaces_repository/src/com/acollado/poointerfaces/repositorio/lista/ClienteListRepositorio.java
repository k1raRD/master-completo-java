package com.acollado.poointerfaces.repositorio.lista;

import com.acollado.poointerfaces.modelo.Cliente;
import com.acollado.poointerfaces.repositorio.AbstractaListRepositorio;
import com.acollado.poointerfaces.repositorio.Direccion;
import com.acollado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
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


    public static int ordenar(Cliente o1, Cliente o2, String campo) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = o1.getId().compareTo(o2.getId());
            case "nombre" -> resultado = o1.getNombre().compareTo(o2.getNombre());
            case "apellido" -> resultado = o1.getApellido().compareTo(o2.getApellido());
        }
        return resultado;
    }


}
