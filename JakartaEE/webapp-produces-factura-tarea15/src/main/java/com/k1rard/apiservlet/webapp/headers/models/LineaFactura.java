package com.k1rard.apiservlet.webapp.headers.models;

import java.lang.annotation.Inherited;

public class LineaFactura {

    private ProductoTarea producto;
    private Integer cantidad;

    public LineaFactura(ProductoTarea producto, Integer cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ProductoTarea getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer calcularImporte(){
        return cantidad * producto.getPrecio();
    }
}
