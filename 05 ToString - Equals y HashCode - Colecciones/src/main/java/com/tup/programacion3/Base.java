package com.tup.programacion3;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Base {
    private long id;
    private boolean eliminado;
    private LocalDateTime createdAt;

    /*----------------------------------------------------------------------------
      Constructores
    -----------------------------------------------------------------------------*/

    //Constructor vacío
    public Base() {
    }

    //Constructor que recibe todos los atributos.
    public Base(long id, boolean eliminado, LocalDateTime createdAt) {
        this.id = id;
        this.eliminado = eliminado;
        this.createdAt = createdAt;
    }

    /*----------------------------------------------------------------------------
      toString
    -----------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Info Base: " +
                "\n  Id: " + id +
                "\n  Eliminado: " + eliminado +
                "\n  CreatedAt: " + createdAt;
    }

    /*----------------------------------------------------------------------------
      equals y hashCode
    -----------------------------------------------------------------------------*/

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Base base)) return false;
        return id == base.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /*----------------------------------------------------------------------------
      getters y setters
    -----------------------------------------------------------------------------*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
