package br.com.FightSystem.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ClassDTO(
        Long id,
        String name,
        String classType,
        LocalDateTime startTime,
        Long gymId
) {
}
