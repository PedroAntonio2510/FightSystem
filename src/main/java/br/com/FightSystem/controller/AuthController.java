package br.com.FightSystem.controller;

import br.com.FightSystem.domain.UserModel;
import br.com.FightSystem.dto.LoginRequestDTO;
import br.com.FightSystem.dto.UserDTO;
import br.com.FightSystem.repository.UserRepository;
import br.com.FightSystem.config.TokenService;
import br.com.FightSystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, TokenService tokenService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO request) {
        UsernamePasswordAuthenticationToken userAndEmail = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndEmail);
        UserModel user = (UserModel) authenticate.getPrincipal();
        String token = tokenService.generateJwtToken(user);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
