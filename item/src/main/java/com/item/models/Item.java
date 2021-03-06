package com.item.models;

import com.item.models.Producto;

import java.util.Date;

public class Item {

    private Producto producto;
    private Integer cantidad;

    public Item() {
    }

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    //se podria implementar un variable Total pero JSON se genera con todos los  get
    public Double getTotal() {
        return producto.getPrecio() * cantidad.doubleValue();
    }


}
