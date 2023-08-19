import javax.swing.*;

public class SistemasNumericos {
    public static void main(String[] args) {
        String numeroStr = JOptionPane.showInputDialog("Introduzca un numero: ");
        int numeroDecimal = 0;
        try {
            numeroDecimal = Integer.parseInt(numeroStr) ;
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error! Debe ingresar un numero entero");
            main(args);
            System.exit(0);
        }

        System.out.println("numeroDecimal = " + numeroDecimal);

        String mensajeBinario = "Numero binario de " + numeroDecimal + " = " + Integer.toBinaryString(numeroDecimal);
        System.out.println(mensajeBinario);

        int numeroBinario = Integer.parseInt(Integer.toBinaryString(numeroDecimal));
        System.out.println("numeroBinario = " + numeroBinario);

        String mensajeOctal = "\nNumero octal de " + numeroDecimal + " = " + Integer.toOctalString(numeroDecimal);
        System.out.println(mensajeOctal);
//        int numeroOctal = Integer.parseInt(Integer.toOctalString(numeroDecimal));
//        System.out.println("numeroOctal = " + numeroOctal);

        String mensajeHex = "\nNumero hexadecimal de " + numeroDecimal + " = " + Integer.toHexString(numeroDecimal);
        System.out.println(mensajeHex);
//        int numeroHex = Integer.parseInt(Integer.toHexString(numeroDecimal));
//        System.out.println("numeroHex = " + numeroHex);

        String mensaje = mensajeBinario + mensajeOctal + mensajeHex;
        JOptionPane.showMessageDialog(null, mensaje);
        
    }
}
