package com.k1rard.lambda;

import com.k1rard.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };

        consumidor.accept(new Date());

        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre + ", is " + edad + " years old!");
        consumidorBi.accept("Alex", 20);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Klok mio");

        List<String> nombres = Arrays.asList("andres", "pepe", "maria", "pedro");
        nombres.forEach(consumidor2);

        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario = new Usuario();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, "Alex");
        System.out.println("Nombre del usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola Mundo";

        System.out.println(proveedor.get());
    }
}
