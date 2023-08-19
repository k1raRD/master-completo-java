import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemasNumericosEntradaScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca un numero: ");
        int numeroDecimal = 0;
        try {
            numeroDecimal = scanner.nextInt() ;
        } catch (InputMismatchException e){
            System.out.println("Error! Debe ingresar un numero entero");
            main(args);
            System.exit(0);
        }

        String mensajeBinario = "Numero binario de " + numeroDecimal + " = " + Integer.toBinaryString(numeroDecimal);
        String mensajeOctal = "\nNumero octal de " + numeroDecimal + " = " + Integer.toOctalString(numeroDecimal);
        String mensajeHex = "\nNumero hexadecimal de " + numeroDecimal + " = " + Integer.toHexString(numeroDecimal);

        String mensaje = mensajeBinario + mensajeOctal + mensajeHex;
        System.out.println(mensaje);
    }
}
