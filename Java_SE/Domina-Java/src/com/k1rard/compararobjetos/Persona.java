package com.k1rard.compararobjetos;

import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable<Persona>
{
    private static final int IGUALES = 0;
    private static final int THIS_MAYOR = 1;
    private static final int THIS_MENOR = -1;

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Persona obj) {
        if (obj == null || !(obj instanceof Persona)) {
            return THIS_MAYOR;
        }

        Persona otra = (Persona)obj;
        int compAp = apellidos.compareTo(otra.apellidos);
        if (compAp != IGUALES) {
            return compAp;
        }

        int compNom = nombre.compareTo(otra.nombre);
        if (compNom != IGUALES) {
            return compNom;
        }

        int compEdad = fechaNacimiento.compareTo(otra.fechaNacimiento);
        return -compEdad; // consideramos menor al de mayor fecha de nacimiento
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellidos, fechaNacimiento, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return Objects.equals(apellidos, other.apellidos)
                && Objects.equals(fechaNacimiento, other.fechaNacimiento)
                && Objects.equals(nombre, other.nombre);
    }
}
