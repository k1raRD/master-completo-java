package com.k1rard.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

         Calculadora cal = new Calculadora();
        String valor = JOptionPane.showInputDialog("Ingrese un entero: ");
        int divisor;
        double division;
        try{
            divisor = Integer.parseInt(valor);
            division = cal.dividir(10, divisor);
            System.out.println(division);

            double divsion2 = cal.dividir("100", "5");
        }catch(NumberFormatException e){
            System.out.println("Capturamos la excepcion de conversion: " + e.getMessage());
            e.printStackTrace(System.out);
            main(args);
        }catch (DivisionPorZeroException e){
            System.out.println("Capturamos la excepcion de division entre 0: " + e.getMessage());
            main(args);
        }catch (Exception e){
            System.out.println("Capturamos la excepcion mas generica, algo hubo mal con la aplicacion: " + e.getMessage());
            main(args);
        } finally {
            System.out.println("Esto siempre se va a ejecutar");
        }

        System.out.println("El programa continua despues del error");

    }
}
