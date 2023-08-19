public class ConversionDeTipos {
    public static void main(String[] args) {
        //:::::::::::::::::::: Convertir datos de tipo String a tipos Primitivos ::::::::::::::::::::
        String numeroStr = "50";
        int numeroInt = Integer.parseInt(numeroStr);
        System.out.println("numeroInt = " + numeroInt);

        String realStr = "9876.32e-3";
        double realDouble = Double.parseDouble(realStr);
        System.out.println("realDouble = " + realDouble);
        
        String logicoStr = "true";
        boolean logicoBoolean = Boolean.parseBoolean(logicoStr);
        System.out.println("logicoBoolean = " + logicoBoolean);

        //:::::::::::::::::::: Convertir datos de tipos Primitivos a tipo String ::::::::::::::::::::
        
        int otroNumeroInt = 100;
        System.out.println("otroNumeroInt = " + otroNumeroInt);

        String otroNumeroStr = Integer.toString(otroNumeroInt);
//        String otroNumeroStr = String.valueOf(otroNumeroInt);
        System.out.println("otroNumeroStr = " + otroNumeroStr);
        
        double otroNumeroDouble = 12321321.32-3;
        System.out.println("otroNumeroDouble = " + otroNumeroDouble);
        
        String otroNumeroRealStr = String.valueOf(otroNumeroDouble);
        otroNumeroStr = Double.toString(otroNumeroDouble);
        System.out.println("otroNumeroRealStr = " + otroNumeroRealStr);

        //:::::::::::::::::::: Convertir datos de tipos Primitivos a otro tipo Primitivo ::::::::::::::::::::
        int i = 22768;
        
        short s = (short) i;
        System.out.println("s = " + s);
        System.out.println("short max value = " + Short.MAX_VALUE);

        long l = i;
        System.out.println("l = " + l);

        char b = (char) i;
        System.out.println("b = " + b);

        float f = (float) i;
        System.out.println("f = " + f);
    }
}
