package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.domain.ClienteDTO;
import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.List;

public class HibernateQL {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("============= Consultar todos =============");
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("============= Consultar por un campo =============");
        Cliente cliente  = em.createQuery("SELECT c FROM Cliente c WHERE c.id =:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("============= Consultar solo el nombre por el id =============");
        String nombreCliente = em.createQuery("SELECT c.nombre FROM Cliente c WHERE id = ?1", String.class)
                .setParameter(1, 1L)
                .getSingleResult();
        System.out.println("El nombre del cliente es: " + nombreCliente);

        String apellidoCliente = em.createQuery("SELECT c.apellido FROM Cliente c WHERE id = ?1", String.class)
                .setParameter(1, 1L)
                .getSingleResult();
        System.out.println("El apellido del cliente es: " + apellidoCliente);

        System.out.println("============= Consulta por campos personalizados =============");
        Object[] objetoCliente = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c WHERE id =:id", Object[].class)
                .setParameter("id", 2L)
                .getSingleResult();
        Long id = (Long) objetoCliente[0];
        String nombre = (String) objetoCliente[1];
        String apellido = (String) objetoCliente[2];
        System.out.println("El id del cliente es: " + id);
        System.out.println("El nombre del cliente es: " + nombre);
        System.out.println("El apellido del cliente es: " + apellido);

        System.out.println("============= Consulta por campos personalizados List =============");
        List<Object[]> registros = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c", Object[].class)
                .getResultList();
//        for(Object[] reg: registros){
//            id = (Long) reg[0];
//            nombre = (String) reg[1];
//            apellido = (String) reg[2];
//            System.out.println("El id del cliente es: " + id);
//            System.out.println("El nombre del cliente es: " + nombre);
//            System.out.println("El apellido del cliente es: " + apellido);
//        }
        registros.forEach(reg -> {
                        Long idReg = (Long) reg[0];
                        String nombreReg = (String) reg[1];
                        String apellidoReg = (String) reg[2];
                        System.out.println("El id del cliente es: " + id);
                        System.out.println("El nombre del cliente es: " + nombre);
                        System.out.println("El apellido del cliente es: " + apellido);
        });

        System.out.println("============= Consulta por Cliente y forma de pago =============");
        registros = em.createQuery("SELECT c, c.formaPago FROM Cliente c", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String pago = (String) reg[1];
            System.out.println("Forma de pago = " + pago + ", Cliente = " + c);
        });

        System.out.println("============= Consulta que puebla y devuelve objeto de una clase personalizada =============");
        clientes = em.createQuery("select new Cliente(c.nombre, c.apellido) from Cliente c", Cliente.class)
                        .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("============= Consulta que puebla y devuelve objeto DTO de una clase personalizada =============");
        List<ClienteDTO> clientesDTO = em.createQuery("select new com.k1rard.hibernateapp.domain.ClienteDTO(c.nombre, c.apellido) from Cliente c", ClienteDTO.class)
                .getResultList();
        clientesDTO.forEach(System.out::println);

        System.out.println("=========== Consulta con nombres de clientes ==========");
        List<String> nombres = em.createQuery("SELECT c.nombre FROM Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== Consulta con nombres unicos de cliente ==========");
        nombres = em.createQuery("SELECT distinct(c.nombre) FROM Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== Consulta con formas de pago unicos de cliente ==========");
        List<String> formasPago = em.createQuery("SELECT distinct(c.formaPago) FROM Cliente c", String.class).getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("=========== Consulta con numero de formas de pago unicos de cliente ==========");
        Long totalFormaPago = em.createQuery("SELECT count(distinct(c.formaPago)) FROM Cliente c", Long.class).getSingleResult();
        System.out.println("El total de forma de pagos es: " + totalFormaPago);

        System.out.println("=========== Consulta con nombre y apellidos concatenados ==========");
//        nombres = em.createQuery("SELECT concat(c.nombre, ' ', c.apellido) as nombreCompleto FROM Cliente c", String.class)
//                        .getResultList();

        nombres = em.createQuery("SELECT c.nombre || ' ' || c.apellido as nombreCompleto FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== Consulta con nombre y apellidos concatenados en mayuscula ==========");
        nombres = em.createQuery("SELECT upper(concat(c.nombre, ' ', c.apellido)) as nombreCompleto FROM Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== Consulta con nombre y apellidos concatenados en minusculas ==========");
        nombres = em.createQuery("SELECT lower(concat(c.nombre, ' ', c.apellido)) as nombreCompleto FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== Consulta para buscar por nombre ==========");
        String param = "%and%";
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre like :parametro", Cliente.class)
                .setParameter("parametro", param)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== Consultar por rangos ============");
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.id between 2 and 7", Cliente.class)
                        .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== Consultar por rangos ============");
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre between 'A' and 'B'", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== Consulta para Ordenar registros ============");
        clientes = em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre ASC", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        clientes = em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre DESC", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        clientes = em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre ASC, c.apellido ASC", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== Consulta con total de registros de la tabla ============");
        Long total = em.createQuery("SELECT count(c) as total FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println("El total de registro es: " + total);

        System.out.println("=========== Consulta con valor minimo del id ===========");
        Long minId = em.createQuery("SELECT min(c.id) as minimo FROM Cliente c", Long.class).getSingleResult();
        System.out.println("El minimo de id es: " + minId);

        System.out.println("=========== Consulta con valor maximo del id ===========");
        Long maxId = em.createQuery("SELECT max(c.id) as maximo FROM Cliente c", Long.class).getSingleResult();
        System.out.println("El maximo de id es: " + maxId);

        System.out.println("=========== Consulta con nombre y su largo ===========");
        registros = em.createQuery("SELECT c.nombre, length(c.nombre) FROM Cliente c", Object[].class).getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("Nombre = " + nom + ", largo = " + largo);
        });

        System.out.println("=========== Consulta con el nombre mas corto ===========");
        Integer minLargoNombre = em.createQuery("SELECT min(length(c.nombre)) FROM Cliente c", Integer.class).getSingleResult();
        System.out.println("El nombre mas corto es de un largo de: " + minLargoNombre);

        System.out.println("=========== Consulta con el nombre mas largo ===========");
        Integer maxLargoNombre = em.createQuery("SELECT max(length(c.nombre)) FROM Cliente c", Integer.class).getSingleResult();
        System.out.println("El nombre mas largo es de un largo de: " + maxLargoNombre);

        System.out.println("============ consultas resumen funciones agregaciones count min max avg sum ============");
        Object[] estadisticas = em.createQuery("SELECT min(c.id), max(c.id), sum(c.id), count(c.id), avg(length(c.nombre)) FROM Cliente c", Object[].class).getSingleResult();
        Long min = (Long) estadisticas[0];
        Long max = (Long) estadisticas[1];
        Long sum = (Long) estadisticas[2];
        Long count = (Long) estadisticas[3];
        Double avg = (Double) estadisticas[4];
        System.out.println("min = " + min + ", max = " + max + ", sum = " + sum + ", total = " + count + ", avg = " + avg);

        System.out.println("=========== Consulta con nombre mas corto y su largo ==========");
        registros = em.createQuery("SELECT c.nombre, length(c.nombre) FROM Cliente c " +
                        "WHERE length(c.nombre) = (SELECT max(length(c.nombre)) FROM Cliente c)", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("Nombre = " + nom + ", largo = " + largo);
        });

        System.out.println("============ Consulta para obtener el ultimo registro ===========");
        Cliente ultimoCliente = em.createQuery("SELECT c FROM Cliente c WHERE c.id = (SELECT max(c.id) FROM Cliente c)", Cliente.class).getSingleResult();
        System.out.println(ultimoCliente);

        System.out.println("========== Consulta where in ==========");
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.id in :ids", Cliente.class)
                .setParameter("ids", Arrays.asList(1L, 3L, 10L, 40L))
                .getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
