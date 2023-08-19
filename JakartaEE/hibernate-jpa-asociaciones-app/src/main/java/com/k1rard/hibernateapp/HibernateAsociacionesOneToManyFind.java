package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.entities.Direccion;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToManyFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 1L);

            Direccion d1 = new Direccion("el vergel", 123);
            Direccion d2 = new Direccion("Vasco de gama", 3456);
            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            em.merge(cliente);
            System.out.println(cliente);
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
