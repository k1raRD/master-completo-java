import java.util.Arrays;
import java.util.Collections;

public class EjemplosArreglosForOrdenamientoBurbuja {

    public static void arrayInverso(String[] productos){
        int total2 = productos.length;
        int total = productos.length;
        for (int i = 0; i < total2; i++) {
            String actual = productos[i];
            String inverso = productos[total-1-i];
            productos[i] = inverso;
            productos[total-1-i] = actual;
            total2--;
        }
    }
    public static void ordenamientoBurbuja(Object[] arreglo){
        for (int i = 0; i < arreglo.length -1; i++){
            for (int j = 0; j < arreglo.length -1- i; j++) {
                if (((Comparable) arreglo[j + 1]).compareTo(arreglo[j]) < 0) {
                    Object aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
    }
    public static void main(String[] args) {

        String[] productos = {"Kingston perndrive 64GB", "Samsung Galaxy",
                "Disco duro ssd Samsung Externo", "Asus Notebook",
                "Macbook Air", "Chromecast 4ta gen", "Bicicleta Oxford"};

        int total = productos.length;
//        Arrays.sort(productos);
//        arrayInverso(productos);
//        Collections.reverse(Arrays.asList(productos));
        ordenamientoBurbuja(productos);
        System.out.println("================Usando for=================");
        for (int i = 0; i < total; i++) {
            System.out.println("Para indice " + i + " : " + productos[i]);
        }

        Integer[] numeros2 = new Integer[4];

        numeros2[0] = 1;
        numeros2[1] = Integer.valueOf("2");
        numeros2[2] = 3;
        numeros2[3] = 4;

        ordenamientoBurbuja(numeros2);


        for (int i = 0; i < numeros2.length; i++) {
            System.out.println("i = " + i + " numeros2 = " + numeros2[i]);
        }

    }
}
