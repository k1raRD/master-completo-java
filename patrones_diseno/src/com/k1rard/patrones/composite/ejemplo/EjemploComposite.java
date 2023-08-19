package com.k1rard.patrones.composite.ejemplo;

import com.k1rard.patrones.composite.Archivo;
import com.k1rard.patrones.composite.Directorio;

public class EjemploComposite {
    public static void main(String[] args) {
        Directorio dir = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponete(new Archivo("Patron-Composite.docx"));
        Directorio stream = new Directorio("Api-stream");
        stream.addComponete(new Archivo("stream-map.docx"));
        java.addComponete(stream);
        dir.addComponete(java);
        dir.addComponete(new Archivo("cv.pdf"));
        dir.addComponete(new Archivo("logo.jpg"));

        System.out.println(dir.mostrar(0));
    }
}
