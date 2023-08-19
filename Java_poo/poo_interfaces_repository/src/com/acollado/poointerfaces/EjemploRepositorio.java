package com.acollado.poointerfaces;

import com.acollado.poointerfaces.modelo.Cliente;
import com.acollado.poointerfaces.repositorio.*;
import com.acollado.poointerfaces.repositorio.excepciones.AccesoDatoException;
import com.acollado.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import com.acollado.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import com.acollado.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import com.acollado.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {

            OrdenablePaginableCrudRepository<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Alex", "perez"));
            repo.crear(new Cliente("Maria", "gonzales"));
            repo.crear(new Cliente("Ayleen", "martinez"));
            repo.crear(new Cliente("luisa", "rodriguez"));
            Cliente andres = new Cliente("Andrez", "guzman");
            repo.crear(andres);
            repo.crear(andres);

            //repo.crear(null);
            System.out.println("============= Clean Data: =============");
            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);

            System.out.println("");
            System.out.println("============= paginable =============");
            List<Cliente> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("");
            System.out.println("============= orden ASC =============");
            List<Cliente> clientesOrdenAsc = repo.listar("nombre", Direccion.ASC);
            for (Cliente cliente : clientesOrdenAsc) {
                System.out.println(cliente);
            }

            System.out.println("");
            System.out.println("============= orden Desc =============");
            List<Cliente> clientesOrdenDesc = repo.listar("nombre", Direccion.DESC);
            for (Cliente cliente : clientesOrdenDesc) {
                System.out.println(cliente);
            }

            System.out.println("");
            System.out.println("============= Editar =============");
            Cliente alexActualizar = new Cliente("Alex", "Collado");
            alexActualizar.setId(1);
            repo.editar(alexActualizar);
            Cliente alex = (Cliente) repo.porId(1);
            System.out.println(alex);
            repo.listar("nombre", Direccion.DESC)
                    .forEach(System.out::println);

            System.out.println("");
            System.out.println("============= Eliminar =============");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);
            System.out.println("");
            System.out.println("============= Total registros =============");
            System.out.println("Total registros: " + repo.total());
        }catch (RegistroDuplicadoAccesoDatoException e){
            System.out.println("Dpublicado: " + e.getMessage());
            e.printStackTrace();
        } catch (LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        }catch (EscrituraAccesoDatoException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e){
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
