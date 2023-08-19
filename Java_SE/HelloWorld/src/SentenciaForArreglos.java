import javax.swing.*;

public class SentenciaForArreglos {
    public static void main(String[] args) {
        String[] nombres = {"Alex", "Maria", "Pepe", "Josefa", "Jose", "pedro"};
        int count = nombres.length;

        for (int i = 0; i < count; i++) {
            if (nombres[i].equalsIgnoreCase("Pedro")){
                System.out.println("nombres " + (i + 1) + " " + nombres[i]);
                break;
            }
        }

        String buscar = JOptionPane.showInputDialog("Ingrese un nombre a bucar: ");
        System.out.println("buscar = " + buscar);

        boolean encontrado = false;
        for (int i = 0; i < count; i++) {
            if(nombres[i].equalsIgnoreCase(buscar)){
                encontrado = true;
                break;
            }
        }
        if (encontrado){
            JOptionPane.showMessageDialog(null, "El nombre fue encontrado.");
        }else {
            JOptionPane.showMessageDialog(null, "El nombre no existe.");
        }

    }
}
