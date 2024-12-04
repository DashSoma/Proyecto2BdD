/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Modelo.DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dashs
 */
public class UserDAO extends DAO<UserDTO> {

    public UserDAO(Connection connection) {
        super(connection);
    }

    public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }
    @Override
    public boolean create(UserDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getId())) {
            return false;
        }
        String query = "CALL UsuariosCreate(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, dto.getId());
            stmt.setString(1, dto.getNombre());
            stmt.setString(2, dto.getCorreo());
            stmt.setString(3, dto.getPass());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public UserDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "SELECT Id, Nombre, Correo, Pass from usuarios where id = pId(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UserDTO(
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
    public List<UserDTO> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(UserDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
