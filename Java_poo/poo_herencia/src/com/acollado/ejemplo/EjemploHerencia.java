package com.acollado.ejemplo;

import com.acollado.poo_herencia.Alumno;
import com.acollado.poo_herencia.AlumnoInternacional;
import com.acollado.poo_herencia.Profesor;

public class EjemploHerencia {
    public static void main(String[] args) {
        System.out.println("========= Creando la instancia objeto de Alumno =========");
        Alumno alumno = new Alumno();
        alumno.setNombre("Andres");
        alumno.setApellido("Guzman");
        alumno.setInstitucion("Institucion nacional");
        alumno.setNotaHistoria(5.5);
        alumno.setNotaCastellano(3.3);
        alumno.setNotaMatematica(4.9);

        System.out.println("========= Creando la instancia objeto de AlumnoInternacional =========");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();
        alumnoInt.setNombre("Peter");
        alumnoInt.setApellido("Gosling");
        alumnoInt.setPais("Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto nacional");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);

        System.out.println("========= Creando la instancia objeto de Profesor =========");
        Profesor profesor = new Profesor();
        profesor.setNombre("Luci");
        profesor.setApellido("Perez");
        profesor.setAsignatura("Matematicas");

        System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Alumno internacional: " + alumnoInt.getNombre() + " " + alumnoInt.getApellido() + " " + alumnoInt.getInstitucion());
        System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido() + " " + profesor.getAsignatura());
        Class clase = alumnoInt.getClass();
        while (clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            clase = clase.getSuperclass();
        }
    }
}
