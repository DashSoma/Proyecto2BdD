/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Proveedor;

/**
 *
 * @author dashs
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String contacto;
    private String direccion;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID");
        }
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }
    
    public void setContacto(String contacto) {
        if (contacto == null || contacto.isEmpty()) {
            throw new IllegalArgumentException("El telefono no puede ser nulo o vacío");
        }
        this.contacto = contacto;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }
        this.direccion = direccion;
    }

    public Proveedor(int id, String nombre, String contacto, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public Proveedor(String nombre, String contacto, String direccion) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public Proveedor(int id) {
        this.id = id;
    }

    public Proveedor(int id, String contacto) {
        this.id = id;
        this.contacto = contacto;
        
    }

    public Proveedor() {
    }

}
