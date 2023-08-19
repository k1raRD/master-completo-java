package ejercicios;

import java.util.Scanner;

public class EjercicioNotasEstudiantes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double notaUsuario,
                notasMayores5 = 0, contadorNotas5 = 0,
                contadorNotas4 = 0, notasMenores4 = 0,
                contadorNotas1 = 0,notas1 = 0,
                totalNotas = 0;
        System.out.println("Digite las 20 notas de los estudiantes (1-7): ");
        double[] notasEstudiantes = new double[20];

        for (int i = 0; i < notasEstudiantes.length; i++) {
            System.out.print("Digite la nota: ");
            notaUsuario = entrada.nextDouble();
            if (notaUsuario != 0) {
                notasEstudiantes[i] = notaUsuario;
            } else {
                System.err.println("Error. saliendo del program");
                System.exit(1);
            }
        }

        for(double nota: notasEstudiantes){
            if(nota > 5){
                notasMayores5 += nota;
                contadorNotas5++;
            } else if(nota < 4 && nota > 1) {
                notasMenores4 += nota;
                contadorNotas4++;
            }else if(nota == 1){
                notas1 += nota;
                contadorNotas1++;
            }
            totalNotas += nota;
        }

        System.out.println("El promedio de las notas superiores a 5 es: " + (notasMayores5 / contadorNotas5));
        System.out.println("El promedio de las notas menores a 4 es: " + (notasMenores4 / contadorNotas4));
        System.out.println("El promedio de las notas de 1 es: " + (notas1 / contadorNotas1));
        System.out.println("El promedio total de todos los estudiantes es: " + (totalNotas / 20));

    }
}
