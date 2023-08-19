public class EjemploArreglosOrdenPrincipioFinal {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int[] a = new int[10];

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = i + 1;
        }

        int aux = 0;
        for (int i = 0; i < numeros.length/2; i++) {
            System.out.print("numeros = " + numeros[i] + " ");
            a[aux++] = numeros[i];
            System.out.println("numeros = " + numeros[numeros.length - 1 - i]);
            a[aux++] = numeros[numeros.length -1 -i];
        }

        for (int aa: a) {
            System.out.println("aa = " + aa);
        }
    }
}
