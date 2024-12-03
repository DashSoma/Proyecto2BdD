/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Productos;

/**
 *
 * @author DaniTini
 */
public class ProductoDTO {
     private final int codigo;
    private final String nombre;
    private final String categoria;
    private final double precio;
    private final int cantDisponible;
    private final int proveedor;

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public int getProveedor() {
        return proveedor;
    }

  
    public ProductoDTO(int codigo, String nombre, String categoria, double precio, int cantDisponible, int proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantDisponible = cantDisponible;
        this.proveedor = proveedor;
    }
}
