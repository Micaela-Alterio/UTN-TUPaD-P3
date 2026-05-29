package com.tup.programacion3.entities;

import com.tup.programacion3.Base;
import com.tup.programacion3.enums.Rol;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String clave;
    private Rol rol;
    private Set<Pedido> pedidos = new HashSet<>();

    /*----------------------------------------------------------------------------
      Constructores
    -----------------------------------------------------------------------------*/

    //Constructor vacío
    public Usuario() {
    }

    //Constructor que recibe todos los atributos.
    public Usuario(long id,
                   boolean eliminado,
                   LocalDateTime createdAt,
                   String nombre,
                   String apellido,
                   String mail,
                   String celular,
                   String clave,
                   Rol rol) {

        super(id, eliminado, createdAt);

        this.nombre = nombre;
        this.rol = rol;
        this.clave = clave;
        this.celular = celular;
        this.mail = mail;
        this.apellido = apellido;
    }

    /*----------------------------------------------------------------------------
      métodos
    -----------------------------------------------------------------------------*/

    //Metodo para agregar un pedido al usuario
    public void addPedido(Pedido pedido){
        if (pedido != null && !pedidos.contains(pedido)){
            pedidos.add(pedido);
            pedido.setUsuario(this);
        }
    }

    /*----------------------------------------------------------------------------
      toString
    -----------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Datos del Usuario:" +
                "\n  Nombre: " + nombre +
                "\n  Apellido: " + apellido +
                "\n  Id: " + getId() +
                "\n  Mail: " + mail +
                "\n  Celular: " + celular +
                "\n  Clave: ******" +
                "\n  Rol: " + rol +
                "\n  Cantidad de pedidos: " + pedidos.size() + "\n";
    }

    /*----------------------------------------------------------------------------
      equals y hashCode
    -----------------------------------------------------------------------------*/

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getNombre(), usuario.getNombre()) &&
                Objects.equals(getApellido(), usuario.getApellido()) &&
                Objects.equals(getMail(), usuario.getMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNombre(), getApellido(), getMail());
    }

    /*----------------------------------------------------------------------------
      getters y setters
    -----------------------------------------------------------------------------*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
