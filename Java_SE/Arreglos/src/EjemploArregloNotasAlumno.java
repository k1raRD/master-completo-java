import java.util.Scanner;

public class EjemploArregloNotasAlumno {
    public static void main(String[] args) {

        double[] claseMatematicas, clasesHistorias, clasesLenguaje;
        double sumNotasMatematicas = 0, sumNotasHostoria = 0, sumNotasLenguaje = 0;
        claseMatematicas = new double[7];
        clasesHistorias = new double[7];
        clasesLenguaje = new double[7];

        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca las nostas de los estudiantes");
        for(int i = 0; i < clasesHistorias.length; i++){
            System.out.print("Introduzca la nota de Matematicas del estudiante " + (i + 1) +": ");
            claseMatematicas[i] = s.nextDouble();
            System.out.print("Introduzca la nota de Historia del estudiante " + (i + 1) +": ");
            clasesHistorias[i] = s.nextDouble();
            System.out.print("Introduzca la nota de Lenguajes del estudiante " + (i + 1) +": ");
            clasesLenguaje[i] = s.nextDouble();
        }

        for (int i = 0; i < claseMatematicas.length; i++) {
            sumNotasMatematicas += claseMatematicas[i];
            sumNotasHostoria += clasesHistorias[i];
            sumNotasLenguaje += clasesLenguaje[i];
        }

        double promedioClasesMatematicas = sumNotasMatematicas/claseMatematicas.length;
        double promedioClasesHistoria = sumNotasHostoria/clasesHistorias.length;
        double promedioClasesLengujes = sumNotasLenguaje/clasesLenguaje.length;
        System.out.println("Promedio clases Matematicas: " + promedioClasesMatematicas);
        System.out.println("Promedio clases Historia: " + promedioClasesHistoria);

        double promedioTotal = (promedioClasesLengujes + promedioClasesHistoria + promedioClasesMatematicas) / 3;
        System.out.println("El promedio total es: " + promedioTotal);

        for (int i = 0; i < claseMatematicas.length; i++) {
            double promedioTotalEstuadiante = (claseMatematicas[i] + clasesLenguaje[i] + clasesHistorias[i]) / 3;
            System.out.println("El promedio total del estudiante " + (i + 1) + " es: " + promedioTotalEstuadiante);
        }
    }
}
