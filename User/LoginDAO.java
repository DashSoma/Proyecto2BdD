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
public class LoginDAO extends DAO<LoginDTO> {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    

    public login log(String nombre, String pass) {
        login l = new login();
        String sql = "SELECT * FROM usuarios WHERE nombre= ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
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

    public boolean create(login dto) throws SQLException {
        if (dto == null || !validatePk(dto.getId())) {
            return false;
        }
        String query = "CREATE into usuarios(Nombre, Correo, Pass) values (pNombre, pCorreo, pPass) (?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
//            stmt.setInt(1, dto.getId());
            stmt.setString(1, dto.getNombre());
            stmt.setString(2, dto.getCorreo());
            stmt.setString(3, dto.getPass());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }
    
//    public boolean validatePk(Object id) throws SQLException {
//    String query = "SELECT COUNT(*) FROM usuarios WHERE id = ?";
//    try (PreparedStatement stmt = con.prepareStatement(query)) {
//        stmt.setObject(1, id);
//        try (ResultSet rs = stmt.executeQuery()) {
//            if (rs.next()) {
//                return rs.getInt(1) == 0; // Si el conteo es 0, no existe el id
//            }
//        }
//    }
//    return false; 
//}

    
    public boolean create(LoginDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getId())) {
            return false;
        }
        String query = "CREATE into usuarios(Nombre, Correo, Pass) values (pNombre, pCorreo, pPass) (?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
//            stmt.setInt(1, dto.getId());
            stmt.setString(1, dto.getNombre());
            stmt.setString(2, dto.getCorreo());
            stmt.setString(3, dto.getPass());
            return stmt.executeUpdate() > 0;
        }
    }

   
    public login read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "SELECT Id, Nombre, Correo, Pass from usuarios where id = pId(?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new login(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                }
            }
        }
        return null;
    }
}
        

