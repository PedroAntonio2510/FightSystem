package br.com.FightSystem.config;

import br.com.FightSystem.domain.UserModel;
import br.com.FightSystem.dto.JwtUserData;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateJwtToken(UserModel user) {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("fight-system")
                    .withSubject(user.getEmail())
                    .withClaim("role", user.getRole())
                    .withExpiresAt(Instant.now().plusSeconds(3600L))
                    .sign(algorithm);
    }

    public String validateJwtToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("fight-system")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    public Optional<JwtUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JwtUserData.builder()
                    .email(jwt.getSubject())
                    .build());
        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }

}
