package br.com.FightSystem.service;

import br.com.FightSystem.domain.UserModel;
import br.com.FightSystem.dto.UserDTO;
import br.com.FightSystem.exceptions.ExistingEmailException;
import br.com.FightSystem.mapper.UserMapper;
import br.com.FightSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UserModel createUser(UserDTO userDTO) {
        validate(userDTO.email());
        UserModel userModel = UserMapper.toModel(userDTO);
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
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
                    if (!userModel.getEmail().equals(userDTO.email())) {
                        validate(userDTO.email());
                    }
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

    public void validate(String email) {
        userRepository.findByEmail(email).ifPresent(user -> {
            throw new ExistingEmailException("Email already registered try again");
        });
    }
}
