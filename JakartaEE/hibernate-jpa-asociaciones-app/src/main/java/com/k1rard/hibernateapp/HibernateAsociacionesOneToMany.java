package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.entities.Direccion;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("mercado pago");

            Direccion d1 = new Direccion("el vergel", 123);
            Direccion d2 = new Direccion("Vasco de gama", 3456);
            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            em.persist(cliente);
            em.getTransaction().commit();

            System.out.println(cliente);

            em.getTransaction().begin();
            cliente = em.find(Cliente.class, cliente.getId());
            cliente.getDirecciones().remove(d1);
            System.out.println(cliente);
            em.getTransaction().commit();

            em.getTransaction().begin();
            d1 = em.find(Direccion.class, 1L);
            cliente.getDirecciones().remove(d1);
            em.getTransaction().commit();
            System.out.println(cliente);
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }finally {
            em.close();
        }
    }
}
