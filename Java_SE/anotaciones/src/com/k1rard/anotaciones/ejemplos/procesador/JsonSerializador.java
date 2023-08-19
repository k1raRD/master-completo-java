package com.k1rard.anotaciones.ejemplos.procesador;

import com.k1rard.anotaciones.ejemplos.Init;
import com.k1rard.anotaciones.ejemplos.JsonAtributo;
import com.k1rard.anotaciones.ejemplos.procesador.exception.JsonSreializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static void inicializarObjeto(Object objeto){
        if (Objects.isNull(objeto)) {
            throw new JsonSreializadorException("El objeto a serializar no puede ser null");
        }
        Method[] metodos = objeto.getClass().getDeclaredMethods();
        Arrays.stream(metodos).filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m -> {
                    m.setAccessible(true);
                    try {
                        m.invoke(objeto);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSreializadorException("Error al serializar, no se puede serializar el objeto");
                    }
                });
    }
    public static String convertitJson(Object object) {
        if (Objects.isNull(object)) {
            throw new JsonSreializadorException("El objeto a serializar no puede ser null");
        }
        inicializarObjeto(object);
        Field[] atributos = object.getClass().getDeclaredFields();

        return Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                .map(f -> {
                    f.setAccessible(true);
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object valor = f.get(object);
                        if (f.getAnnotation(JsonAtributo.class).capitalizar() &&
                                valor instanceof String) {
                            String nuevoValor = (String) valor;
                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0, 1).toUpperCase()
                                            + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));
                            f.set(object, nuevoValor);
                        }
                        return "\"" + nombre + "\":\"" + f.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSreializadorException("Error al serializar a json: " + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{".equals(a)) {
                        return a + b;
                    }
                    return a + ", " + b;
                }).concat("}");
    }
}
