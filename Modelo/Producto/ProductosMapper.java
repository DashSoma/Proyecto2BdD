package Modelo.Producto;

import Modelo.Mapper.Mapper;
import Modelo.Proveedores.ProveedorDAO;
import Modelo.Proveedores.ProveedorDTO;
import java.sql.SQLException;
import java.util.Objects;

public class ProductosMapper implements Mapper<Productos, ProductosDTO> {

    private final ProveedorDAO proveedorDAO;

    // Constructor que recibe un ProveedorDAO
    public ProductosMapper(ProveedorDAO proveedorDAO) {
        // Validación de que proveedorDAO no sea nulo
        this.proveedorDAO = Objects.requireNonNull(proveedorDAO, "ProveedorDAO no puede ser nulo");
    }

    @Override
    public ProductosDTO toDTO(Productos ent) {
        try {
            // Obtener el nombre del proveedor usando el ProveedorDAO
            ProveedorDTO proveedor = proveedorDAO.read(ent.getProveedor());
            String nombreProveedor = (proveedor != null) ? proveedor.getNombre() : "Proveedor no encontrado";
            return new ProductosDTO(
                    ent.getCodigo(),
                    ent.getNombre(),
                    ent.getCategoria(),
                    ent.getPrecio(),
                    ent.getCantDisponible(),
                    ent.getProveedor()
            );
        } catch (SQLException e) {
            // Manejo de excepción más robusto
            System.err.println("Error al obtener el proveedor: " + e.getMessage());
            // Retornar un DTO con un mensaje de error en el nombre del proveedor
            return new ProductosDTO(
                    ent.getCodigo(),
                    ent.getNombre(),
                    ent.getCategoria(),
                    ent.getPrecio(),
                    ent.getCantDisponible(),
                    ent.getProveedor());
        }
    }

    @Override
    public Productos toEnt(ProductosDTO dto) {
        // Validaciones de los datos antes de asignarlos
        if (dto == null) {
            return null;
        }
        Productos producto = new Productos();
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());
        producto.setCantDisponible(dto.getCantDisponible());
        producto.setProveedor(dto.getProveedor()); // Asignar ID del proveedor
        return producto;
    }
}
