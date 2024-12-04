/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import BaseDatos.DataBase;
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
public class UserDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean update(UserDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "UPDATE usuarios SET pass = ? WHERE user = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setString(2, dto.getPass());
            return stmt.executeUpdate() > 0;
        }
    }

    public User log(String user, String pass) {
        User l = new User();
        String sql = "SELECT * FROM usuarios WHERE user= ? AND pass = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }

}
