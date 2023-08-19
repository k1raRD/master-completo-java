package com.acollado.ejemplo;

import com.acollado.poo_herencia.Alumno;
import com.acollado.poo_herencia.AlumnoInternacional;
import com.acollado.poo_herencia.Persona;
import com.acollado.poo_herencia.Profesor;

public class EjemploHerenciaSobreEscrituraToString {
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

        System.out.println("================= Datos alumno ===============");
        imprimir(alumno);
        System.out.println("================= Datos alumno internacional ===============");
        imprimir(alumnoInt);
        System.out.println("================= Datos profesor ===============");
        imprimir(profesor);

    }

    public static void imprimir(Persona persona) {
        System.out.println(persona);
    }

}
