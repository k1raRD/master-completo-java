import java.util.Scanner;

public class ImprimirNombre {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite su nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Mi nombre es: " + nombre);
    }
}
