package com.collado.tareacatalogoproducto.domain;

abstract public class Producto implements IProducto{

    private int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                '}';
    }
}
