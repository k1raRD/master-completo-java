package com.k1rard.contarcollecciones;
import java.util.HashMap;
import java.util.Map;

public class ContadorCollecciones {

    public static Map<Character, Integer> contador(String mensaje) {
        Map<Character, Integer> mapa = new HashMap<>();
        for (Character letra : mensaje.toCharArray()) {
            Integer contador = mapa.get(letra);
            if (contador == null) {
                contador = 0;
            }
            contador++;
            mapa.put(letra, contador);
        }
        return mapa;
    }

    public static void main(String[] args) {
        System.out.println(contador("mi mamá me mima"));
    }

}