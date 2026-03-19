package br.com.FightSystem.domain.dto;

import java.math.BigDecimal;

public record PlanDTO(
        Long id,
        String name,
        BigDecimal price,
        String description,
        Integer monthDuration) {
}
