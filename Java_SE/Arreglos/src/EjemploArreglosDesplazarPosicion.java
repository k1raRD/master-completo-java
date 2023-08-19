import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int ultimo;
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese el numero: ");
            numeros[i] = s.nextInt();
        }

        ultimo = numeros[numeros.length -1];


        for (int i = numeros.length -2; i >= 0; i--) {
            numeros[i+1] = numeros[i];
        }
        numeros[0] = ultimo;
        System.out.println("Arreglo final: ");
        for (int numero:numeros) {
            System.out.print("numero = " + numero + " - ");
        }
    }
}
