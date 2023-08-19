import java.util.Scanner;

public class OperadoresLogicosLogin {
    public static void main(String[] args) {
//        String[] usernames = new String[3];
//        String[] passwords = new String[3];
//        usernames[0] = "Alex";
//        passwords[0] = "12345";
//        usernames[1] = "Alexander";
//        passwords[1] = "123456";
//        usernames[2] = "pepe";
//        passwords[2] = "1234";

        String[] usernames = {"Alex", "Admin", "user"};
        String[] passwords = {"123", "1234", "12345"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca su usuario: ");
        String usernameUser = scanner.nextLine();
        System.out.print("Introduzca su password: ");
        String passwordUser = scanner.nextLine();

        boolean esAutenticado = false;

        for (int i = 0; i < usernames.length; i++) {
            esAutenticado = usernames[i].equals(usernameUser) && passwords[i].equals(passwordUser) ? true : esAutenticado;
        }

        String mensaje = esAutenticado ? "Fuiste exitosamente autenticado!" : "El username o el password son incorrectos.";
        System.out.println(mensaje);
    }
}
