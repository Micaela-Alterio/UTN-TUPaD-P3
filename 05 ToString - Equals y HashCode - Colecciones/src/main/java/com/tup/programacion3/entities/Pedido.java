package com.tup.programacion3.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.tup.programacion3.Base;
import com.tup.programacion3.Calculable;
import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;


public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Set<DetallePedido> detalles = new HashSet<>();
    private Usuario usuario;

    /*----------------------------------------------------------------------------
      Constructores
    -----------------------------------------------------------------------------*/

    //Constructor vacío
    public Pedido() {
    }

    //Constructor que recibe todos los atributos.
    public Pedido(long id,
                  boolean eliminado,
                  LocalDateTime createdAt,
                  Estado estado,
                  FormaPago formaPago,
                  Usuario usuario) {

        super(id, eliminado, createdAt);

        this.estado = estado;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.fecha= LocalDate.now();

        usuario.addPedido(this);
    }

    /*----------------------------------------------------------------------------
      métodos
    -----------------------------------------------------------------------------*/

    public void addDetallePedido(int cantidad, Producto producto) {
        if (producto != null) {
            DetallePedido nuevoDetalle = new DetallePedido();

            nuevoDetalle.setId(detalles.size() + 1);
            nuevoDetalle.setCantidad(cantidad);
            nuevoDetalle.setProducto(producto);

            detalles.add(nuevoDetalle);
            calcularTotal();
        }
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {

        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {

        DetallePedido eliminarDetallePedido = null;

        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().equals(producto)) {
                eliminarDetallePedido = detalle;
            }
        }

        if (eliminarDetallePedido != null) {
            detalles.remove(eliminarDetallePedido);
            calcularTotal();
        }
    }

    @Override
    public void calcularTotal() {
        double suma = 0;

        for (DetallePedido detalle : detalles) {
            suma += detalle.getSubtotal();
        }
        total = suma;
    }




    /*----------------------------------------------------------------------------
      toString
    -----------------------------------------------------------------------------*/

    @Override
    public String toString() {

        //No me gustaba como se veía la información de detalles entre corchetes asi que
        // investigué como quitarlos
        String detallesLimpio = detalles.toString().replace("[", "").replace
                ("]", "").replace(", ", "");

        return "Info del Pedido:\n" +
                "\n  Fecha: " + fecha +
                "\n  Usuario que realizó el pedido: " +
                     (usuario != null ? usuario.getNombre() : "Sin usuario")+
                "\n  Estado: " + estado + "\n" +
                "\n  Detalle del pedido:\n" + detallesLimpio +
                "\n  Total: " + total +
                "\n  Modalidad de pago: " + formaPago + "\n";
    }

    /*----------------------------------------------------------------------------
      equals y hashCode
    -----------------------------------------------------------------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return this.getId() == pedido.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    /*----------------------------------------------------------------------------
    getters y setters
    -----------------------------------------------------------------------------*/

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Set<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}