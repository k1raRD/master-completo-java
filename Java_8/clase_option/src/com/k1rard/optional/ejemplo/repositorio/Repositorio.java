package com.k1rard.optional.ejemplo.repositorio;

import com.k1rard.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computador> filtrar(String nombre);
}
