public class OperadorInstanceOf {
    public static void main(String[] args) {
        String texto = new String("Creando un objeto de la clase String... que tal!");
        Integer num = 7;

        boolean b1 = texto instanceof String;
        System.out.println("Es texto del tipo String:  " + b1);

        b1 = texto instanceof Object;
        System.out.println("Es texto del tipo Object:  " + b1);

        b1 = num instanceof Integer;
        System.out.println("Es num del tipo Integer:  " + b1);

        b1 = num instanceof Number;
        System.out.println("Es num del tipo Number:  " + b1);

        b1 = num instanceof Object;
        System.out.println("Es num del tipo Object:  " + b1);

        Double decimal = 90.32;
        b1 = decimal instanceof Number;
        System.out.println("Es decimal de tipo Number " + decimal);

//        b1 = b1 instanceof Boolean;
//        System.out.println("b1 es un objeto de la clase Boolean:  " + b1);
    }
}
