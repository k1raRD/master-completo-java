package com.k1rard.escribirficheros;

import com.k1rard.leerficheros.Dato;
import com.k1rard.leerficheros.LeerEntrada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EscribirSalida {
    public static void main(String[] args) {

        try( Scanner s  = new Scanner(new File("C:\\Users\\Usuario\\Documents\\Cursos-notes-and-projects\\Java\\Master Completo en Java\\Domina-Java\\src\\entrada.txt"));
             FileWriter fw = new FileWriter("salida.txt");
                ) {
            List<Dato> leidos = LeerEntrada.leerDatos(s);
            for(Dato dato : leidos){
                String linea = dato.getFecha() + ";" + dato.getNombre() + ";" + dato.getSueldo() + "\n";
                fw.write(linea);
            }
            System.out.println("Ya esta, puesdes revisar el archivo");
        }catch (IOException e) {
            System.err.println("No se econtro el archivo");
            throw new RuntimeException(e);
        }

    }
}
