public class EjemploMatricesColumnasVariables {
    public static void main(String[] args) {
        int[][] matriz = new int[3][];

        matriz[0] = new int[2];
        matriz[1] = new int[3];
        matriz[2] = new int[4];

        System.out.println("Matriz lenght: " + matriz.length);
        System.out.println("Fila 0 lenght: " + matriz[0].length);
        System.out.println("Fila 1 lenght: " + matriz[1].length);
        System.out.println("Fila 2 lenght: " + matriz[2].length);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i + j * 10 + 4 * 8;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("El numero en la fila: n'" + (i + 1) + " en la columna: n'" + (j + 1) + " es: " + matriz[i][j]);
            }
        }
    }
}
