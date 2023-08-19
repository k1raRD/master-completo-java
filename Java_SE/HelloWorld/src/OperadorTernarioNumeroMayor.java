import java.util.Scanner;

public class OperadorTernarioNumeroMayor {
    public static void main(String[] args) {
        int max = 0, num1, num2, num3;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        num1 = scanner.nextInt();
        System.out.print("Ingrese un numero: ");
        num2 = scanner.nextInt();
        System.out.print("Ingrese un numero: ");
        num3 = scanner.nextInt();

        max = num1 > num2 ? num1 : num2;
        max = max > num3 ?  max  : num3;
        System.out.println("max = " + max);

    }
}
