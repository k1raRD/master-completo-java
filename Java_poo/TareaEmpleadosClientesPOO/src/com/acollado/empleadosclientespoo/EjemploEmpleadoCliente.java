package com.acollado.empleadosclientespoo;

import com.acollado.empleadosclientespoo.domain.Gerente;

public class EjemploEmpleadoCliente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Alex", "collado", "1234342lklk",
                "calle 32 32kl32kn", 300, 20);
        gerente.aumentarRemuneracion(23);
        gerente.setPresupuesto(8000.54);
        System.out.println(gerente);
    }
}
