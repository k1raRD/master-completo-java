package com.k1rard.appmockito.ejemplos.repositories;

import com.k1rard.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}
