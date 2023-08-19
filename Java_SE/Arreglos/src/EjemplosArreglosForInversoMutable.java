import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class EjemplosArreglosForInversoMutable {

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
    public static void main(String[] args) {

        int[] numeros = new int[10];

        String[] productos = {"Kingston perndrive 64GB", "Samsung Galaxy",
                "Disco duro ssd Samsung Externo", "Asus Notebook",
                "Macbook Air", "Chromecast 4ta gen", "Bicicleta Oxford"};

        int total = productos.length;
        Arrays.sort(productos);
        arrayInverso(productos);
        Collections.reverse(Arrays.asList(productos));
        System.out.println("================Usando for=================");
        for (int i = 0; i < total; i++) {
            System.out.println("Para indice " + i + " : " + productos[i]);
        }
    }
}
