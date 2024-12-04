package Modelo.Producto;

import Modelo.DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO extends DAO<ProductosDTO> {

    public ProductosDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(ProductosDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getCodigo())) {
            return false;
        }
        String query = "Call ProductoCreate(?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getCodigo());
            stmt.setString(2, dto.getNombre());
            stmt.setString(3, dto.getCategoria());
            stmt.setDouble(4, dto.getPrecio());
            stmt.setInt(5, dto.getCantDisponible());
            stmt.setInt(6, dto.getProveedor());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public ProductosDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call ProductoRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(id.toString()));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductosDTO(
                            rs.getInt(1), // Código
                            rs.getString(2), // Nombre
                            rs.getString(3), // Categoría
                            rs.getDouble(4), // Precio
                            rs.getInt(5), // Cantidad disponible
                            rs.getInt(6) // Proveedor (ID)
                    );
                }
            }
            return null;
        }
    }

    @Override
    public List<ProductosDTO> readAll() throws SQLException {
        String query = "Call ProductoReadAll()";
        List<ProductosDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new ProductosDTO(
                        rs.getInt(1), // Código
                        rs.getString(2), // Nombre
                        rs.getString(3), // Categoría
                        rs.getDouble(4), // Precio
                        rs.getInt(5), // Cantidad disponible
                        rs.getInt(6)));
            }
        }
        return list;
    }

    @Override
    public boolean update(ProductosDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call ProductoUpdate(?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getCodigo());
            stmt.setString(2, dto.getNombre());
            stmt.setString(3, dto.getCategoria());
            stmt.setDouble(4, dto.getPrecio());
            stmt.setInt(5, dto.getCantDisponible());
            stmt.setInt(6, dto.getProveedor());
            return stmt.executeUpdate() > 0;
        }

    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call ProductoDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(id.toString()));
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }
}
