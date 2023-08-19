public class EjemploStringExtensionArchivo {
    public static void main(String[] args) {
        String archivo = "alguna_imagen.jsx";
        int i = archivo.lastIndexOf(".");
        String extension = archivo.substring(i + 1, archivo.length());
        System.out.println("extension = " + extension);
    }
}
