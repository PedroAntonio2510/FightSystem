package br.com.FightSystem.dto;

import lombok.Builder;

@Builder
public record JwtUserData(String email, String token) {
}
