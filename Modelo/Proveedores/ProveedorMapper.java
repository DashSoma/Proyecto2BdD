/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Proveedores;

import Modelo.Mapper.Mapper;
import java.sql.SQLException;

/**
 *
 * @author dashs
 */
public class ProveedorMapper implements Mapper<Proveedor, ProveedorDTO>{

    @Override
    public ProveedorDTO toDTO(Proveedor ent) {
        return new ProveedorDTO(
                ent.getId(),
                ent.getNombre(),
                ent.getContacto(),
                ent.getDireccion()
        );
    }

    @Override
    public Proveedor toEnt(ProveedorDTO dto) {
        return new Proveedor(
                dto.getId(),
                dto.getNombre(),
                dto.getContacto(),
                dto.getDireccion()
        );
    }

}
