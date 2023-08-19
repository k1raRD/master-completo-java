import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploJavaUtilCalendar {
    public static void main(String[] args) {
        
        Calendar calendario = Calendar.getInstance();

//        calendario.set(2020, Calendar.NOVEMBER, 05, 10, 20, 10);
        calendario.set(Calendar.YEAR, 2020);
        calendario.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendario.set(Calendar.DAY_OF_MONTH, 05);

//        calendario.set(Calendar.HOUR_OF_DAY, 20);
        calendario.set(Calendar.HOUR, 7);
        calendario.set(Calendar.AM_PM, Calendar.PM);
        calendario.set(Calendar.MINUTE, 30);
        calendario.set(Calendar.SECOND, 10);
        Date fecha = calendario.getTime();
        System.out.println("fecha sin formato = " + fecha);

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MMMM-dd hh:mm:ss a");
        String fechaConFormato = formato.format(fecha);
        System.out.println("fechaConFormato = " + fechaConFormato);

    }
}
