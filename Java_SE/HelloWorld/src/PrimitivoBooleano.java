public class PrimitivoBooleano {
    public static void main(String[] args) {
        boolean datoLogico = true;
        System.out.println("datoLogico = " + datoLogico);
        
        double d = 98765.43e-3; // 98.76543
        System.out.println("d = " + d);
        
        float f = 12345e2f; // 123.45f 
        System.out.println("f = " + f);
        
        datoLogico = (d < f);
        System.out.println("datoLogico = " + datoLogico);
        
        boolean isEqual = 3 - 3 == 1;
        System.out.println("isEqual = " + isEqual);
    }
}
