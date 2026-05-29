package com.tup.programacion3.entities;

import com.tup.programacion3.Base;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;
    private Set<Producto> productos = new HashSet<>();

    /*--------------------------------------------------------------------------------
      Constructores
    ---------------------------------------------------------------------------------*/

    //Constructor vacío
    public Categoria() {
    }

    //Constructor que recibe todos los atributos.
    public Categoria(long id,
                     boolean eliminado,
                     LocalDateTime createdAt,
                     String nombre,
                     String descripcion) {

        super(id, eliminado, createdAt);

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /*--------------------------------------------------------------------------------
      métodos
    ---------------------------------------------------------------------------------*/

    //Metodo para agregar un producto a la categoria
    public void addProducto(Producto producto){

        if(producto != null && !productos.contains(producto)){
            productos.add(producto);
            producto.setCategoria(this);
        }
    }

    /*--------------------------------------------------------------------------------
      toString
    ---------------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Info de la Categoría:" +
                "\n  Nombre: " + nombre +
                "\n  Id: " + getId() +
                "\n  Descripcion: " + descripcion +
                "\n  Cantidad de productos: " + productos.size() + "\n";
    }

    /*--------------------------------------------------------------------------------
      equals y hashCode
    ---------------------------------------------------------------------------------*/

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Categoria categoria)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getNombre(), categoria.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNombre());
    }

    /*--------------------------------------------------------------------------------
      getters y setters
    ---------------------------------------------------------------------------------*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}