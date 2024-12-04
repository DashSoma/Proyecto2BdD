/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Clientes;

import Modelo.DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author munoz
 */
public class ClienteDAO extends DAO<ClienteDTO> {
//holi
    public ClienteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(ClienteDTO dto) throws SQLException {
        if (dto == null || !validatePK(dto.getCedula())) {
            return false;
        }
        String query = "Call ClienteCreate(?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getCedula());
            stmt.setString(2, dto.getNombreCompleto());
            stmt.setString(3, dto.getDireccion());
            stmt.setString(4, dto.getTelefono());
            stmt.setString(5, dto.getCorreoElectronico());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public ClienteDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call ClienteRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ClienteDTO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5));
                }
            }
        }
        return null;
    }

    @Override
    public List<ClienteDTO> readAll() throws SQLException {
        String query = "Call ClienteReadAll()";
        List<ClienteDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new ClienteDTO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)));
                }
            }
        }
        return list;
    }

    @Override
    public boolean update(ClienteDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call ClienteUpdate(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getCedula());
            stmt.setString(2, dto.getDireccion());
            stmt.setString(3, dto.getTelefono());
            stmt.setString(4, dto.getCorreoElectronico());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call ClienteDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }

    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }
    
    
        public void deleteByCedula(String cedula) {
          String sql = "DELETE FROM clientes WHERE cedula = ?"; 

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, cedula);
            
           
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected == 0) {
                throw new SQLException("No se encontró un cliente con la cédula: " + cedula);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el cliente: " + e.getMessage(), e);
        }
    
    }

}
