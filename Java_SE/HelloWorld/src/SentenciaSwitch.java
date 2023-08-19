import java.util.Scanner;

public class SentenciaSwitch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el numero del mes: ");
        int mes = s.nextInt();
        String nombreMes = "";
        final String[] NOMBRES_MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        switch (--mes){
            case 0:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 1:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 2:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 3:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 4:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 5:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 6:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 7:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 8:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 9:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 10:
                nombreMes= NOMBRES_MESES[mes];
                break;
            case 11:
                nombreMes= NOMBRES_MESES[mes];
                break;
            default:
                nombreMes= "Es un mes desconocido";
        }

        System.out.println("El mes es " + nombreMes);

        int num = 3;
        switch (num) {
            case 0:
                System.out.println("EL num es 0");
                break;
            case 1:
                System.out.println("EL num es 1");
                break;
            case 2:
                System.out.println("EL num es 2");
                break;
            case 3:
                System.out.println("EL num es 3");
                break;
            default:
                System.out.println("EL num es 2");
        }

        String nombre = "Alex";

        switch (nombre){
            case "Alexnader":
                System.out.println("Bienvenido alexander");
                break;
            case "Maria":
                System.out.println("Bienvenida Maria");
                break;
            case "Alex":
                System.out.println("Bienvenida Alex");
                break;
            default:
                System.out.println("Nombre desconocido");
                break;
        }




    }
}
