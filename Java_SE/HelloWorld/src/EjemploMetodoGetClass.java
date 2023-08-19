import java.io.ObjectStreamClass;
import java.lang.reflect.Method;

public class EjemploMetodoGetClass {
    public static void main(String[] args) {
        String texto = "Hola que tal";
        
        Class strClass = texto.getClass();

        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getName() = " + strClass.getSimpleName());
        System.out.println("strClass.getName() = " + strClass.getPackage());
        System.out.println("strClass.getName() = " + strClass.getPackageName());

        for (Method method: strClass.getMethods()){
            System.out.println("method.getName() = " + method.getName());
        }

        Integer numero = 34;
        Class integerClass = numero.getClass();
        Class objClass = integerClass.getSuperclass().getSuperclass();
        System.out.println("integerClass.getSuperclass().getSuperclass() = " + integerClass.getSuperclass());
        System.out.println("integerClass.getSuperclass().getSuperclass() = " + integerClass.getSuperclass().getSuperclass());

        for (Method method: objClass.getMethods()){
            System.out.println("objClass.getName() = " + objClass.getName());
        }


    }
}
