package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        System.out.println("Introduzca el id del cliente a eliminar: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
         try{
             Cliente c = em.find(Cliente.class, id);
             em.getTransaction().begin();
             em.remove(c);
             em.getTransaction().commit();
         }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
         }finally {
             em.close();
         }
    }
}
