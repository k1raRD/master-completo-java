package com.k1rard.formatearnumeros;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Redonditos {
    public static void main(String[] args) {
        System.out.println("Bruto:\t\t" + Math.PI); // 3.141592653589793

        System.out.println("SF .4f:\t\t" + String.format("%.4f", Math.PI)); // 3.1416
        System.out.println("SF e:\t\t" + String.format("%e", Math.PI)); // 3.141593e+00
        System.out.println();

        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println("Decimal format:\t" + df.format(Math.PI)); // 3.1416

        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("DF DOWN:\t" + df.format(Math.PI));   // 3.1415
        System.out.println("DF DOWN:\t" + df.format(-Math.PI)); // -3.1415

        df.setRoundingMode(RoundingMode.FLOOR);
        System.out.println("DF FLOOR:\t" + df.format(Math.PI));   // 3.1415
        System.out.println("DF FLOOR:\t" + df.format(-Math.PI)); // -3.1416

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("DF UP:\t\t" + df.format(Math.PI));   // 3.1416
        System.out.println("DF UP:\t\t" + df.format(-Math.PI)); // -3.1416

        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println("DF CEILING:\t" + df.format(Math.PI));   // 3.1416
        System.out.println("DF CEILING:\t" + df.format(-Math.PI)); // -3.1415
        System.out.println();

        System.out.println("DF #.##:\t" + df.format(1)); // 1
        DecimalFormat dfCeros = new DecimalFormat("0.00");
        System.out.println("DF 0.00:\t" + dfCeros.format(1)); // 1.00
        System.out.println("DF 0.00:\t" + dfCeros.format(Math.PI)); // 3.14

        DecimalFormat dfMiles = new DecimalFormat("#,###.00");
        System.out.println("DF #,###.00:\t" + dfMiles.format(Math.PI * 1000)); // 3,141.59

        dfMiles.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.FRANCE));
        System.out.println("DF #,###.00 FR:\t" + dfMiles.format(Math.PI * 1000)); // 3 141,59

        dfMiles.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("es")));
        System.out.println("DF #,###.00 ES:\t" + dfMiles.format(Math.PI * 1000)); // 3.141,59
    }
}
