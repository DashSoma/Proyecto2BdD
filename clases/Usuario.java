/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Crisp
 */
public class Usuario {

    private final String usuario;
    private String contraseña;
    private String codRecuperación;
    

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCodRecuperación() {
        return codRecuperación;
    }

    public Usuario(String usuario, String contraseña, String codRecuperación) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario() {
        this.usuario = "UserTComunidad6";
        this.contraseña = "TiendaElectronica123";
        this.codRecuperación = "#806$$22";
    }
}
