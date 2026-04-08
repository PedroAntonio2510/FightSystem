package br.com.FightSystem.dto;

import lombok.Builder;

@Builder
public record GymDTO(Long id, String name, String address) {
}
