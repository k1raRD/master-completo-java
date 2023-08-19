import java.util.Scanner;

public class EjemploArreglosDetectarOrden {
    public static void main(String[] args) {
        int[] a = new int[7];
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese 7 numeros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un numero: ");
            a[i] = s.nextInt();
        }
        boolean ascendente = false;
        boolean descendente = false;
        for (int i = 0; i < a.length -1; i++) {
            if (a[i] > a[i+1]){
                descendente = true;
            } else {
                ascendente = true;
            }
        }

        if (ascendente && descendente){
            System.out.println("Arreglo = desordenado");
        }

        if (!ascendente && !descendente){
            System.out.println("Arreglo = Son todos iguales");
        }

        if (ascendente && !descendente){
            System.out.println("Arreglo = Ascendente");
        }

        if (!ascendente && descendente){
            System.out.println("Arreglo = descendente");
        }
    }
}
