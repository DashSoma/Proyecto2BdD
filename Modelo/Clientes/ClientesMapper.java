/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Clientes;

import Modelo.Mapper.Mapper;

/**
 *
 * @author dashs
 */
public class ClientesMapper implements Mapper<Cliente, ClienteDTO> {

    @Override
   public ClienteDTO toDTO(Cliente ent) {
        return new ClienteDTO(
                ent.getCedula(),
                ent.getNombreCompleto(),
                ent.getDireccion(),
                ent.getTelefono(),
                ent.getCorreoElectronico()
        );
    }

    @Override
    public Cliente toEnt(ClienteDTO dto) {
      return new Cliente(
                dto.getCedula(),
                dto.getNombreCompleto(),
                dto.getDireccion(),
                dto.getTelefono(),
                dto.getCorreoElectronico()
        );
    }
    
}
