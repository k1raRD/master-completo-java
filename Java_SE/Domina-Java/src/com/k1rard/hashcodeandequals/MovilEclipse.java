package com.k1rard.hashcodeandequals;

import java.util.Objects;

public class MovilEclipse {
    private String marca;
    private String modelo;
    private String numSerie;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MovilEclipse other = (MovilEclipse) obj;
        return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }
}