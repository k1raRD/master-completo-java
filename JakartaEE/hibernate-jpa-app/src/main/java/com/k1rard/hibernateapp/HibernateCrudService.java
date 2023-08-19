package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.service.ClienteService;
import com.k1rard.hibernateapp.service.ClienteServiceImpl;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.jar.JarEntry;

public class HibernateCrudService {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        ClienteService service = new ClienteServiceImpl(em);

        System.out.println("========== Listar ==========");
        List<Cliente> clientes = service.listar();
        clientes.forEach(System.out::println);

        System.out.println("========== Obtener por id ==========");
        Optional<Cliente> optionalCliente = service.porId(1L);
        optionalCliente.ifPresent(System.out::println);

        System.out.println("========== Insertar nuevo cliente ==========");
        Cliente cliente = new Cliente();
        cliente.setNombre("Nene");
        cliente.setApellido("gaston");
        cliente.setFormaPago("paypal");

        service.guardar(cliente);
        System.out.println("Cliente guardado con exito!");
        service.listar().forEach(System.out::println);

        System.out.println("========== Editar cliente ==========");
        Long id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            c.setFormaPago("mercado pago");
            service.guardar(c);
            System.out.println("Cliente editado con exito!");
            service.listar().forEach(System.out::println);
        });

        System.out.println("========== Eliminar cliente ==========");
        id = cliente.getId();
        optionalCliente = service.porId(id);
        optionalCliente.ifPresent(c -> {
            service.eliminar(c.getId());
            System.out.println("Cliente eliminado con exito!");
            service.listar().forEach(System.out::println);
        });

//        if(optionalCliente.isPresent()){
//            service.eliminar(id);
//        }

        em.close();
    }
}
