    package ejercicios;

    import java.util.Scanner;

    public class EjercicioOrdenarArregloPrimeroUltimo {
        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            int[] numerosUsuario = new int[10];
            System.out.println("Digite 10 numeros a continuacion");
            for (int i = 0; i < numerosUsuario.length; i++) {
                System.out.print("Digite un numero: ");
                numerosUsuario[i] = entrada.nextInt();
            }

            for (int i = 0; i < 5; i++) {
                System.out.print(numerosUsuario[((numerosUsuario.length - 1) - i)]);
                System.out.print(" - " + numerosUsuario[i] + "\n");
            }
        }
    }
