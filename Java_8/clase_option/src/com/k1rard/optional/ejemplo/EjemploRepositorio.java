package com.k1rard.optional.ejemplo;

import com.k1rard.optional.ejemplo.models.Computador;
import com.k1rard.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.k1rard.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("asus").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se encontro"));

//        Optional<Computador> pc = repositorio.filtrar("Asus Rog");

//        if(pc.isPresent()){
//            System.out.println(pc.get());
//        }else{
//            System.out.println("No se ncontro");
//        }


    }
}
