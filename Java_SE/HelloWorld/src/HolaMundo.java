import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        String saludar = "Hola Mundo desde Java";
        System.out.println(saludar);
        System.out.println("saludar.toUpperCase() = " + saludar.toUpperCase());

        Integer numero = 11;
        System.out.println("numero = " + numero);

        boolean valor = true;
        int numero2 = 10;
        if(valor){
            System.out.println("numero = " + numero);
            numero2 = 12;
        }
        System.out.println("numero = " + numero2);

        var numero3 = "klok";

        String nombre;

        nombre = "Andres";
        
        if(numero > 10){
            nombre = "Juan";
        }

        System.out.println("nombre = " + nombre);

        // int edadPersona = 32;
    }
}
