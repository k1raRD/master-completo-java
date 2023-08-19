import java.util.Scanner;

public class EjemploArreglosNumeroMayor {
    public static void main(String[] args) {

        int[] a = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los numeros para llenar el arreglo:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un numero: ");
            a[i] = scanner.nextInt();
        }

        int max = 0;

        for (int i = 1; i < a.length; i++) {
             max = (a[max] > a[i]) ? max : i;
        }

        System.out.println("max = " + max);

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max){
                max = a[i];
            }
        }

        System.out.println("El numero mayor en el arreglo es: " + max);
    }
}
