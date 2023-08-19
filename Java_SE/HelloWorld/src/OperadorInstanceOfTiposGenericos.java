public class OperadorInstanceOfTiposGenericos {
    public static void main(String[] args) {
        Object texto = new String("Creando un objeto de la clase String... que tal!");
        Number num = 7;

        boolean b1 = texto instanceof String;
        System.out.println("Es texto del tipo String:  " + b1);

        b1 = texto instanceof Object;
        System.out.println("Es texto del tipo Object:  " + b1);

        b1 = texto instanceof Integer;
        System.out.println("texto es del tipo Integer ?" + b1);

        b1 = num instanceof Integer;
        System.out.println("Es num del tipo Integer:  " + b1);

        b1 = num instanceof Number;
        System.out.println("Es num del tipo Number:  " + b1);

        b1 = num instanceof Long;
        System.out.println("Es num del tipo Long:  " + b1);

        b1 = num instanceof Double;
        System.out.println("Es num del tipo Double:  " + b1);

        b1 = num instanceof Object;
        System.out.println("Es num del tipo Object:  " + b1);

        Number decimal = 90.32f;
        b1 = decimal instanceof Number;
        System.out.println("Es decimal de tipo Number " + b1);

        b1 = decimal instanceof Double;
        System.out.println("Es decimal de tipo Double " + b1);

        b1 = decimal instanceof Float;
        System.out.println("Es decimal de tipo Float " + b1);

//        b1 = b1 instanceof Boolean;
//        System.out.println("b1 es un objeto de la clase Boolean:  " + b1);
    }
}
