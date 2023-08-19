import java.util.Scanner;

public class OperadorTernario {
    public static void main(String[] args) {
        String variable = 7 == 7  ? "devueltaTrue": "devueltaFalse";
        System.out.println("variable = " + variable);

        String estado = "";
        double promedio = 0.0;

        double matematicas = 0.0;
        double ciencias = 0.0;
        double historia = 0.0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nota de matematicas: ");
        matematicas = scanner.nextDouble();
        System.out.print("Ingrese la nota de ciencias: ");
        ciencias = scanner.nextDouble();
        System.out.print("Ingrese la nota de historia: ");
        historia = scanner.nextDouble();

        promedio = (matematicas + ciencias + historia) / 3;

        System.out.println("El promedio es: " + promedio);

        estado = promedio >= 5.49 ? "Aprobado" : "Rechazado";
        System.out.println("estado = " + estado);

//        if(promedio >= 5.49){
//            estado = "APROBADO";
//        }else {
//            estado = "REPROBADO";
//        }



    }
}
