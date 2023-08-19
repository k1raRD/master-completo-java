package com.acollado.app.jardin;

import com.acollado.app.hogar.*;
import static com.acollado.app.hogar.Persona.*;
import static com.acollado.app.hogar.ColorPelo.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Alex");
        System.out.println(p.getNombre());
        p.setColorPelo(NEGRO);

        Perro perro = new Perro();
        perro.nombre = "tobby";
        perro.raza = "Bulldog";

        String jugando = perro.jugar(p);
        System.out.println(jugando);

//        String saludo = Persona.saludar();
        System.out.println(saludar());
        String generoMujer = GENERO_FEMNINO;
        String generoMasculino = GENERO_MASCULINO;


    }
}
