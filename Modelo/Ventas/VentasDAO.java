/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Ventas;

import Modelo.DAO.DAO;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DaniTini
 */
public class VentasDAO extends DAO<VentasDTO> {

    public VentasDAO(Connection connection) {
        super(connection);
    }

     public boolean validatePk(Object id) throws SQLException {
        return read(id) == null;
    }
     
    @Override
    public boolean create(VentasDTO dto) throws SQLException {
        if (dto == null || !validatePk(dto.getCodigoProducto())) {
        return false;
    }

    String query = "Call VentasCreate(?,?,?,?,?,?,?,?,?,?,?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, dto.getIdPlanilla());
        stmt.setDate(2, java.sql.Date.valueOf(dto.getFechaRecibo()));
        stmt.setInt(3, dto.getCedulaEmpleado());
        stmt.setString(4, dto.getNomEmpleado());
        stmt.setInt(5, dto.getCodigoProducto());
        stmt.setString(6, dto.getNombreProducto());
        stmt.setInt(7, dto.getPrecioProducto());
        stmt.setInt(8, dto.getCantVendidos());
        stmt.setInt(9, dto.getSubTotal());
        stmt.setInt(10, dto.getImpuestos());
        stmt.setInt(11, dto.getTotal());
        
        return stmt.executeUpdate() > 0;
    }
        
    }

    @Override
    public VentasDTO read(Object id) throws SQLException {
 if (id == null || String.valueOf(id).trim().isEmpty()) {
        return null;
    }
    String query = "Call ReadRead(?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, Integer.parseInt(id.toString()));
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new VentasDTO(
                        rs.getInt(1), // idPlanilla
                        rs.getDate(2).toLocalDate(), // fechaRecibo
                        rs.getInt(3), // cedulaEmpleado
                        rs.getString(4), // nomEmpleado
                        rs.getInt(5), // codigoProducto
                        rs.getString(6), // nombreProducto
                        rs.getInt(7), // precioProducto
                        rs.getInt(8), // cantVendidos
                        rs.getInt(9), // subTotal
                        rs.getInt(10), // impuestos
                        rs.getInt(11) // total
                );
            }
        }
        return null;
    }    }

    @Override
    public List<VentasDTO> readAll() throws SQLException {
String query = "Call VentasReadAll()";
    List<VentasDTO> list = new ArrayList<>();
    try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            list.add(new VentasDTO(
                    rs.getInt(1), // idPlanilla
                    rs.getDate(2).toLocalDate(), // fechaRecibo
                    rs.getInt(3), // cedulaEmpleado
                    rs.getString(4), // nomEmpleado
                    rs.getInt(5), // codigoProducto
                    rs.getString(6), // nombreProducto
                    rs.getInt(7), // precioProducto
                    rs.getInt(8), // cantVendidos
                    rs.getInt(9), // subTotal
                    rs.getInt(10), // impuestos
                    rs.getInt(11) // total
            ));
        }
    }
    return list;    }

    @Override
    public boolean update(VentasDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
