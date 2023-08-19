package com.k1rard.anotaciones.ejemplos;

import com.k1rard.anotaciones.ejemplos.models.Producto;
import com.k1rard.anotaciones.ejemplos.procesador.JsonSerializador;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa centro roble");
        p.setPrecio(1000L);


        System.out.println("json = " + JsonSerializador.convertitJson(p));
    }
}
