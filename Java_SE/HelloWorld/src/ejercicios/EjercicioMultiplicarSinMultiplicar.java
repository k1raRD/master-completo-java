package ejercicios;

import java.util.Scanner;

public class EjercicioMultiplicarSinMultiplicar {
    public static void main(String[] args) {
        int num1, num2, resultado = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite el numero 1 a multiplicar: ");
        num1 = entrada.nextInt();
        System.out.print("Digite el numero 2 a multiplicar: ");
        num2 = entrada.nextInt();
        if(!(num1 < 0) || !(num2 < 0)){
            for (int i = 0; i < num1; i++) {
                resultado += num2;
            }
        }else{
            for (int i = 0; i > num1; i--) {
                resultado += num2;
            }
            resultado = -resultado;
        }

        System.out.println("El resultado de la multiplicacion es: " + resultado);

    }
}
