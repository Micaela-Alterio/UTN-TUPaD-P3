package com.tup.programacion3.entities;

import com.tup.programacion3.Base;

import java.time.LocalDateTime;
import java.util.Objects;

public class DetallePedido extends Base {
    private int cantidad;
    private Double subtotal;
    private Producto producto;

    /*----------------------------------------------------------------------------------------
      Constructores
    ----------------------------------------------------------------------------------------*/

    //Constructor vacío
    public DetallePedido() {
    }

    //Constructor que recibe todos los atributos.
    public DetallePedido(long id,
                         boolean eliminado,
                         LocalDateTime createdAt,
                         int cantidad,
                         Producto producto) {

        super(id, eliminado, createdAt);

        this.cantidad = cantidad;
        this.producto = producto;

        calcularSubtotal();
    }

    /*----------------------------------------------------------------------------------------
      métodos
    ----------------------------------------------------------------------------------------*/

    //Metodo para calcular el subtotal del pedido
    public void calcularSubtotal() {
        if (producto != null) {
            subtotal = cantidad * producto.getPrecio();
        } else {
            subtotal = 0.0;
        }
    }

    /*----------------------------------------------------------------------------------------
      toString
    ----------------------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "\n   Producto: " + (producto != null ? producto.getNombre() : "Sin producto") +
                "\n   Cantidad: " + cantidad +
                "\n   Subtotal: " + subtotal + "\n";

    }

    /*----------------------------------------------------------------------------------------
      equals y hashCode
    ----------------------------------------------------------------------------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallePedido detallePedido)) return false;
        return this.getId() == detallePedido.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    /*----------------------------------------------------------------------------------------
      getters y setters
    ----------------------------------------------------------------------------------------*/

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        calcularSubtotal();
    }


}