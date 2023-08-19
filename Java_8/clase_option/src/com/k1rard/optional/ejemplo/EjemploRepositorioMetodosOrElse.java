package com.k1rard.optional.ejemplo;

import com.k1rard.optional.ejemplo.models.Computador;
import com.k1rard.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.k1rard.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador defecto = new Computador("DELL", "Latitude 5880");
        Computador pc = repositorio.filtrar("asus2").orElse(valorDefecto());

        System.out.println("pc = " + pc);

        pc = repositorio.filtrar("macbook").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);

        System.out.println("pc = " + pc);
    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo el valor por defecto");
            return  new Computador("DELL", "Latitude 5880");
    }
}
