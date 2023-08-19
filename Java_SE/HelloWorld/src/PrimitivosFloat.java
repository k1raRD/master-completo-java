public class PrimitivosFloat {
    public static void main(String[] args) {
        float numeroFloat = 0.00000000015f; //0.00000000015f
        System.out.println("numeroFloat = " + numeroFloat);
        System.out.println("Tipo float corresponde en byte a " + Float.BYTES);
        System.out.println("Tipo float corresponde en bits a " + Float.SIZE);
        System.out.println("Valor maximo de un float " + Float.MAX_VALUE);
        System.out.println("Valor maximo de un float " + Float.MIN_VALUE);

        double numeroDouble = 9223372036854775807.322;
        System.out.println("numeroDouble = " + numeroDouble);
        System.out.println("Tipo double corresponde en byte a " + Double.BYTES);
        System.out.println("Tipo double corresponde en bits a " + Double.SIZE);
        System.out.println("Valor maximo de un double " + Double.MAX_VALUE);
        System.out.println("Valor maximo de un double " + Double.MIN_VALUE);

        var varFlotante = 3.1416;
        System.out.println("varFlotante = " + varFlotante);

    }

}
