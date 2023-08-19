public class WrapperInteger {
    public static void main(String[] args) {
        int intPrimitivo = 135;
        Integer intObjeto = Integer.valueOf(intPrimitivo);
        Integer intObjeto2 = intObjeto;
        System.out.println("intObjeto = " + intObjeto);

        int num = intObjeto;
        int num2 = intObjeto2.intValue();
        System.out.println("num = " + num);
        System.out.println("num2 = " + num2);

        String valorTvLcd = "67000";
        Integer valor = Integer.valueOf(valorTvLcd);
        System.out.println("valor = " + valor);
        
        Short shortObjeto = intObjeto.shortValue();
        System.out.println("shortObjeto = " + shortObjeto);
        
        Byte byteObjeto = intObjeto.byteValue();
        System.out.println("byteObjeto = " + byteObjeto);

        Long longObjeto = intObjeto.longValue();
        System.out.println("longObjeto = " + longObjeto);
    }
}
