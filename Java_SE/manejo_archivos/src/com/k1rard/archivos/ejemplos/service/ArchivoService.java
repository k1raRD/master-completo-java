package com.k1rard.archivos.ejemplos.service;

import java.io.*;
import java.util.Scanner;

public class ArchivoService {
    public void crearArchivo(String nombre){
        File archivo = new File(nombre);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))){
            buffer.append("Hola que tal amigos")
                    .append("Todo bien?")
                    .append("Siempre es mucho mejpr usar el metodo append");
            System.out.println("El archivo se ha creado con exito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearArchivo2(String nombre){
        File archivo = new File(nombre);
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))){
            buffer.println("Hola que tal amigos");
            buffer.println("Todo bien?");
            buffer.println("Siempre es mucho mejpr usar el metodo append");
            buffer.printf("Claro que si %s", "Alex");
            System.out.println("El archivo se ha creado con exito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String leerArchivo(String nombreArchivo){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while((linea = reader.readLine()) != null){
                sb.append(linea).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public String leerArchivo2(String nombreArchivo){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombreArchivo);
        try {
            Scanner s = new Scanner(archivo);
            s.useDelimiter("\n");
            while(s.hasNext()){
                sb.append(s.next()).append("\n");
            }
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

}
