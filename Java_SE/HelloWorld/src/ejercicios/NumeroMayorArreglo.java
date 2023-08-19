package ejercicios;

public class NumeroMayorArreglo {
    public static void main(String[] args) {
        int[] arregloNumeros = {14, 33, 15, 36, 78, 21, 43};
        int max = 0;
        for(int numero: arregloNumeros ){
            max = numero > max ? numero : max;
        }
        System.out.println("El numero mayor es: " + max);
    }

}
