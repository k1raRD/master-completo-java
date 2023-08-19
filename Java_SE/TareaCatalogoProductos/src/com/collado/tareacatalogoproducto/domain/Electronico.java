package com.collado.tareacatalogoproducto.domain;

abstract public class Electronico extends Producto implements IElectronico{
    private String fabricante;
    public Electronico(int precio, String fabricante) {
        super(precio);
        this.fabricante = fabricante;
    }
    @Override
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    @Override
    public String toString() {
        return super.toString() + " Electronico{" +
                "fabricante='" + fabricante + '\'' +
                '}';
    }
}
