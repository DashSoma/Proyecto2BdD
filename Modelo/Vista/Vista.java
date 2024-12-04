/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.Vista;

import Modelo.Clientes.Cliente;
import java.util.List;

/**
 *
 * @author dashs
 */
public interface Vista<Ent> {

    public void show(Ent ent);

    public void showAll(List<Ent> ents);

    public void showMessage(String msg);

    public void showError(String err);

    public void showWarnig(String warning);

    public boolean validateRequired();
}
