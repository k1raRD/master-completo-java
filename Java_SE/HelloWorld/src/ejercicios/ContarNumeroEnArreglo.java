package ejercicios;

public class ContarNumeroEnArreglo {
    public static void main(String[] args) {
        int[] arregloNumeros = {1, 2, 3, 3, 4, 5, 5, 5, 6, 7};
        int contadorNumero = 0, numero = 0, vecesNumero = 0;
        for (int i = 0; i < arregloNumeros.length; i++) {
            for (int j = 0; j < arregloNumeros.length; j++) {
                if(arregloNumeros[i] == arregloNumeros[j]){
                    ++contadorNumero;
                }
            }
            if (contadorNumero > vecesNumero){
                vecesNumero = contadorNumero;
                numero = arregloNumeros[i];
            }
            contadorNumero = 0;
        }

        System.out.println("La mayor ocurrencias es: " + vecesNumero);
        System.out.println("El elemento que mas se repite es: " + numero);

    }
}
