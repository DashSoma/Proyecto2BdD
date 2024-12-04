/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Modelo.Mapper.Mapper;
import Modelo.Proveedores.Proveedor;
import Modelo.Proveedores.ProveedorDTO;

/**
 *
 * @author Usuario
 */
public class LoginMapper implements Mapper<login, LoginDTO> {

    @Override
    public LoginDTO toDTO(login ent) {

        return new LoginDTO(
                ent.getId(),
                ent.getNombre(),
                ent.getCorreo(),
                ent.getPass()
        );
    }

    @Override
    public login toEnt(LoginDTO dto) {
        return new login(
                dto.getId(),
                dto.getNombre(),
                dto.getCorreo(),
                dto.getPass()
        );
    }
}
