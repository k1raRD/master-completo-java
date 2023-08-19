package com.collado.tareacatalogoproducto;

import com.collado.tareacatalogoproducto.domain.*;

import java.util.Arrays;
import java.util.Date;

public class EjemploTareaCatalogoProducto {
    public static void main(String[] args) {
        Comics comic = new Comics(200, new Date(), "Mauricio", "Spiderman", "No Starch press", "Spiderman");
        IPhone iphone = new IPhone(900, "Apple", "24 pro edition fullstack javascript", "gris");
        Libro libro = new Libro(50, new Date(), "Rockefeller", "Como hacerse pobre", "No starch press");
        TvLcd tv = new TvLcd(200, "Samsung", 50);

        Producto[] productos = {comic, iphone, libro, tv};
        for(Producto producto: productos){
            System.out.println("");
            System.out.println(producto);
        }
    }
}
