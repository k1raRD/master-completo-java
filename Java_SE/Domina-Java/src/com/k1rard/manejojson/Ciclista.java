package com.k1rard.manejojson;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ciclista {
    private String nombre;
    private Date fechaNacimiento;
    private LocalDate otraFecha;
    private List<Bicicleta> bicicletas;

    public Ciclista(String nombre, Date fechaNacimiento, LocalDate otraFecha) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.otraFecha = otraFecha;
        bicicletas = new ArrayList<>();
    }

    public void anadirBicicleta(Bicicleta bici) {
        bicicletas.add(bici);
    }

    @Override
    public String toString() {
        return "Ciclista [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", otraFecha=" + otraFecha + ", bicicletas=" + bicicletas + "]";
    }
}
