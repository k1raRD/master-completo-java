package com.acollado.empleadosclientespoo.domain;

public class Gerente extends Empleado{
    private double presupuesto;

    public Gerente(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Gerente(double remuneracion, double presupuesto) {
        super(remuneracion);
        this.presupuesto = presupuesto;
    }

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion, double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion);
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return super.toString() + " Gerente{" +
                "presupuesto=" + presupuesto +
                '}';
    }
}
