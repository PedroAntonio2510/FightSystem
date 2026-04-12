package br.com.FightSystem.mapper;

import br.com.FightSystem.domain.UserModel;
import br.com.FightSystem.dto.UserDTO;
import org.springframework.stereotype.Component;


public class UserMapper {

    public static UserDTO toDTO(UserModel userModel) {
        return UserDTO.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .role(userModel.getRole())
                .build();
    }

    public static UserModel toModel(UserDTO userDTO) {
        return UserModel.builder()
                .id(userDTO.id())
                .name(userDTO.name())
                .email(userDTO.email())
                .password(userDTO.password())
                .role(userDTO.role())
                .build();
    }
}
