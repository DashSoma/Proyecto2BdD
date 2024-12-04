/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import BaseDatos.DataBase;
import User.UserDAO;
import User.UserMapper;
import User.User;
import User.UserDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import vista.Vista;

/**
 *
 * @author DaniTini
 */
public class UserControlador {

    private UserDAO dao;
    private final Vista vista;
    private final UserMapper mapper;

    public UserControlador(Vista vista) {
        this.vista = vista;
        mapper = new UserMapper();

        try {
            dao = new UserDAO(DataBase.getConnection());
        } catch (SQLException ex) {
            vista.showError("Error al conectar con la Base de Datos");
        }
    }

    public boolean create(User log) throws SQLException {
        if (log == null || !validateRequired(log)) {
            vista.showError("Faltan datos requeridos");
            return false;
        }
        try {
            dao.create(mapper.toDTO(log));
            vista.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            vista.showError("Ocurrió un error al guardar los datos: " + ex.getMessage());
        }
        return false;
    }

    public boolean validateRequired(User log) {
        return log.getNombre() != null && !log.getNombre().trim().isEmpty()
                && log.getCorreo() != null && !log.getCorreo().trim().isEmpty()
                && log.getPass() != null && !log.getPass().trim().isEmpty();
    }

    public void readAll() {
        try {
            List<UserDTO> dtoList = dao.readAll();
            List<User> UserList = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            vista.showAll(UserList);
        } catch (SQLException ex) {
            vista.showError("Error al cargar los datos: " + ex.getMessage());
        }
    }
    
    public void read() {
    }

    public boolean validatePK(int id) {
        try {
            return dao.validatePk(id);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
}
