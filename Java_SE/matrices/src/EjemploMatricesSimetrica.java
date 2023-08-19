public class EjemploMatricesSimetrica {
    public static void main(String[] args) {

        boolean simetrica = true;
        int[][] matriz = {
                {1,2,3,4},
                {2,1,0,5},
                {3,0,1,6},
                {4,5,6,7}
        };

        int i = 0, j;

//        con for
        salir:
         for(i = 0; i < matriz.length; i++){
            for(j = 0 ;j < i; j++){
                if (matriz[i][j] != matriz[j][i]){
                    simetrica = false;
                }
            }
        }


//    Con etiquetas:
//        salir: while ( i < matriz.length){
//            j = 0;
//            while (j < i){
//                if (matriz[i][j] != matriz[j][i]){
//                    simetrica = false;
//                    break salir;
//                }
//                j++;
//            }
//            i++;
//        }

//        con el operador &&
//        while ( i < matriz.length && simetrica){
//            j = 0;
//            while (j < i && simetrica){
//                if (matriz[i][j] != matriz[j][i]){
//                    simetrica = false;
//                }
//                j++;
//            }
//            i++;
//        }

        if (simetrica){
            System.out.println("La matriz es simetrica.");
        }else{
            System.out.println("La matriz no es simetrica.");
        }

    }
}
