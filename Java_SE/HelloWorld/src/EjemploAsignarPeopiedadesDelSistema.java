import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class EjemploAsignarPeopiedadesDelSistema {
    public static void main(String[] args) {

        try {
            FileInputStream archivo = new FileInputStream("src/config.properties");
            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada", "Mi valor personalizado");
            System.setProperties(p);
            
            Properties ps = System.getProperties();
            System.out.println("ps.getProperty(\"mi.propiedad.personalizada\") = " + ps.getProperty("mi.propiedad.personalizada"));
            
            ps.list(System.out);
        } catch (Exception e) {
            System.err.println("No existe el archivo " + e);
            System.exit(1);
        }
    }
}
