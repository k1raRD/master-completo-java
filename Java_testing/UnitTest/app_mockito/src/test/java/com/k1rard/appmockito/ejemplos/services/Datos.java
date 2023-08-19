package com.k1rard.appmockito.ejemplos.services;

import com.k1rard.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static List<Examen> EXAMENES = Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L, "Lenguaje"),
            new Examen(7L, "Historia"));

    public final static List<String> PREGUNTAS = Arrays.asList("aritmetica", "Integrakes",
            "derivadas", "trigonometria", "geometria");

    public final static Examen EXAMEN = new Examen(null, "Fisica");
}
