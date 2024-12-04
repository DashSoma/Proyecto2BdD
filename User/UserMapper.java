/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Modelo.Mapper.Mapper;

/**
 *
 * @author dashs
 */
public class UserMapper implements Mapper<User, UserDTO>{

    @Override
    public UserDTO toDTO(User ent) {
        return new UserDTO(
                ent.getId(),
                ent.getNombre(),
                ent.getCorreo(),
                ent.getPass()
        );
    }

    @Override
    public User toEnt(UserDTO dto) {
        return new User(
                dto.getId(),
                dto.getNombre(),
                dto.getCorreo(),
                dto.getPass()
        );
    }
    
}
