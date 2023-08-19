package com.k1rard.classnotfound;

public class Escondite {
    public static void main(String[] args) {
        try {
            Fallida f1 = new Fallida(); // lanzará ExceptionInInitializerError
        } catch (Throwable t) {
            System.out.println("Primera llamada: " + t + " causada por " + t.getCause() + "\n");
        }
        try {
            Fallida f2 = new Fallida(); // lanzará NoClassDefFoundError
        } catch (Throwable t) {
            System.out.println("Segunda llamada: " + t + " causada por " + t.getCause() + "\n");
        }

        try {
            Class.forName("Fallida"); // lanzará ClassNotFoundException
        } catch (ClassNotFoundException e) {
            System.out.println("Class for name (Fallida sin paquete): " + e + " causada por " + e.getCause() + "\n");
        }

        try {
            Class.forName("es.dsrroma.school.java.domina1.video01_14.Fallida");
        } catch (ClassNotFoundException e) {
            System.out.println("Class for name: " + e + " causada por " + e.getCause() + "\n");
        } catch (Throwable t) {
            System.out.println("Class for name (Fallida con paquete): " + t + " causada por " + t.getCause() + "\n");
        }

        try {
            Class.forName("es.dsrroma.school.java.domina1.video01_13.Movil");
            System.out.println("Class for name (Movil con paquete) funciona");
        } catch (ClassNotFoundException e) {
            System.out.println("Class for name: " + e + " causada por " + e.getCause());
        } catch (Throwable t) {
            System.out.println("Class for name (Movil con paquete): " + t + " causada por " + t.getCause());
        }
    }
}
