package com.k1rard.archivos.ejemplos;

import com.k1rard.archivos.ejemplos.service.ArchivoService;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\Usuario\\Documents\\Cursos-notes-and-projects\\Java\\Master Completo en Java\\manejo_archivos\\src\\com\\k1rard\\archivos\\ejemplos\\arhivoPrueba.txt";
        ArchivoService service = new ArchivoService();
        service.crearArchivo2(nombreArchivo);
    }
}
