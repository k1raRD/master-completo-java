package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Cliente;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernatePorId2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Introduzca el id: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);
        Cliente cliente2 = em.find(Cliente.class, 2L);
        System.out.println(cliente2);
        em.close();
    }
}