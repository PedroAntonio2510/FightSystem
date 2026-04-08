package br.com.FightSystem.dto;

import lombok.Builder;

@Builder
public record UserDTO(
        Long id,
        String name,
        String email,
        String role
) {
}
