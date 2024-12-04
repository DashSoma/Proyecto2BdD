/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import BaseDatos.DataBase;
import User.LoginDAO;
import User.LoginMapper;
import User.login;
import java.sql.SQLException;
import vista.Vista;

/**
 *
 * @author DaniTini
 */
public class UserControlador {

    private LoginDAO dao;
    private final Vista vista;
    private final LoginMapper mapper;

    public UserControlador(Vista vista) {
        this.vista = vista;
        mapper = new LoginMapper();

        try {
            dao = new LoginDAO(DataBase.getConnection());
        } catch (SQLException ex) {
            vista.showError("Error al conectar con la Base de Datos");
        }
    }

    public boolean create(login log) throws SQLException {
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

    public boolean validateRequired(login log) {
        return log.getNombre() != null && !log.getNombre().trim().isEmpty()
                && log.getCorreo() != null && !log.getCorreo().trim().isEmpty()
                && log.getPass() != null && !log.getPass().trim().isEmpty();
    }
}
