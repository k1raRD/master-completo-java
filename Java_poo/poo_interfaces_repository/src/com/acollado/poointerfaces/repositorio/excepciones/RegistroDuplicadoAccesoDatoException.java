package com.acollado.poointerfaces.repositorio.excepciones;

public class RegistroDuplicadoAccesoDatoException extends EscrituraAccesoDatoException{
    public RegistroDuplicadoAccesoDatoException(String mensaje) {
        super(mensaje);
    }
}
