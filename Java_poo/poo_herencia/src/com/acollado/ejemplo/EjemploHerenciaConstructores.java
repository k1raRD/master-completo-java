package com.acollado.ejemplo;

import com.acollado.poo_herencia.Alumno;
import com.acollado.poo_herencia.AlumnoInternacional;
import com.acollado.poo_herencia.Persona;
import com.acollado.poo_herencia.Profesor;

public class EjemploHerenciaConstructores {
    public static void main(String[] args) {
        System.out.println("========= Creando la instancia objeto de Alumno =========");
        Alumno alumno = new Alumno("Andres", "Guzman", 41, "Institucion nacional");
        alumno.setNotaHistoria(5.5);
        alumno.setNotaCastellano(3.3);
        alumno.setNotaMatematica(4.9);
        alumno.setEmail("alumno32@gmail.com");

        System.out.println("========= Creando la instancia objeto de AlumnoInternacional =========");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Peter", "Gosling", "Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto nacional");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);
        alumnoInt.setEmail("alumnoInt2@gmail.com");

        System.out.println("========= Creando la instancia objeto de Profesor =========");
        Profesor profesor = new Profesor("Luci", "Perez", "Matematicas");
        profesor.setEdad(37);
        profesor.setEmail("profesor2@gmail.com");


        System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Alumno internacional: " + alumnoInt.getNombre() + " " + alumnoInt.getApellido() + " " + alumnoInt.getInstitucion());

        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);

    }

    public static void imprimir(Persona persona) {
        System.out.println("Imprimiendo los datos comunes de Persona");
        System.out.println("Nombre: " + persona.getNombre() +
                " Apellido: " + persona.getApellido() +
                " Edad: " + persona.getEdad() +
                " email: " + persona.getEmail());
        if (persona instanceof Alumno) {
            System.out.println("Institucion: " + ((Alumno) persona).getInstitucion() +
                    " Notas Matematicas: " + ((Alumno) persona).getNotaMatematica() +
                    " Notas Historia: " + ((Alumno) persona).getNotaHistoria() +
                    "Notas Castellano: " + ((Alumno) persona).getNotaCastellano()

            );
            if (persona instanceof AlumnoInternacional) {
                System.out.println("Imprimiendo los datos de alumno internacional: ");
                System.out.println("Pais: " + ((AlumnoInternacional) persona).getPais() +
                        " Notas Idiomas: " + ((AlumnoInternacional) persona).getNotaIdiomas()
                );
            }
            System.out.println("======================= Sobre escritura promedio =========================");
            System.out.println("Promedio: " + ((Alumno)persona).calcularPromedio());
        }

        if (persona instanceof Profesor) {
            System.out.println("Imprimiendo los datos del profesor: ");
            System.out.println("Asignatura: " + ((Profesor) persona).getAsignatura());
        }

        System.out.println("======================= Sobre escritura saludar =========================");
        System.out.println(persona.saludar());
        System.out.println("================================================");
    }
}
