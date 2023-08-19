public class PrimitivosEnteros {
    public static void main(String[] args){
        byte numeroByte = 127;
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("Tipo byte corresponde en byte a " + Byte.BYTES);
        System.out.println("Tipo byte corresponde en bits a " + Byte.SIZE);
        System.out.println("Valor maximo de un byte " + Byte.MAX_VALUE);
        System.out.println("Valor maximo de un byte " + Byte.MIN_VALUE);

        short numeroShort = 32767;
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("Tipo short corresponde en byte a " + Short.BYTES);
        System.out.println("Tipo short corresponde en bits a " + Short.SIZE);
        System.out.println("Valor maximo de un short " + Short.MAX_VALUE);
        System.out.println("Valor maximo de un short " + Short.MIN_VALUE);

        int numeroInt = 2147483647;
        System.out.println("numeroInt = " + numeroInt);
        System.out.println("Tipo int corresponde en byte a " + Integer.BYTES);
        System.out.println("Tipo int corresponde en bits a " + Integer.SIZE);
        System.out.println("Valor maximo de un int " + Integer.MAX_VALUE);
        System.out.println("Valor maximo de un int " + Integer.MIN_VALUE);

        long numeroLong = 9223372036854775807L;
        System.out.println("numeroLong = " + numeroLong);
        System.out.println("Tipo long corresponde en byte a " + Long.BYTES);
        System.out.println("Tipo long corresponde en bits a " + Long.SIZE);
        System.out.println("Valor maximo de un long " + Long.MAX_VALUE);
        System.out.println("Valor maximo de un long " + Long.MIN_VALUE);

        float numeroFloat = 9223372036854775807f;
        System.out.println("numeroFloat = " + numeroLong);
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

        var numeroVar = 1231231232131232.432;

    }
}
