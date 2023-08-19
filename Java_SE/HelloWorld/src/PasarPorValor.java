public class PasarPorValor {
    public static void main(String[] args) {
        int i = 10;
        System.out.println("Iniciamos el main con i = " + i);
        test(i);
        System.out.println("Finaliza el metodo main con i = " + i);
    }

    public static void test(int i){
        System.out.println("iniciamos el metodo test con i = " + i);
        i = 35;
        System.out.println("El nuevo valor de i = " + i);
    }
}
