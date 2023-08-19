package ejercicios;

import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite el radio del circulo: ");
        double radioCirculo = entrada.nextDouble();
        System.out.println("El area del circulo es: " + (Math.PI * Math.pow(radioCirculo, 2)));
    }
}
