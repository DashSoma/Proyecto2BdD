/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dashs
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        try{
            String myBD = "jdbc:mysql://127.0.0.1:3306/tiendaelectronica";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return null;
    }
    
}
