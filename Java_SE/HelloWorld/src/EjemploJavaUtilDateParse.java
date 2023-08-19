import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EjemploJavaUtilDateParse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Ingrese una fecha con formato yyyy-MM-dd: ");
        try {
            Date fecha = format.parse(s.next());
            System.out.println("fecha = " + fecha);
            System.out.println("format = " + format.format(fecha));

            Date fecha2 = new Date();

            if(fecha.after(fecha2)){
                System.out.println("Fecha del usuario es despues que fecha2");
            } else if (fecha.before(fecha2)) {
                System.out.println("fecha es anterior que fecha2");
            }else if(fecha.equals(fecha2)){
                System.out.println("Ambas fechas son iguales.");
            }

            if(fecha.compareTo(fecha2) > 0){
                System.out.println("Fecha del usuario es despues que fecha2");
            } else if (fecha.compareTo(fecha2) < 0) {
                System.out.println("fecha es anterior que fecha2");
            } else if (fecha.compareTo(fecha2) == 0 ) {
                System.out.println("Ambas fechas son iguales.");
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(getEdadPersona("2002-11-05"));
        } catch (ParseException e) {
            e.printStackTrace(System.out);
        }

    }

    private static String getEdadPersona(String fechaNacimiento) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaUsuario = format.parse(fechaNacimiento);
        Date fechaActual = new Date();
        int edadUsuario = fechaActual.getYear() - fechaUsuario.getYear();
        return "La edad del usuario es: " + edadUsuario;
    }
}
