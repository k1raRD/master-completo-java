public class EjemploStringMetodosArreglos {
    public static void main(String[] args) {
        
        String trabaLenguas = "trabalenguas";
        System.out.println("trabaLenguas.toCharArray() = " + trabaLenguas.toCharArray());
        System.out.println("trabaLenguas.length() = " + trabaLenguas.length());
        char[] arreglo = trabaLenguas.toCharArray();
        System.out.println("arreglo.length = " + arreglo.length);
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " - ");
        }
        System.out.println();
        System.out.println("trabaLenguas = " + trabaLenguas.split("a"));

        String[] arreglo2 = trabaLenguas.split("a");
        for (int i = 0; i < arreglo2.length; i++) {
            System.out.println("arreglo2[i] = " + arreglo2[i]);
        }
        
        trabaLenguas = "alguna_imagen.sas.pdf";
        arreglo2 = trabaLenguas.split("[.]"); // [.]
        System.out.println("Extension = " + arreglo2[arreglo2.length - 1]);
    }
}
