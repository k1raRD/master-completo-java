import java.util.Random;

public class EjemploClaseMathRandom {
    public static void main(String[] args) {
        String[] colores = {"rojo", "azul", "verde", "amarillo", "morado", "rosa", "naranja"};
        double random = Math.random();
        System.out.println("random = " + random);
        
        random *= 7;
        System.out.println("random = " + random);
        
        random = Math.floor(random);
        System.out.println("random = " + random);

        int randomInt = (int) Math.round(random);
        System.out.println("colores = " + colores[randomInt]);

        Random randomObj = new Random();
        randomInt = 15 + randomObj.nextInt(25 - 15);
        System.out.println("randomInt = " + randomInt);
        long randomLong = randomObj.nextLong();
        System.out.println("randomLong = " + randomLong);

        randomInt = randomObj.nextInt(colores.length);
        System.out.println("randomInt = " + randomInt);
        System.out.println("colores = " + colores[randomInt]);
    }
}
