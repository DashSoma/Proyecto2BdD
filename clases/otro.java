package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase que representa a un colaborador
 *
 * @author Crisp
 */
public class otro {

    private int codigo;
    private String nombre;
    private String categoria;
    private int precio;
    private int cantDisponible;
    private String proveedor;
    private LocalDate fechaPIngresado = LocalDate.now();
    private int vTotalInventario;

    public otro(int codigo, String nombre, String categoria, int precio, int cantDisponible, String proveedor, LocalDate fechaDespido, int vTotalInventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantDisponible = cantDisponible;
        this.proveedor = proveedor;
        this.fechaPIngresado = fechaDespido;
        this.vTotalInventario = vTotalInventario;
    }

    /**
     * Constructor por defecto que inicializa los atributos con valores
     * predeterminados.
     */
    public otro() {
        this.codigo = 0;
        this.nombre = "";
        this.categoria = "";
        this.fechaPIngresado = LocalDate.now();
        this.precio = 0;
        this.cantDisponible = 0;
        this.proveedor = "";
        this.vTotalInventario = 0;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFechaPIngresado() {
        return fechaPIngresado;
    }

    public void setFechaPIngresado(LocalDate fechaDespido) {
        this.fechaPIngresado = fechaDespido;
    }

    public int getvTotalInventario() {
        return vTotalInventario;
    }

    public void setvTotalInventario(int vTotalInventario) {
        this.vTotalInventario = vTotalInventario;
    }

    public static int calcularTotalInventario(ArrayList<otro> listaProductos) {
        int totalPrecios = 0;

        for (otro producto : listaProductos) {
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
