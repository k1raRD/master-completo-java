public class WrapperBoolean {
    public static void main(String[] args) {

        Integer num1 = 1, num2 = 2;

        boolean primBoolean = num1 > num2;
        Boolean objetoBoolean = Boolean.valueOf(primBoolean);
        Boolean objetoBoolean2 = Boolean.valueOf("false");
        System.out.println("primBoolean = " + primBoolean);
        System.out.println("objetoBoolean = " + objetoBoolean);
        System.out.println("objetoBoolean2 = " + objetoBoolean2);
        Boolean objBoolean3 = false;

        System.out.println("Comparando 2 objetos booleanos: " + (objetoBoolean == objetoBoolean2));
        System.out.println("Comparando 2 objetos booleanos: " + (objetoBoolean.equals(objetoBoolean2)));
        System.out.println("Comparando 2 objetos booleanos: " + (objetoBoolean.equals(objBoolean3)));
        
        boolean primitivoBoolean2 = objetoBoolean2;
        System.out.println("primitivoBoolean2 = " + primitivoBoolean2);
    }
}
