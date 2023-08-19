package com.k1rard.api.stream.ejemplos;

import com.k1rard.api.stream.ejemplos.models.Factura;
import com.k1rard.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("john", "Doe");
        Usuario usuario2 = new Usuario("Pepe", "Perez");
        usuario1.addFacturas(new Factura("Compras tecnologias"));
        usuario1.addFacturas(new Factura("Muebles"));
        usuario2.addFacturas(new Factura("Bicicleta"));
        usuario2.addFacturas(new Factura("Notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

//        for(Usuario u: usuarios){
//            for (Factura f: u.getFacturas()){
//                System.out.println(f.getDescripcion());
//            }
//        }

        usuarios.stream().flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : cliente ")
                        .concat(f.getUsuario().toString())));

        usuarios.stream()
                .map(Usuario::getFacturas)
                .flatMap(Collection::stream)
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : cliente ")
                        .concat(f.getUsuario().toString())));

    }
}
