package com.k1rard.javaactualizado.functional;

/**
 * @author k1rard
 * Clase que representa una interface funcional personalizada
 * 1ero debe tener la anotacion @FunctionalInterface
 * 2do Solo DEBE TENER UN METODO ABSTRACTO.
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    String mostrarNombre(String nombre);
}
