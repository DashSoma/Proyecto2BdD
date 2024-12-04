/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Proveedores;

import Modelo.DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dashs
 */
public class ProveedorDAO extends DAO<ProveedorDTO> {

    public ProveedorDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(ProveedorDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getId())) {
            return false;
        }
        String query = "CALL ProveedorCreate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, dto.getId());
            stmt.setString(1, dto.getNombre());
            stmt.setString(2, dto.getContacto());
            stmt.setString(3, dto.getDireccion());
            return stmt.executeUpdate() > 0;
        }

//    String query = "INSERT INTO proveedor (nombre, contacto, direccion) VALUES (?, ?, ?)";
//    try (PreparedStatement ps = connection.prepareStatement(query)) {
//        ps.setString(1, dto.getNombre());
//        ps.setString(2, dto.getContacto());
//        ps.setString(3, dto.getDireccion());
//        ps.executeUpdate();
//    }
    }

    @Override
    public ProveedorDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "CALL ProveedorRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProveedorDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                }
            }
        }
        return null;
    }

    @Override
    public List<ProveedorDTO> readAll() throws SQLException {
        String query = "CALL ProveedorReadAll";
        List<ProveedorDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new ProveedorDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)));
                }
            }
        }
        return list;
    }

    @Override
    public boolean update(ProveedorDTO dto) throws SQLException {
//    if (dto != null && dto.getId() > 0 
//    && dto.getContacto() != null && !dto.getContacto().isEmpty()) {
//}
//        if (dto != null && dto.getId() > 0) {
//            return false;
//        }
        if (dto == null) {
            return false;
        }
        String query = "CALL ProveedorUpdate(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getContacto());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || !(id instanceof Integer)) {
            return false;
        }

        String query = "CALL ProveedorDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, (Integer) id); // Realizamos el cast a Integer
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }

    public List<Proveedor> search(String filter) throws SQLException {
        List<Proveedor> lista = new ArrayList<>();
        String query = "SELECT * FROM proveedores WHERE nombre LIKE ? OR contacto LIKE ? OR direccion LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + filter + "%");
            stmt.setString(2, "%" + filter + "%");
            stmt.setString(3, "%" + filter + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("contacto"),
                        rs.getString("direccion")
                );
                lista.add(proveedor);
            }
        }
        return lista;
    }

}
