package com.k1rard.archivos.ejemplos;

import com.k1rard.archivos.ejemplos.service.ArchivoService;

public class EjemploLeerArchivo {
    public static void main(String[] args) {

        ArchivoService service = new ArchivoService();
        System.out.println(service.leerArchivo("C:\\Users\\Usuario\\Documents\\Cursos-notes-and-projects\\Java\\Master Completo en Java\\manejo_archivos\\src\\com\\k1rard\\archivos\\ejemplos\\arhivoPrueba.txt"));
    }
}
