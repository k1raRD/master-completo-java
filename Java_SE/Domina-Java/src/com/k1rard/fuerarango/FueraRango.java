package com.k1rard.fuerarango;

public class FueraRango
{
    private static void arrayFueraDeRango() {
        int[] numeros = new int[]{1, 2, 3, 4};
        System.out.println("El cuarto numero es: " + numeros[4]);
    }

    private static void cadenaFueraDeRango() {
        String cadena = "hola";
        System.out.println("La cuarta letra es: " + cadena.charAt(4));
    }

    public static void main(String[] args) {
        try {
            arrayFueraDeRango();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("¡Ha fallado! " + e.getMessage());
        }

        try {
            cadenaFueraDeRango();
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("¡Tambien ha fallado! " + e.getMessage());
        }

        System.out.println("La suma es "
                + sumaHasta20(new int[]{5, 10, 1, 7, 3, 8}));
        System.out.println("La suma es "
                + sumaHasta20(new int[]{5, 1, 7, 3, 2, 0}));

        yLosVaciosQue("Susana");
        yLosVaciosQue(null);
        yLosVaciosQue("");
        yLosVaciosQue(args[0]);
    }

    private static void yLosVaciosQue(String nombre) {
        if (nombre == null || nombre.length() == 0) {
            System.err.println("Debes decirme tu nombre");
            return;
        }
        System.out.println("¡Hola " + nombre + "!");
        for (char c : nombre.toCharArray()) {
            System.out.print(c + ". ");
        }
        System.out.println("Fin del deletreo");
        System.out.println("Tu inicial es " + nombre.charAt(0));
        System.out.println("¡Adios " + nombre + "!");
    }

    private static final int MAX = 20;
    private static int sumaHasta20(int[] nums) {
        int i = 0;
        int sum = 0;
        while (sum < MAX && i < nums.length) {
            sum += nums[i];
            i++;
        }
        return sum;
    }
}
