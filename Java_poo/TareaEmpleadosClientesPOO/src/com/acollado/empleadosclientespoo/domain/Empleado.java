package com.acollado.empleadosclientespoo.domain;

public class Empleado extends Persona{
    private double remuneracion;
    private int empleadoId;
    private static int ultimoEmpleadoId;

    public Empleado(){
        this.empleadoId = ++ultimoEmpleadoId;
    }

    public Empleado(double remuneracion) {
        this();
        this.remuneracion = remuneracion;
    }

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.empleadoId = ++ultimoEmpleadoId;
        this.remuneracion = remuneracion;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public void aumentarRemuneracion(int porcentaje){
        this.remuneracion += remuneracion * porcentaje/100;
    }

    @Override
    public String toString() {
        return super.toString() + " Empleado{" +
                "remuneracion=" + remuneracion +
                ", empleadoId=" + empleadoId +
                '}';
    }
}
