package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ContarNumeroArreglo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numerosArreglo = new int[7];
        int positivos = 0, totalPositivos = 0, negativos = 0, totalNegativos = 0, ceros = 0;
        System.out.println("Digite 7 numeros para el arreglo.");
        for (int i = 0; i < numerosArreglo.length; i++) {
            System.out.print("Digite un numero: ");
            numerosArreglo[i] = entrada.nextInt();
        }
        for (int i : numerosArreglo) {
            if(i > 0){
                positivos++;
                totalPositivos += i;
            } else if (i < 0) {
                negativos++;
                totalNegativos += i;
            }else{
                ceros++;
            }
        }

        System.out.println("El promedio de los numeros positivos es: " + (double)(totalPositivos / positivos));
        System.out.println("El promedio de los numeros negativos es: " + (double)(-totalNegativos / negativos));
        System.out.println("El promedio de los ceros positivos es: " + (double)(ceros));
    }
}
