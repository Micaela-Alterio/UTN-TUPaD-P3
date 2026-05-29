package com.tup.programacion3.entities;

import com.tup.programacion3.Base;

import java.time.LocalDateTime;
import java.util.Objects;

public class Producto extends Base {
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;
    private Categoria categoria;

    /*--------------------------------------------------------------------------------------------
      Constructores
    --------------------------------------------------------------------------------------------*/

    //Constructor vacío
    public Producto() {
    }

    //Constructor que recibe todos los atributos.
    public Producto(long id,
                    boolean eliminado,
                    LocalDateTime createdAt,
                    String nombre,
                    Double precio,
                    String descripcion,
                    int stock,
                    String imagen,
                    boolean disponible,
                    Categoria categoria) {

        super(id, eliminado, createdAt);

        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
        this.categoria = categoria;

        categoria.addProducto(this);
    }

    /*--------------------------------------------------------------------------------------------
      toString
    --------------------------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Info Producto:" +
                "\n  Nombre: " + nombre +
                "\n  Id: " + getId() +
                "\n  Precio: " + precio +
                "\n  Descripcion: " + descripcion +
                "\n  Stock: " + stock +
                "\n  Imagen: " + imagen +
                "\n  Disponibilidad: " + (disponible ? "Producto en Stock" : "Producto faltante") +
                "\n  Categoria: " + (categoria != null ? categoria.getNombre() : "Sin categoría")+"\n";
    }

    /*--------------------------------------------------------------------------------------------
      equals y hashCode
    --------------------------------------------------------------------------------------------*/

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(getNombre(), producto.getNombre()) &&
                Objects.equals(getImagen(), producto.getImagen()) &&
                Objects.equals(getCategoria(), producto.getCategoria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNombre(), getImagen(), getCategoria());
    }

    /*--------------------------------------------------------------------------------------------
      getters y setters
    --------------------------------------------------------------------------------------------*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}