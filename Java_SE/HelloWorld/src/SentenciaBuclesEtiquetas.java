public class SentenciaBuclesEtiquetas {
    public static void main(String[] args) {

        bucle1:
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    continue bucle1;
                }
                System.out.print("i = " + i + ", j = " + j);
            }
        }
        System.out.println("\n===============================================================");
        etiqueta:
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    continue etiqueta;
                }
                System.out.print("i = " + i + ", j = " + j);
            }
        }
    }
}
