import java.util.Scanner;

public class DetalleFactura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a su aplicacion de facturas.");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print(nombre + " ingrese el nombre de la factura:");
        String nombreFactura = scanner.nextLine();
        System.out.print(nombre + " Digite el primer precio del producto:");
        double primerPrecioProducto = scanner.nextDouble();
        System.out.print(nombre + " Digite el segundo precio del producto:");
        double segundoPrecioProducto = scanner.nextDouble();
        double resultadoPreciosProductos = primerPrecioProducto + segundoPrecioProducto;
        double impuestoProductos = resultadoPreciosProductos * 0.19;
        double resultadoPrecioAPagar = resultadoPreciosProductos + impuestoProductos;
        System.out.println("Factura: " + nombreFactura + "\nTotal bruto: " + resultadoPreciosProductos +
                "\nTotal impuesto: " + impuestoProductos +
                "\nTotal a pagar: " + resultadoPrecioAPagar);
    }
}
