package br.com.FightSystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PlanDTO(
        Long id,
        @NotNull(message = "Name can`t be null")
        String name,

        @NotNull(message = "Price is necessary")
        BigDecimal price,
        String description,

        @NotNull(message = "Month Duration is necessary")
        Integer monthDuration) {
}
