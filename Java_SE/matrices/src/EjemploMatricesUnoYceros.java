public class EjemploMatricesUnoYceros {
    public static void main(String[] args) {

        int[][] matriz = new int[7][7];

        System.out.println("Matriz original:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ( j == 0){
                    matriz[i][j] = 1;
                }
            }
        }

        System.out.println("Matriz creada con 1 y 0");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ( j == i){
                    matriz[i][j] = 1;
                }
            }
        }

        System.out.println("Matriz creada con 1 y 0");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ( j == 0 || i == 0 || i == matriz.length -1 || j == matriz[i].length -1){
                    matriz[i][j] = 1;
                }
            }
        }

        System.out.println("Matriz creada con 1 y 0");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
