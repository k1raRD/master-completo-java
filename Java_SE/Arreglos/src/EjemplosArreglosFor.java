import java.util.Arrays;

public class EjemplosArreglosFor {
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

        //Arrays.sort(productos);
        System.out.println("================Usando for=================");
        for (int i = 0; i < total; i++) {
            System.out.println("Para indice " + i + " : " + productos[i]);
        }
        System.out.println("===========Usando forEach============");
        for (String producto: productos){
            System.out.println("producto = " + producto);
        }
        System.out.println("================Usando while=================");
        int i = 0;
        while(i < total) {
            System.out.println("Para indice " + i + " : " + productos[i]);
            i++;
        }
        System.out.println("================Usando do While===============");
        int j = 0;
        do {
            System.out.println("Para indice " + j + " : " + productos[j]);
            j++;
        }while(j < total);

        int totalNumeros = numeros.length;

        for (int k = 0; k < totalNumeros; k++){
            numeros[k] = k*3;
        }

        for (int k = 0; k < totalNumeros; k++){
            System.out.println("numeros = " + numeros[k]);
        }
    }
}
