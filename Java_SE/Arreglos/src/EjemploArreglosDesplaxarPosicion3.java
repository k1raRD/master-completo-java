import java.util.Scanner;

public class EjemploArreglosDesplaxarPosicion3 {
    public static void main(String[] args) {
        int[] a = new int[7];
        int numero, posicion;

        Scanner s = new Scanner(System.in);

        System.out.println("Introduzca los numeros para el arreglo");
        for (int i = 0; i < a.length -1; i++) {
            System.out.print("Introduzca un numero: ");
            a[i] = s.nextInt();
        }
        System.out.println();

        System.out.print("Ingrese el numero a insertar al arreglo: ");
        numero = s.nextInt();

        posicion = 0;
        while (posicion < 6  && numero > a[posicion]){
            posicion++;
        }
        for (int i = a.length-2; i >= posicion  ; i--) {
            a[i + 1] = a[i];
        }

        a[posicion] = numero;
        System.out.println("El nuevo arreglo ordenado quedaria de la siguiente manera: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("a = " + a[i] + " - ");
        }
    }
}
