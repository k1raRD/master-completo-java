package com.acollado.app.jardin;

import com.acollado.app.hogar.Persona;

 public class Perro {
     protected String nombre;
     protected String raza;

     String jugar(Persona persona){
          return persona.lanzarPelota();
     }
}
