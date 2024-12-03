/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Productos;

import Modelo.Proveedor.Proveedor;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DaniTini
 */
public class Productos {
          private int codigo;
    private String nombre;
    private String categoria;
    private int precio;
    private int cantDisponible;
    private Proveedor proveedor;

    public Productos(int codigo, String nombre, String categoria, int precio, int cantDisponible, Proveedor proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantDisponible = cantDisponible;
        this.proveedor = proveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    public static int calcularTotalInventario(ArrayList<Productos> listaProductos) {
        int totalPrecios = 0;

        for (Productos producto : listaProductos) {
            int precio = producto.getPrecio();
            totalPrecios += precio;
        }
        if (totalPrecios == 0) {
            JOptionPane.showMessageDialog(null, "No hay total de inventario que mostrar");
        } else {
            JOptionPane.showMessageDialog(null, "El total de precios es: " + totalPrecios);
        }
        return totalPrecios;
    }
}
