package com.k1rard.hibernateapp;

import com.k1rard.hibernateapp.entities.Alumno;
import com.k1rard.hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateFetchManytoMany {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Alumno> alumnos = em.createQuery("SELECT DISTINCT a FROM Alumno a left join fetch a.cursos", Alumno.class).getResultList();
        alumnos.forEach(System.out::println);
        em.close();
    }
}
