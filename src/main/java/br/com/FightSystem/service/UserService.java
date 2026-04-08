package br.com.FightSystem.service;

import br.com.FightSystem.domain.UserModel;
import br.com.FightSystem.dto.UserDTO;
import br.com.FightSystem.mapper.UserMapper;
import br.com.FightSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        UserModel userModel = UserMapper.toModel(userDTO);
        userModel = userRepository.save(userModel);
        return UserMapper.toDTO(userModel);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElse(null);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map(userModel -> {
                    userModel.setName(userDTO.name());
                    userModel.setEmail(userDTO.email());
                    userModel.setRole(userDTO.role());
                    userModel = userRepository.save(userModel);
                    return UserMapper.toDTO(userModel);
                })
                .orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
