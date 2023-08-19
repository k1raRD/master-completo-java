import java.util.Arrays;

public class EjemplosArreglosForInverso {
    public static void main(String[] args) {

        int[] numeros = new int[10];

        String[] productos = new String[7];

        int total = productos.length;

        productos[0] = "Kingston perndrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco duro ssd Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta gen";
        productos[6] = "Bicicleta Oxford";

        Arrays.sort(productos);
        System.out.println("================Usando for=================");
        for (int i = 0; i < total; i++) {
            System.out.println("Para indice " + i + " : " + productos[i]);
        }

        for (int i = 0; i < total; i++) {
            System.out.println("Para i = " + i + " valor: " + productos[total - (i + 1)]);
        }

        for (int i = total; i <= 0 ; --i) {
            System.out.println("Para i = " + i + " valor: " + productos[i]);
        }
    }
}
