import java.util.Scanner;

public class EjemploArreglosParesImpares {
    public static void main(String[] args) {
        int[] a, pares, impares;
        int totalPares = 0, totalImpares = 0;

        a = new int[10];
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca los numeros para el arreglo a.");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Introsuzca un numero:");
            a[i] = s.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0){
                totalPares++;
            }else {
                totalImpares++;
            }
        }

        pares = new int[totalPares];
        impares = new int[totalImpares];

        int contadorPares = 0;
        int contadorImpares = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0){
                pares[contadorPares++] = a[i];
            }else {
                impares[contadorImpares++] = a[i];
            }
        }

        System.out.println("Pares:");
        for (int i = 0; i < pares.length; i++) {
            System.out.println("pares = " + pares[i]);
        }

        System.out.println("\nImpares: ");
        for (int i = 0; i < impares.length; i++) {
            System.out.println("impares = " + impares[i]);
        }

    }
}
