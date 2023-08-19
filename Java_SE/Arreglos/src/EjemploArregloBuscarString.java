import java.util.Scanner;

public class EjemploArregloBuscarString {
    public static void main(String[] args) {

        String[] a = new String[10];

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un nombre: ");
            a[i] = s.nextLine();
        }

        System.out.println("\nIngrese un nombre a buscar");
        String nombre = s.nextLine();
        int i = 0;
        for(i = 0; i < a.length && !a[i].toLowerCase().equals(nombre.toLowerCase()); i++){}
        if (i == a.length){
            System.out.println("nombre no encontrado.");
        }else if(a[i].toLowerCase().equals(nombre.toLowerCase())){
            System.out.println("Encontrado en la posicion " + i);
        }
    }
}
