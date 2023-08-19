public class PasarPorReferencia {
    public static void main(String[] args) {
        int[] edad = {10,11,12};
        System.out.println("Iniciamos el main");
        for (int i = 0; i < edad.length; i++) {
            System.out.println("edad = " + edad[i]);
        }
        System.out.println("Antes de invocar al metodo test");
        test(edad);
        System.out.println("Despues de invocar al metodo test");
        for (int i = 0; i < edad.length; i++) {
            System.out.println("edad = " + edad[i]);
        }
        System.out.println("Finaliza el metodo main con los datos del array modificados");
    }

    public static void test(int edadArr[]){
        System.out.println("iniciamos el metodo test con");
        for (int i = 0; i < edadArr.length; i++) {
            edadArr[i] = edadArr[i] + 20;
        }
        System.out.println("Finaliza el metodo test");
    }
}
