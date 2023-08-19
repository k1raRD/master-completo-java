package com.collado.tareabolsasupermercado.domain;

import java.util.List;

public class EjemploBolsaSupermercado {

    public static <T> void imprmirProducto(BolsaSupermercado<T> productos){
        for(T producto: productos){
            if(producto instanceof  Fruta){
                System.out.println("========== Fruta ==========");
                System.out.println( "Fruta: "+ ((Fruta) producto).getNombre() +
                        " \nPrecio: " + ((Fruta) producto).getPrecio() +
                        " \nPeso: " + ((Fruta) producto).getPeso() +
                        " Color: " + ((Fruta) producto).getColor());
            } else if (producto instanceof Lacteo) {
                System.out.println("========== Lacteo ==========");
                System.out.println( "Lacteo: "+ ((Lacteo) producto).getNombre() +
                        " \nPrecio: " + ((Lacteo) producto).getPrecio() +
                        " \nCantidad: " + ((Lacteo) producto).getCantidad() +
                        " Proteinas: " + ((Lacteo) producto).getProteinas());
            } else if (producto instanceof Limpieza) {
                System.out.println("========== Limpieza ==========");
                System.out.println( "Limpieza: "+ ((Limpieza) producto).getNombre() +
                        " \nPrecio: " + ((Limpieza) producto).getPrecio() +
                        " \nComponentes: " + ((Limpieza) producto).getComponentes() +
                        " Litros: " + ((Limpieza) producto).getLitros());
            } else if (producto instanceof NoPerecible) {
                System.out.println("========== No perecible ==========");
                System.out.println( "NoPerecible: "+ ((NoPerecible) producto).getNombre() +
                        " \nPrecio: " + ((NoPerecible) producto).getPrecio() +
                        " \nContenido: " + ((NoPerecible) producto).getContenido() +
                        " Calorias: " + ((NoPerecible) producto).getCalorias());
            }
        }
    }

    public static void main(String[] args) {
        BolsaSupermercado<Fruta> bolsaFrutas = new BolsaSupermercado<Fruta>();
        bolsaFrutas.addObjeto(new Fruta("Manzana", 14, 3.4, "Verde"));
        bolsaFrutas.addObjeto(new Fruta("Fresa", 18, 1.2, "Roja"));
        bolsaFrutas.addObjeto(new Fruta("Uva", 22.4, 0.8, "Purpura"));
        bolsaFrutas.addObjeto(new Fruta("Mango", 12.4, 1.3, "Amarillo"));
        bolsaFrutas.addObjeto(new Fruta("Pera", 11.2, 1.4, "Verde"));
        imprmirProducto(bolsaFrutas);

        BolsaSupermercado<Lacteo> bolsaLacteos = new BolsaSupermercado<Lacteo>();
        bolsaLacteos.addObjeto(new Lacteo("Leche rica", 10, 1, 20));
        bolsaLacteos.addObjeto(new Lacteo("Mantequilla", 12.3, 10, 21));
        bolsaLacteos.addObjeto(new Lacteo("Queso cheddar", 24, 13, 34));
        bolsaLacteos.addObjeto(new Lacteo("Queso mozzarella", 23.4, 32, 12));
        bolsaLacteos.addObjeto(new Lacteo("Yogurt", 24.3, 12, 30));
        imprmirProducto(bolsaLacteos);

        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<Limpieza>();
        bolsaLimpieza.addObjeto(new Limpieza("Cloro blanqueador", 12, "cloro", 2));
        bolsaLimpieza.addObjeto(new Limpieza("Suavitel", 9, "suavizante", 1));
        bolsaLimpieza.addObjeto(new Limpieza("Mistolin", 7, "limpiador", 3));
        bolsaLimpieza.addObjeto(new Limpieza("Desinfectante", 8, "cloro", 4));
        bolsaLimpieza.addObjeto(new Limpieza("Detergente", 15, "detergente", 4));

        BolsaSupermercado<NoPerecible> bolsaNoPerecibles = new BolsaSupermercado<NoPerecible>();
        bolsaNoPerecibles.addObjeto(new NoPerecible("Atún Lomitos en Agua Angelmo" ,170, 95 , 960));
        bolsaNoPerecibles.addObjeto(new NoPerecible("Jurel Natural Lata" ,425, 560 , 1120));
        bolsaNoPerecibles.addObjeto(new NoPerecible("Porotos Negros Listos Para Servir Caja" ,380, 234, 1030));
        bolsaNoPerecibles.addObjeto(new NoPerecible("Arroz Grano Largo Ancho Grado 1",1000, 3340,  1320));
        bolsaNoPerecibles.addObjeto(new NoPerecible("Porotos Hallado Bolsa",1000, 3536,  1990));
        imprmirProducto(bolsaNoPerecibles);

    }
}
