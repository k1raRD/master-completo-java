import java.util.Scanner;

public class ProgramaManejoDeNombre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre1, nombre2, nombre3;
        System.out.print("Digite el primer nombre: ");
        nombre1 = scanner.nextLine();
        System.out.print("Digite el segundo nombre: ");
        nombre2 = scanner.nextLine();
        System.out.print("Digite el tercer nombre: ");
        nombre3 = scanner.nextLine();
        String nombre1Convertido = convertidorDeNombre(nombre1);
        String nombre2Convertido = convertidorDeNombre(nombre2);
        String nombre3Convertido = convertidorDeNombre(nombre3);
        String resultadoFinal = nombre1Convertido
                .concat("_" + nombre2Convertido
                        .concat("_" + nombre3Convertido));
        System.out.println("El nombre final es: " + resultadoFinal);

    }

    public static String convertidorDeNombre(String nombre){
        String nombreConvertido = nombre.substring(1,2).toUpperCase()
                .concat(".")
                .concat(nombre.substring(nombre.length() - 2));
        return nombreConvertido;
    }

}
