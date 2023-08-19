package com.k1rard.optional.ejemplo;

import com.k1rard.optional.ejemplo.models.Computador;
import com.k1rard.optional.ejemplo.models.Fabricante;
import com.k1rard.optional.ejemplo.models.Procesador;
import com.k1rard.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.k1rard.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        String pc = repositorio.filtrar("rog")
                        .flatMap(Computador::getProcesador)
                        .flatMap(Procesador::getFabricante)
                        .filter(fab -> "intel".equalsIgnoreCase(fab.getNombre()))
                        .map(Fabricante::getNombre)
                        .orElseThrow();
        System.out.println("pc = " + pc);
    }

}
