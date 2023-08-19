public class EjemploMatricesBuscarElemento {
    public static void main(String[] args) {

        int[][] matrizDeEnteros = {
                {35,90,3,1978},
                {15,2020,10,5},
                {677, 127, 32767, 1999}
        };

        int elementoABuscar = 15;
        boolean encontrado = false;

        primerfor:
        for (int i = 0; i < matrizDeEnteros.length; i++) {
            for (int j = 0; j < matrizDeEnteros[i].length; j++) {
                if (matrizDeEnteros[i][j] == elementoABuscar){
                    encontrado = true;
                    break primerfor;
                }
            }
        }

        if (encontrado){
            System.out.println("El elmento ha sido encontrado");
        }else {
            System.out.println("El elemento no se ha encontrado");
        };
    }
}
