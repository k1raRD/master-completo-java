package com.acollado.poo_herencia;

public class Profesor extends Persona{
    private String asignatura;
    public Profesor(){
        System.out.println("Profesor: Inicializando constructor");
    }
    public Profesor(String nombre, String apellido){
        super(nombre, apellido);
    }

    public Profesor(String nombre, String apellido, String asignatura){
        super(nombre, apellido);
        this.asignatura = asignatura;
    }
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String saludar() {
        return super.saludar() + " soy el profespr " + this.getNombre() +
                " de " + this.getAsignatura();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nasignatura='" + asignatura + '\'';
    }
}
