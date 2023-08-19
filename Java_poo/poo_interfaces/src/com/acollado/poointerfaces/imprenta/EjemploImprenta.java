package com.acollado.poointerfaces.imprenta;

import com.acollado.poointerfaces.imprenta.modelo.*;
import static com.acollado.poointerfaces.imprenta.modelo.Genero.*;
import static com.acollado.poointerfaces.imprenta.modelo.Imprimible.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo("Este es solo el contenido del curriculum",
                new Persona("Alex", "Collado") , "Ingeniero en ciberseguridad")
                .addExperiencia("Estudiante en la universidad del caribe")
                .addExperiencia("Estudiante de ingles en el programa de Ingles por Inmersion")
                .addExperiencia("labore por mas de 6 years en una empresa internacional");

        Libro libro = new Libro(new Persona("Eric", "Gamma"), "Patornes de diseno: Elementos reusables POO",
                PROGRAMACION);
        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron Observador"))
                .addPagina(new Pagina("Patron pagina"))
                .addPagina(new Pagina("Composite"))
                .addPagina(new Pagina("Patron Facade"));

        Informe informe = new Informe("Estudio sobre microservicios",
                new Persona("Martin", "fowler"),
                new Persona("James", "Martinez"));

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);

        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "Hola que tal imprimiendo un objeto generico de una clase anonima";
            }
        });

        System.out.println(TEXTO_DEFECTO);
    }


}
