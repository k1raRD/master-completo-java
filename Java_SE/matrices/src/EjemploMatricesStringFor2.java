public class EjemploMatricesStringFor2 {
    public static void main(String[] args) {

        String[][] nombres = {{"Alex","Andres"}, {"Mario","Paco"}, {"Maria","Lucas"}};

        System.out.println("============ Iterando con for ============");
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                System.out.println("El nombre en la fila: n'" + (i + 1) +" en la columna: n'" + (j + 1) + " es: " + nombres[i][j]);
            }
        }
        System.out.println("============ Iterando con forEach ============");
        for(String[] fila: nombres){
            for (String nombre: fila){
                System.out.println("nombre = " + nombre);
            }
        }

    }
}
