package com.k1rard.javaactualizado.principal;

import com.k1rard.javaactualizado.functional.MyFunctionalInterface;

/**
 * @author k1rard
 * Clase que explica el funcionamiento de las interfaces funcionales y expresiones lambdas
 */
public class Principal {
    public static void main(String[] args) {
        // INTERFACES FUNCIONALES SIN EXPRESIONES LAMBDAS
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
               Thread thread = new Thread();
               thread.start();
                System.out.println("Iniciando proceso...");
                try {
                    Thread.sleep(5000);
                    System.out.println("Finalizando el proceso..");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        runnable.run();

        // INTERFACES FUNCIONALES CON EXPRESIONES LAMBDAS
        Runnable runnableConLmabda = () -> {
            Thread thread = new Thread();
            thread.start();
            System.out.println("Iniciando proceso...");
            try {
                Thread.sleep(5000);
                System.out.println("Finalizando el proceso..");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        runnableConLmabda.run();

        // INTERFAZ FUNCIONAL CON LAMBDA
        MyFunctionalInterface myFunctionalInterface = (nombre) -> {
            return "Hola " + nombre;
        };

        String nombre = "Alex";
        String mostrarSaludo = myFunctionalInterface.mostrarNombre(nombre);
        System.out.println(mostrarSaludo);
    }
}
