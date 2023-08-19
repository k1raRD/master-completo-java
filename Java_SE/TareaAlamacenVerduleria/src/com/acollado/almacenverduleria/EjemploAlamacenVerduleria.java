package com.acollado.almacenverduleria;

import com.acollado.almacenverduleria.domain.*;

public class EjemploAlamacenVerduleria {
    public static void main(String[] args) {
        Fruta manzana = new Fruta("Manzana", 12.4);
        manzana.setPeso(0.5);
        manzana.setColor("Verde");

        Lacteo leche = new Lacteo("Rica", 15.4);
        leche.setProteinas(22);
        leche.setCantidad(1);

        Limpieza desinfectante =  new Limpieza("Desinfectante Lavanda", 0.9);
        desinfectante.setComponentes("lysol");
        desinfectante.setLitros(1.3);

        NoPerecible tuna = new NoPerecible("Tuna oceanica", 20.3);
        tuna.setContenido(32);
        tuna.setCalorias(22);

        Producto[] productos = {manzana, leche, desinfectante, tuna};

        for(Producto producto: productos){
            System.out.println("");
            System.out.println(producto.toString());
        }

    }
}
