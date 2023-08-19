import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int elemento, posicion, ultimo;
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < numeros.length -1; i++) {
            System.out.print("Ingrese el numero: ");
            numeros[i] = s.nextInt();
        }

        System.out.println("Ingrese el nuevo elemento: ");
        elemento = s.nextInt();
        System.out.println("Ingrese la posicion a introducir el elemnto: ");
        posicion = s.nextInt();

        ultimo = numeros[args.length -1];
        for (int i = numeros.length -2; i >= posicion; i--) {
            numeros[i+1] = numeros[i];
        }
        int [] numeros2 = new int[args.length + 1];
        System.arraycopy(numeros,0,numeros2,0,numeros.length);
        numeros = numeros2;
        numeros[posicion] = elemento;
        numeros[numeros.length - 1] = ultimo;

        System.out.println("Arreglo final: ");
        for (int numero:numeros) {
            System.out.print("numero = " + numero + " - ");
        }
    }
}
