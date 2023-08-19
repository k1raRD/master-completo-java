package ejercicios;

import java.util.Arrays;

public class MotrarHistograma {
    public static void main(String[] args) {
        int[] arregloNumeros = {4, 3, 4, 6, 6, 4, 1, 4, 5, 4, 1, 1};
        String[] arregloHistograma = new String[6];

        for (int i = 0; i < arregloHistograma.length; i++) {
            int aux = i + 1;
            String histograma = aux + ": ";
            for (int j = 0; j < arregloNumeros.length; j++) {
                if (aux == arregloNumeros[j]) {
                    histograma += "*";
                }
            }
            arregloHistograma[i] = histograma;
        }

        for (int i = 0; i < arregloHistograma.length; i++) {
            System.out.println(arregloHistograma[i]);
        }
    }
}
