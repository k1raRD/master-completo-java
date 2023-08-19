public class EjemploMatricesStringFor {
    public static void main(String[] args) {

        String[][] nombres = new String[3][2];

        nombres[0][0] = "Alex";
        nombres[0][1] = "Andres";
        nombres[1][0] = "Mario";
        nombres[1][1] = "Paco";
        nombres[2][0] = "Maria";
        nombres[2][1] = "Lucas";

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
