package ejercicios;

import java.util.Scanner;

public class EjercicioNumeroMenor {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite la cantidad de numeros que desea comparar: ");
        int cantidadNumeros = entrada.nextInt();
        int[] numeros = new int[cantidadNumeros];
        System.out.print("Introduzca los numeros a comparar: \n");
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print("Digite el numero para comparar: ");
            numeros[i] = entrada.nextInt();
        }
        int numeroMenor = numeros[0];
        for(int numero: numeros){
            numeroMenor = numero < numeroMenor ? numero : numeroMenor;
        }
        System.out.println("El numero menor es: " + numeroMenor);
    }
}
